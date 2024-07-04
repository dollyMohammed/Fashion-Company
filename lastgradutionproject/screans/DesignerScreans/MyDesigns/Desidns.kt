package com.example.lastgradutionproject.screans.DesignerScreans.MyDesigns

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.data.Dateprovider
import com.example.lastgradutionproject.data.Puppy
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.History.MovieRow

@Composable
fun designs(navController: NavController,
            movieList:List<String> = listOf("Item1","Item2","Item3","Item4","Item5","Item6","Item7","Item7","Item7","Item7")
){
    Surface(color = Color.White) {
        val puppies= remember {
            Dateprovider.puppyList
        }


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
            Text(text = "MyDesigns" , color = Color.Black,
                fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 60.dp), fontSize = 25.sp)


        }
        Column(modifier = Modifier.padding(top = 110.dp)) {
            LazyColumn{
                items(items = puppies,


                    ){
                    MoviRow(navController = navController,puppy=it)

                                   }

            }






        }


    }

    }
@Composable
fun MoviRow(navController: NavController,
             puppy: Puppy){
    Card (modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(100.dp),
        shape = RoundedCornerShape(corner = CornerSize(10.dp))


    ){
        Row (verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){
            clothesImage(puppy = puppy)

                Column (
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                ){
                    Text(text = puppy.Name, fontWeight = FontWeight.SemiBold)
                    Text(text = puppy.Type, fontWeight = FontWeight.SemiBold)
                   // Text(text = puppy.description, fontSize = 17.sp)

                
                //Icon(imageVector = Icons.Default.AccountBox, contentDescription = "" )

            }
        }

        //Text(text = movie)
    }

}
@Composable
fun clothesImage(puppy: Puppy){
    Image(painter = painterResource(id = puppy.image), contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(4.dp)))
        )
}