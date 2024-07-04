package com.example.lastgradutionproject.confirm

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.Emaiil

@Composable
fun confirm(
    navController: NavController,
    loading: Boolean = false,
){
    val context= LocalContext.current

    val Address= rememberSaveable {
        mutableStateOf("")

    }
    val Name= rememberSaveable {
        mutableStateOf("")

    }
    val Phone= rememberSaveable {
        mutableStateOf("")

    }


    Surface(color = Color.White) {
        Row {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.shipedscrean.name)
                    }


            )
            Spacer(modifier = Modifier.width(65.dp))
            Text(
                text = "Confirme order",
                fontWeight = FontWeight.Bold, fontSize = 24.sp,
                modifier = Modifier.padding(top = 20.dp)
            )


        }
        Column(
            modifier = Modifier.padding(top = 80.dp, bottom = 20.dp)
        ) {
            Row (                    modifier = Modifier.padding(top = 20.dp)
            ){
                Text(
                    text = " Delivery Info",
                    fontWeight = FontWeight.Bold, fontSize = 18.sp,
                    color = Color.Black
                )
                Spacer(modifier = Modifier.width(190.dp))
                Text(
                    text = "Change",
                    fontWeight = FontWeight.Bold, fontSize = 21.sp,
                    color = Color.LightGray
                )



            }
            Spacer(modifier = Modifier.height(35.dp))


            Emaiil(
                navController = navController,
                Name = Address,
                labelId = "Address",
                enabled = !loading
            )
            Emaiil(
                navController = navController,
                Name = Name,
                labelId = "Name",
                enabled = !loading
            )
            Emaiil(
                navController = navController,
                Name = Phone,
                labelId = "Phone",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(10.dp))
            Card (modifier = Modifier
                //.padding(start = 0.dp)
                .fillMaxWidth()
                .height(24.dp),
                shape = RectangleShape
            ){
                Text(
                    text = "Delivery Time : it will be delivered at 10 days          ",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "product",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "price : 330$",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            /*Text(
                text = "Total",
                fontWeight = FontWeight.SemiBold,
                color = Color.Black,
                modifier = Modifier.padding(start = 4.dp)
            )*/
            Spacer(modifier = Modifier.height(30.dp))
            Card (modifier = Modifier
                //.padding(start = 0.dp)
                .fillMaxWidth()
                .height(24.dp),
                shape = RectangleShape
            ){
                Text(
                    text = "Note",
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }
            Spacer(modifier = Modifier.height(10.dp))
            Emaiil(
                navController = navController,
                Name = Phone,
                labelId = "Note any thing",
                enabled = !loading
            )
            Spacer(modifier = Modifier.height(55.dp))
            submt(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                //loading = loading,
                // validInputs = valid
            ) {
                // onDone(Email.value.trim(), password.value.trim())
               // Toast.makeText(`$context$`, "\$text$", Toast.LENGTH_SHORT).show()
                Toast.makeText(context,"Done...",Toast.LENGTH_SHORT).show()
                navController.navigate(MillanoScreans.HomeScrean.name)

            }









        }

    }
    }
@Composable
fun submt(
    modifier: Modifier,
    //loading: Boolean,
    // validInputs: Boolean,
    onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(250.dp)
            .height(40.dp)
            .padding(start = 84.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        // enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Confirm", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
