package com.example.lastgradutionproject.screans.ClientScreans.password

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Login.emailFailed

@Composable
fun passwoed(navController: NavController,
             loading:Boolean=false,
             isCreatAcount:Boolean=false,
             onDone:(String) -> Unit = {email -> }
){
    val Email = rememberSaveable {
        mutableStateOf("")

    }
    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(Email.value) {
        Email.value.trim().isNotEmpty()
    }
    Surface (color = Color.White) {
        Column (

            modifier = Modifier.padding(top = 190.dp, start = 10.dp)
        ){
            Text(text = "Forget Password?", color = Color.LightGray, fontSize = 27.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp))
            Spacer(modifier = Modifier.height(50.dp))

            com.example.lastgradutionproject.screans.ClientScreans.Login.Email(
                navController = navController,
                Email = Email,
                enabled = !loading,
                onAction = KeyboardActions {
                })
            Spacer(modifier = Modifier.height(60.dp))

            LoginButton(
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                loading = loading,
                validInputs = valid
            ) {
                onDone(Email.value.trim())
                navController.navigate(MillanoScreans.codescrean.name)

            }



        }
    }
    }
@Composable
fun Email(
    navController: NavController,
    modifier: Modifier = Modifier,
    Email: MutableState<String>,
    labelId:String="Email",
    enabled:Boolean=true,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
){
    emailFailed( navController=navController,
        modifier= Modifier,
        emailState=Email
        ,labelId=labelId,
        enabled=enabled
        ,imeAction=imeAction,
        keyboardType= KeyboardType.Email,
        onAction=onAction)


}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun emailFailed(
    navController: NavController,
    modifier: Modifier = Modifier,
    emailState: MutableState<String>,
    labelId:String,
    enabled:Boolean,
    isSingleLine:Boolean=true,
    keyboardType: KeyboardType = KeyboardType.Email,
    imeAction: ImeAction = ImeAction.Next,
    onAction: KeyboardActions = KeyboardActions.Default,
) {
    OutlinedTextField(
        value = emailState.value,
        onValueChange = { emailState.value=it },
        modifier= Modifier
            .padding(start = 10.dp, end = 10.dp)
            .fillMaxWidth(),
        label = {Text(text = labelId) },
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
fun LoginButton(loading: Boolean,
                validInputs: Boolean,
                onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(375.dp)
            .height(45.dp)
            .padding(start = 30.dp, end = 30.dp),
        shape = RoundedCornerShape(corner = CornerSize(15.dp)),
        enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Continue", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
