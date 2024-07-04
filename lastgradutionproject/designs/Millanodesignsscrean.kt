package com.example.lastgradutionproject.designs

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.lastgradutionproject.screans.ClientScreans.History.MovieRow

@Composable
fun mydesigns(navController: NavController,
              movieList:List<String> = listOf("Item1","Item2","Item3","Item4","Item5","Item6","Item7")
) {
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
            Spacer(modifier = Modifier.width(75.dp))
            Text(
                text = "MyDesigns",
                fontWeight = FontWeight.Bold, fontSize = 23.sp,
                modifier = Modifier.padding(top = 50.dp)
            )



        }
        Column(modifier = Modifier.padding(top = 120.dp)) {
            LazyColumn{
                items(items = movieList){

                    MovieRo(navController = navController, movie = it)                }

            }






        }


    }
}
@Composable
fun MovieRo(navController: NavController,
             movie:String){
    Card (modifier = Modifier
        .padding(6.dp)
        .fillMaxWidth()
        .height(120.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp)),
        colors = CardDefaults.cardColors(contentColor = Color.DarkGray),

        border = BorderStroke(width = 2.dp, color = Color.Black)



    ){
        Text(text = movie)
    }

}