package com.example.lastgradutionproject.screans.ClientScreans.prossing

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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.lastgradutionproject.R
import com.example.lastgradutionproject.module.Movie
import com.example.lastgradutionproject.module.getmovies
import com.example.lastgradutionproject.navigation.MillanoScreans
import com.example.lastgradutionproject.screans.ClientScreans.HomeScrean.MovieRow
import com.example.lastgradutionproject.tabs

@Composable
fun prossing(navController: NavController,

    //  movieId: String?,
             movielist:List<Movie> = getmovies(),
            // movie: Movie = getmovies()[0]
){
    /*val newMovieList = getmovies().filter { movie ->
        movie.id == movieId

    }*/

    Surface (color = Color.White){


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
            LazyColumn{
                items(
                    items = movielist){

                    prosses(movie=it, navController = navController){ movie ->
                        navController.navigate(route=MillanoScreans.prossingscrean.name+"/$movie")

                    }


                }

                // prosses(navController = navController)
            }
           /* Spacer(modifier = Modifier.height(30.dp))
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

            Text(text="", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(15.dp))

            Text(text = "shiping", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
            Spacer(modifier = Modifier.height(35.dp))

            Row (modifier = Modifier.padding(start = 35.dp)){
                Cancel(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                   // validInputs = valid
                ) {
                   // onDone(Email.value.trim(), password.value.trim())
                   // navController.navigate(MillanoScreans.aftersignUpscrean.name)

                }
                Spacer(modifier = Modifier.width(40.dp))

                submet(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                    // validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                     navController.navigate(MillanoScreans.shipedscrean.name)

                }



            }
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
                Cancel(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                    // validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                    // navController.navigate(MillanoScreans.aftersignUpscrean.name)

                }
                Spacer(modifier = Modifier.width(40.dp))

                submet(
                    //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                    //loading = loading,
                    // validInputs = valid
                ) {
                    // onDone(Email.value.trim(), password.value.trim())
                     navController.navigate(MillanoScreans.shipedscrean.name)

                }



            }
            Spacer(modifier = Modifier.height(10.dp))

            Card (modifier = Modifier
                .padding(start = 0.dp)
                .fillMaxWidth()
                .height(8.dp),
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ){

            }*/


        }
    }

}
@Composable
fun TabsComponent(navController: NavController){
    var selectedIndex by remember {
        mutableStateOf(0)
    }
    TabRow(selectedTabIndex = selectedIndex,
        modifier = Modifier.fillMaxWidth(),
        contentColor = Color.DarkGray,
        containerColor = Color.White,
       // colorResource(id = R.color.Brown)

    ) {
        tabs.forEachIndexed { index, tobeData ->

            Tab(selected = index == selectedIndex,
                onClick = {
                selectedIndex =index
            },
            ) {
                Text(text = tobeData.mytitle)

            }
        }

    }

}
@Composable
fun Cancel(
    //loading: Boolean,
                // validInputs: Boolean,
                 onClick: () -> Unit) {
    Button(          onClick=onClick,
        modifier = Modifier
            .width(120.dp)
            .height(40.dp),
            //.padding(start = 34.dp, end = 34.dp),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
        //enabled = !loading && validInputs,
        colors = ButtonDefaults.buttonColors(colorResource(id = R.color.sky))
    ) {

        Text(text = "Cancel", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
       // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
@Composable
fun submet(
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

        Text(text = "Submet", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 19.sp)
       // if (loading) CircularProgressIndicator(modifier = Modifier.size(25.dp))
    }


}
@Composable
fun prosses(navController: NavController, movie: Movie= getmovies()[0],
            onClick : (String) -> Unit = {}){
    //Column(verticalArrangement = Arrangement.Top, modifier = Modifier.padding(top = 100.dp, start = 10.dp)) {
       // Row {
            Card (modifier = Modifier
                .padding(top = 130.dp, start = 10.dp)
                //.padding(start = 10.dp)
                .width(100.dp)
                .height(100.dp)
                .clickable {
                    onClick(movie.id)
                },
                shape = RoundedCornerShape(corner = CornerSize(8.dp))
            ){
                Image(
                    modifier = Modifier.width(100.dp).height(100.dp)
                        .clip(RoundedCornerShape(30.dp)),painter = rememberImagePainter(data = movie.image[0]),
                    contentDescription = "",
                    contentScale = ContentScale.Crop)


            }

       // }
        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Product Code :223aa", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Price : 120$", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(15.dp))

        Text(text = "Status : shiped", fontWeight = FontWeight.SemiBold, color = Color.DarkGray)
        Spacer(modifier = Modifier.height(35.dp))

        Row (modifier = Modifier.padding(start = 35.dp)){
            Cancel(
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                //loading = loading,
                // validInputs = valid
            ) {
                // onDone(Email.value.trim(), password.value.trim())
                 navController.navigate(MillanoScreans.HomeScrean.name)

            }
            Spacer(modifier = Modifier.width(40.dp))

            submet(
                //Text( text = "Select" , fontWeight = FontWeight.SemiBold ),
                //loading = loading,
                // validInputs = valid
            ) {
                // onDone(Email.value.trim(), password.value.trim())
                navController.navigate(MillanoScreans.confirmscrean.name)

            }



        }

   // }

    }
