package com.example.lastgradutionproject.screans.DesignerScreans

import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheetProperties
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myCountry
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myName
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myPhone
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.Emaiil
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.emailFaiiled

@Composable
fun DescribeDesign(navController: NavController,
                   loading:Boolean=false,
                   isCreatAcount:Boolean=false,
                   onDone:(String,String,String,String) -> Unit = {nn,cc,poh,ccc -> }
) {
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val signalphotoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri })
    val designname = rememberSaveable {
        mutableStateOf("")

    }
    val designtype = rememberSaveable {
        mutableStateOf("")

    }
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val context = LocalContext.current
    val bitmap = remember {
        mutableStateOf<Bitmap?>(null)

    }
    val lancher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
        }

    val designcolor = rememberSaveable {
        mutableStateOf("")

    }
    val describtion = rememberSaveable {
        mutableStateOf("")

    }


    val keyboardController = LocalSoftwareKeyboardController.current
    val valid = remember(designname.value, designtype.value, designcolor.value, describtion.value) {
        designname.value.trim().isNotEmpty() && designtype.value.trim()
            .isNotEmpty() && designcolor.value.trim()
            .isNotEmpty() && describtion.value.trim().isNotEmpty()

    }


     Surface(color = Color.White) {


        Row {
            Icon(imageVector = Icons.Default.KeyboardArrowLeft, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.aftersignUpscrean.name)
                    }


            )


        }
        Column(
            //verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 110.dp)
        ) {

            emaiil(
                navController = navController,
                Name = designname,
                labelId = "Design Name",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(10.dp))
            Emaiil(
                navController = navController,
                Name = designtype,
                labelId = "Design Type",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(10.dp))

            Emaiil(
                navController = navController,
                Name = designcolor,
                labelId = "Design Color",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(10.dp))

            myPhone(
                modifier = Modifier,
                navController = navController,
                phonestate = describtion,
                // passwordVisibility = passwordVisability,
                labelId = "Describtion",
                enabled = !loading,
                onAction = KeyboardActions {
                    // passwordVisability=passwordVisability
                    if (!valid) return@KeyboardActions
                    onDone(designname.value.trim(), designtype.value.trim(), designcolor.value.trim(),describtion.value.trim())
                })
            Spacer(modifier = Modifier.height(17.dp))
            Text(text = "Add Photo", fontWeight = FontWeight.Bold, color = Color.Black,
                modifier = Modifier.padding( start = 2.dp))
            Card (modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(20.dp)
                .clickable {
                    /* signalphotoPickerLauncher.launch(
                               PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                           )*/
                    //lancher.launch("*image/*")


                },
                shape = RectangleShape,
                border = BorderStroke(width = 1.dp, color = Color.DarkGray),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){
                
            }
           /* imageUri?.let {
                if (Build.VERSION.SDK_INT < 28){
                    bitmap.value= MediaStore.Images
                        .Media.getBitmap(context.contentResolver,it)
                }else{
                    val source = ImageDecoder.createSource(context.contentResolver,it)
                    bitmap.value= ImageDecoder.decodeBitmap(source)
                }
                bitmap.value?.let {btn ->
                    Image(
                        bitmap=btn.asImageBitmap(),
                        contentDescription = null,
                        modifier = Modifier
                            .size(410.dp)
                            .padding(20.dp)
                    )

                }

            }*/

Spacer(modifier = Modifier.height(25.dp))
            Text(text = "Show my Designs", fontWeight = FontWeight.Bold, color = Color.Black,
                modifier = Modifier
                    .padding(start = 200.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.myDesignsScreans.name)
                    })
            Spacer(modifier = Modifier.height(70.dp))

            sbmt(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                //loading = loading,
                // validInputs = valid
            ) {
                // onDone(Email.value.trim(), password.value.trim())
                navController.navigate(MillanoScreans.HomeScrean.name)

            }






        }
        LazyColumn{
            item {
                AsyncImage(
                    model = selectedImageUri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )

            }
           /* items(selectedImageUri){uri ->
                AsyncImage(
                    model = uri,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )


            }*/
        }

    }
}


    @Composable
    fun sbmt(
        modifier: Modifier,
        //loading: Boolean,
        // validInputs: Boolean,
        onClick: () -> Unit
    ) {
        Button(
            onClick = onClick,
            modifier = Modifier
                .width(260.dp)
                .height(40.dp)
                .padding(start = 30.dp),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            // enabled = !loading && validInputs,
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
        ) {

            Text(
                text = "Submet",
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 19.sp
            )
            // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
        }


    }


    @Composable
    fun emaiil(
        navController: NavController,
        modifier: Modifier = Modifier,
        Name: MutableState<String>,
        labelId: String = "UserName",
        enabled: Boolean = true,
        imeAction: ImeAction = ImeAction.Next,
        onAction: KeyboardActions = KeyboardActions.Default,
    ) {
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
        labelId: String,
        enabled: Boolean,
        isSingleLine: Boolean = true,
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
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = imeAction
            ),
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


     /*   @Composable
        fun emaill(
            navController: NavController,
            modifier: Modifier = Modifier,
            Name: MutableState<String>,
            labelId: String = "UserName",
            enabled: Boolean = true,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
            emailfaild(
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
        fun emailfaild(
            navController: NavController,
            modifier: Modifier = Modifier,
            emaiilState: MutableState<String>,
            labelId: String,
            enabled: Boolean,
            isSingleLine: Boolean = true,
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
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
        fun email(
            navController: NavController,
            modifier: Modifier = Modifier,
            Name: MutableState<String>,
            labelId: String = "UserName",
            enabled: Boolean = true,
            imeAction: ImeAction = ImeAction.Next,
            onAction: KeyboardActions = KeyboardActions.Default,
        ) {
            emaiilfailed(
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
        fun emaiilfailed(
            navController: NavController,
            modifier: Modifier = Modifier,
            emaiilState: MutableState<String>,
            labelId: String,
            enabled: Boolean,
            isSingleLine: Boolean = true,
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
                keyboardOptions = KeyboardOptions(
                    keyboardType = keyboardType,
                    imeAction = imeAction
                ),
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
    }

    */

