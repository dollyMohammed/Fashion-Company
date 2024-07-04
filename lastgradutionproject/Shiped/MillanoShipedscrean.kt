package com.example.lastgradutionproject.Shiped

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.prossing.Cancel
import com.example.lastgradutionproject.screans.ClientScreans.prossing.TabsComponent
import com.example.lastgradutionproject.screans.ClientScreans.prossing.submet

@Composable
fun shipped(navController: NavController) {
    Surface(color = Color.White) {


        Row {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.prossingscrean.name)
                    }


            )
            Spacer(modifier = Modifier.width(65.dp))
            Text(
                text = " Myorder",
                fontWeight = FontWeight.Bold, fontSize = 24.sp,
                modifier = Modifier.padding(top = 20.dp)
            )


        }




        Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top = 100.dp, start = 10.dp)) {
            TabsComponent(navController = navController)
            Spacer(modifier = Modifier.height(30.dp))
            Row {
                Card (modifier = Modifier
                    //.padding(start = 10.dp)
                    .width(100.dp)
                    .height(100.dp),
                    shape = RoundedCornerShape(corner = CornerSize(8.dp))
                ){

                }

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Product Code", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Price", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Status", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(10.dp))

            Card (modifier = Modifier
                .padding(start = 0.dp)
                .fillMaxWidth()
                .height(8.dp),
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ){

            }
            Spacer(modifier = Modifier.height(20.dp))

            Row {
                Card (modifier = Modifier
                    //.padding(start = 10.dp)
                    .width(100.dp)
                    .height(100.dp),
                    shape = RoundedCornerShape(corner = CornerSize(8.dp))
                ){

                }

            }
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Product Code", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Price", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "Status", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(35.dp))

            Row (modifier = Modifier.padding(start = 35.dp)){
                cancel(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                    // validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                    // navController.navigate(MillanoScreans.aftersignUpscrean.name)

                }
                Spacer(modifier = Modifier.width(40.dp))

                submt(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                    // validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                    navController.navigate(MillanoScreans.confirmscrean.name)

                }



            }
            Spacer(modifier = Modifier.height(10.dp))



        }
    }
}
@Composable
fun cancel(
    //loading: Boolean,
    // validInputs: Boolean,
    onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(125.dp)
            .height(40.dp),
        //.padding(start = 34.dp, end = 34.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        //enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Re-Order", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
@Composable
fun submt(
    //loading: Boolean,
    // validInputs: Boolean,
    onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
        //.padding(start = 34.dp, end = 34.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        // enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Confirm", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
