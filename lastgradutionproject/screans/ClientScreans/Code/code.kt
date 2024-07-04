package com.example.lastgradutionproject.screans.ClientScreans.Code

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.Emaiil
import com.example.lastgradutionproject.screans.ClientScreans.password.LoginButton

@Composable
fun EnterCode(navController: NavController,
              loading:Boolean=false,
              isCreatAcount:Boolean=false,
              onDone:(String) -> Unit = {pass -> }
) {
    val passcode = rememberSaveable {
        mutableStateOf("")

    }
    val valid = remember(passcode.value) {
        passcode.value.trim().isNotEmpty()


    }
    Surface(color = Color.White) {

        Column(
            modifier = Modifier.padding(top = 190.dp, start = 10.dp)

        ) {
            Text(
                text = "Enter your Verification Code we have sent to you",
                color = Color.LightGray, fontSize = 22.sp, fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(50.dp))


            Emaiil(
                navController = navController,
                Name = passcode,
                labelId = "Enter Code",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(60.dp))
            LoginButtn(
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                loading = loading,
                validInputs = valid
            ) {
                onDone(passcode.value.trim())
                // navController.navigate(MillanoScreans.HomeScrean.name)

            }


        }
    }
}

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun emailFaiiled(
        navController: NavController,
        modifier: Modifier = Modifier,
        emaiilState: MutableState<String>,
        labelId: String,
        enabled: Boolean,
        isSingleLine: Boolean = true,
        keyboardType: KeyboardType = KeyboardType.Number,
        imeAction: ImeAction = ImeAction.Next,
        onAction: KeyboardActions = KeyboardActions.Default,
    ) {
        OutlinedTextField(
           // LeadingIcon= Icon(imageVector = Icons.Rounded.Add, contentDescription = ""),

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
fun LoginButtn(loading: Boolean,
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

        Text(text = "Submite", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}


