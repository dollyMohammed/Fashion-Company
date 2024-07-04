package com.example.lastgradutionproject.screans.DesignerScreans.MyDesigns

import android.graphics.Bitmap
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.Edit.myPhone
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.Emaiil
import com.example.lastgradutionproject.screans.DesignerScreans.emaiil
import com.example.lastgradutionproject.screans.DesignerScreans.sbmt

@Composable
fun mydesigner(navController: NavController,
               loading:Boolean=false,
               isCreatAcount:Boolean=false,
               onDone:(String,String,String,String) -> Unit = {nn,cc,poh,ccc -> }){
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
                .height(150.dp)
                .padding(20.dp)
                .clickable {
                     signalphotoPickerLauncher.launch(
                         PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                     )
                    //lancher.launch("*image/*")


                },
                shape = RectangleShape,
                border = BorderStroke(width = 1.dp, color = Color.DarkGray),
                colors = CardDefaults.cardColors(colorResource(id = R.color.white))

            ){
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
                navController.navigate(MillanoScreans.myDesignsScreans.name)

            }






        }

    }

}



