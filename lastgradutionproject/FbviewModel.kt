package com.example.lastgradutionproject

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FbviewModel @Inject constructor(
    val auth: FirebaseAuth
):ViewModel() {
    val signedIn= mutableStateOf(false)
    val inprogress= mutableStateOf(false)
    val popNotification= mutableStateOf<Event<String> ?>(null)


    fun onsignup(email:String, pass: String){
        inprogress.value=true


        auth.createUserWithEmailAndPassword(email,pass)
            .addOnCompleteListener{
                if (it.isSuccessful){
                    signedIn.value=true
                    handelException(it.exception,"SignUp Successful")

                }else{
                    handelException(it.exception,"SignUp Failed")

                }
                inprogress.value=false
            }
    }

    fun login(email: String,pass: String){
        inprogress.value=true


        auth.signInWithEmailAndPassword(email,pass)
            .addOnCompleteListener {
                if (it.isSuccessful){
                    signedIn.value=true
                    handelException(it.exception,"Login Successful")

                }else{
                    handelException(it.exception,"Login Failed")

                }
                inprogress.value=false

            }

    }
    fun handelException(exception:Exception ? = null,customMessage: String = ""){
        exception?.printStackTrace()
        val errorMsg = exception?.localizedMessage ?: ""
        val message= if (customMessage.isEmpty()) errorMsg else "$customMessage"; "$errorMsg"
        popNotification.value = Event(message)
    }
}