package com.example.lastgradutionproject.screans.ClientScreans.beforeorder

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
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.prossing.TabsComponent

@Composable
fun BeforeOrder(navController: NavController){
    Surface (color = Color.White) {


        Row {
            Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow back",
                tint = Color.Black,
                modifier = Modifier
                    .size(45.dp)
                    .padding(start = 15.dp, top = 8.dp)
                    .clickable {
                        navController.navigate(MillanoScreans.HomeScrean.name)
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
            Spacer(modifier = Modifier.height(90.dp))
            Text(text = "Empty", fontWeight = FontWeight.Bold, color = Color.Black, fontSize = 24.sp,
                modifier = Modifier.padding(start = 145.dp))
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "your have no order yet",
                fontWeight = FontWeight.SemiBold, color = Color.DarkGray, fontSize = 17.sp,
                modifier = Modifier.padding(start = 100.dp))
            Spacer(modifier = Modifier.height(290.dp))
            submt(
                modifier = Modifier.align(Alignment.CenterHorizontally)
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                //loading = loading,
                // validInputs = valid
            ) {
                // onDone(Email.value.trim(), password.value.trim())
                navController.navigate(MillanoScreans.HomeScrean.name)

            }





        }

        }
    Column (verticalArrangement = Arrangement.Bottom){
        Card (modifier = Modifier
            .fillMaxWidth()
            .height(45.dp),
            shape = RoundedCornerShape(corner = CornerSize(7.dp)),
            colors = CardDefaults.cardColors(colorResource(id = R.color.white))
        ){
            Row {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 30.dp, top = 5.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.HomeScrean.name)

                        }

                        .size(35.dp),
                    tint = Color.Black
                )
                // Spacer(modifier = Modifier.width(30.dp))
                Icon(imageVector = Icons.Filled.ShoppingCart, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 60.dp, top = 5.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.prossingscrean.name)

                        }
                        .size(35.dp),
                    tint = Color.Black
                )
                Icon(imageVector = Icons.Filled.FavoriteBorder, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 60.dp, top = 5.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.favouritescrean.name)
                        }
                        .size(35.dp),
                    tint = Color.Black
                )
                Icon(imageVector = Icons.Filled.Person, contentDescription = "",
                    modifier = Modifier
                        .padding(start = 60.dp, top = 5.dp)
                        .clickable {
                            navController.navigate(MillanoScreans.profilescrean.name)
                        }
                        .size(35.dp),
                    tint = Color.Black
                )

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
            .width(300.dp)
            .height(40.dp)
            .padding(start = 100.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        // enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Shop now", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
        // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
