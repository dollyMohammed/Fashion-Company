package com.example.lastgradutionproject.screans.ClientScreans.aftersignup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.component.AlertDialog
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Login.Email
import com.example.lastgradutionproject.screans.ClientScreans.Login.passwordFailed
import com.example.lastgradutionproject.screans.ClientScreans.SignUp.SignUpButton
import com.example.lastgradutionproject.screans.startScrean.Name
import com.example.lastgradutionproject.screans.startScrean.nameFailed

@Composable
fun aftersignup(navController: NavController,
                loading:Boolean=false,
                isCreatAcount:Boolean=false,
                onDone:(String,String,String,String) -> Unit = {usn,email,usas,pass -> }
){
    var showDialog by remember {
        mutableStateOf(false)
    }
    if (showDialog){
        AlertDialog (onDismiss = {showDialog=false}, navController = navController)
    }
    val Name= rememberSaveable {
        mutableStateOf("")

    }
    val useras= rememberSaveable {
        mutableStateOf("")

    }

    val Email = rememberSaveable {
        mutableStateOf("")

    }
    val password = rememberSaveable {
        mutableStateOf("")

    }
    var passwordVisability = rememberSaveable {
        mutableStateOf(false)

    }
    val passwordFocusRequest = FocusRequester.Default
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(Email.value, password.value) {
     Name.value.trim().isNotEmpty()&&   Email.value.trim().isNotEmpty() &&Name.value.trim().isNotEmpty()&&  password.value.trim().isNotEmpty()

    }
    Surface(color = Color.White) {
        Column(
            //verticalArrangement = Arrangement.Center,
           // horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 220.dp, bottom = 20.dp)
        ) {
            Emaiil(navController = navController, Name = useras, labelId = "UserName", enabled = !loading)
           // Emaiil(navController = navController, Name = useras, labelId = "City", enabled = !loading)

            Spacer(modifier=Modifier.height(10.dp))
            Email(
                navController = navController,
                Email = Email,
                enabled = !loading,
                onAction = KeyboardActions {
                    passwordFocusRequest.requestFocus()
                })
            Spacer(modifier = Modifier.height(10.dp))
            Emaiil(navController = navController, Name = Name, labelId = "User As", enabled = !loading)


            Spacer(modifier = Modifier.height(10.dp))
            passwordFailed(
                modifier = Modifier.focusRequester(passwordFocusRequest),
                navController = navController,
                passwordState = password,
                passwordVisibility = passwordVisability,
                labelId = "Password",
                enabled = !loading,
                onAction = KeyboardActions {
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone( Name.value.trim(),Email.value.trim(),  useras.value.trim(),password.value.trim())

                }
            )
            Spacer(modifier=Modifier.height(50.dp))
            Button(          onClick={
                showDialog=true


            },
                modifier = Modifier
                    .width(375.dp)
                    .height(45.dp)
                    .padding(start = 34.dp, end = 34.dp),
                shape = RoundedCornerShape(corner = CornerSize(6.dp)),
                //enabled = !loading && validInputs,
                colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
            ) {


                Text(text = "SignUp As", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)

                if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
            }


            /* SignUpButto(
                 //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                 loading = loading,
                 validInputs = valid
             ) {
                 onDone( Name.value.trim(),Email.value.trim(), useras.value.trim(), password.value.trim())
                // navController.navigate(MillanoScreans.HomeScrean.name)

             }*/


        }


    }

    }
@Composable
fun Emaiil(
    navController: NavController,
    modifier: Modifier = Modifier,
    Name: MutableState<String>,
    labelId:String="UserName",
    enabled:Boolean=true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
){
    emailFaiiled(
        navController = navController,
        modifier = Modifier,
        emaiilState = Name, labelId = labelId,
        enabled = enabled, imeAction = imeAction,
        keyboardType = KeyboardType.Text,
        onAction = onAction
    )


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun emailFaiiled(
    navController: NavController,
    modifier: Modifier = Modifier,
    emaiilState: MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = emaiilState.value,
        onValueChange = { emaiilState.value = it },
        modifier = Modifier
            .padding(start = 18.dp, end = 18.dp)
            .fillMaxWidth(),
        label = { Text(text = labelId) },
        enabled = enabled, singleLine = isSingleLine,
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        keyboardActions = onAction, textStyle = MaterialTheme.typography.bodyLarge,
        shape = RoundedCornerShape(5.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            // focusedBorderColor = Color.Black,
            //unfocusedBorderColor = Color.Black,
            cursorColor = colorResource(id = R.color.black),
            // textColor = colorResource(id = R.color.Brown),
            // leadingIconColor = colorResource(id = R.color.Brown),
            //trailingIconColor = colorResource(id = R.color.Brown),
            errorCursorColor = colorResource(id = R.color.Brown),
            errorLeadingIconColor = colorResource(id = R.color.Brown),
            errorTrailingIconColor = colorResource(id = R.color.Brown),
            errorTextColor = colorResource(id = R.color.Brown),
            errorBorderColor = colorResource(id = R.color.Brown),
        ),
        //
        //BorderStroke(width = 5.dp, color = Color.Black)
    )

}
@Composable
fun SignUpButto(loading: Boolean,
                 validInputs: Boolean,
                 onClick: () -> Unit,
    // va: FbviewModel
) {



}

