package com.example.lastgradutionproject.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lastgradutionproject.navigation.MillanoScreans

@Composable
fun AlertDialog(
    navController: NavController,

    onDismiss : () -> Unit
){
    androidx.compose.material3.AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = { /*TODO*/ },
        modifier = Modifier.height(340.dp),
        title = {
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Default.Info, contentDescription = "")
                Text(text = "User As",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp)

            }
        },
        text = {
            Column (
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Button(onClick = {
navController.navigate(MillanoScreans.HomeScrean.name)
                },
                    modifier = Modifier
                        .width(180.dp)
                        .padding(5.dp)) {
                    Text(text = "Client")

                }
                Spacer(modifier = Modifier.height(2.dp))
                Button(onClick = {
                    navController.navigate(MillanoScreans.controlscreen.name)

                },
                    modifier = Modifier
                        .width(180.dp)
                        .padding(5.dp)) {
                    Text(text = "Manager")

                }
                Spacer(modifier = Modifier.height(2.dp))


                Button(onClick = {
                    navController.navigate(MillanoScreans.designerScrean.name)

                },
                    modifier = Modifier
                        .width(180.dp)
                        .padding(5.dp)) {
                    Text(text = "Designer")

                }


            }
        }

        )
}
