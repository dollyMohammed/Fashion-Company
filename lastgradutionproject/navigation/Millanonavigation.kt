package com.example.lastgradutionproject.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lastgradutionproject.Manger.ControlScreen
import com.example.lastgradutionproject.Manger.DesignScreen
import com.example.lastgradutionproject.Manger.mangerprofile
import com.example.lastgradutionproject.Shiped.shipped
import com.example.lastgradutionproject.confirm.confirm
import com.example.lastgradutionproject.designs.mydesigns
import com.example.lastgradutionproject.profile.profile
import com.example.lastgradutionproject.screans.ClientScreans.Code.EnterCode
import com.example.lastgradutionproject.screans.ClientScreans.Edit.Edit
import com.example.lastgradutionproject.screans.ClientScreans.Fav.favourite
import com.example.lastgradutionproject.screans.ClientScreans.History.HistoryScrean
import com.example.lastgradutionproject.screans.ClientScreans.HomeScrean.Home
import com.example.lastgradutionproject.screans.ClientScreans.Login.LoginScrean
import com.example.lastgradutionproject.screans.ClientScreans.Men.menScrean
import com.example.lastgradutionproject.screans.ClientScreans.OrderScrean.Order
import com.example.lastgradutionproject.screans.ClientScreans.Report.Report
import com.example.lastgradutionproject.screans.ClientScreans.Shipped.Shipping
import com.example.lastgradutionproject.screans.ClientScreans.SignUp.SignUp
import com.example.lastgradutionproject.screans.ClientScreans.Women.womenScrean
import com.example.lastgradutionproject.screans.ClientScreans.aftersignup.aftersignup
import com.example.lastgradutionproject.screans.ClientScreans.beforeorder.BeforeOrder
import com.example.lastgradutionproject.screans.ClientScreans.kids.kidsScrean
import com.example.lastgradutionproject.screans.ClientScreans.onBording.OnBording
import com.example.lastgradutionproject.screans.ClientScreans.orderScrean2.order2
import com.example.lastgradutionproject.screans.ClientScreans.orderscrean3.nextorder
import com.example.lastgradutionproject.screans.ClientScreans.password.passwoed
import com.example.lastgradutionproject.screans.ClientScreans.prossing.prossing
import com.example.lastgradutionproject.screans.ClientScreans.shoses.shosesScreans
import com.example.lastgradutionproject.screans.DesignerScreans.DescribeDesign
import com.example.lastgradutionproject.screans.DesignerScreans.MyDesigns.designs
import com.example.lastgradutionproject.screans.DesignerScreans.MyDesigns.mydesigner
import com.example.lastgradutionproject.screans.MillanoSplashScrean
import com.example.lastgradutionproject.screans.startScrean.StartScrean

@Composable
fun MillanoNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MillanoScreans.SplashScrean.name) {
        composable(MillanoScreans.SplashScrean.name){
            MillanoSplashScrean(navController=navController)
        }
        composable(MillanoScreans.OnBordingScrean.name){
            OnBording(navController=navController)
        }
        composable(MillanoScreans.StartScrean.name){
            StartScrean(navController=navController)
        }
        composable(MillanoScreans.LoginScrean.name){
            LoginScrean(navController=navController)
        }
        composable(MillanoScreans.SignUpScrean.name){
            SignUp(navController=navController)
        }
        composable(MillanoScreans.HomeScrean.name){
            Home(navController=navController)
        }


        composable( MillanoScreans.OrderScrean.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})){
            backStackEntry ->
            Order(navController = navController,backStackEntry.arguments?.getString("movie"))
            }
       composable( MillanoScreans.orderscrean2.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})){
                backStackEntry ->
            order2(navController = navController,backStackEntry.arguments?.getString("movie"))
        }

        composable( MillanoScreans.OrderScrean.name+"/{movie2}",
             arguments = listOf(navArgument(name = "movie2"){type= NavType.StringType})){
                 backStackEntry ->
             Order(navController = navController,backStackEntry.arguments?.getString("movie2"))
         }
        composable( MillanoScreans.nextorderscrean.name+"/{movie2}",
            arguments = listOf(navArgument(name = "movie2"){type= NavType.StringType})){
                backStackEntry ->
            nextorder(navController = navController,
                backStackEntry.arguments?.getString("movie2")
            )
        }



        composable(MillanoScreans.WomenScrean.name){
            womenScrean(navController=navController)
        }

        composable(MillanoScreans.MenScrean.name){
            menScrean(navController=navController)
        }
        composable(MillanoScreans.KidsScrean.name){
            kidsScrean(navController=navController)
        }
        composable(MillanoScreans.ShosesScrean.name){
            shosesScreans(navController=navController)
        }
        composable(MillanoScreans.Historyscrean.name){
            HistoryScrean(navController=navController)
        }
        composable(MillanoScreans.prossingscrean.name){
            prossing(navController=navController)
        }


        /*composable( MillanoScreans.prossingscrean.name+"/{movie}",
            arguments = listOf(navArgument(name = "movie"){type= NavType.StringType})){
                backStackEntry ->
            prossing(navController = navController,backStackEntry.arguments?.getString("movie"))
        }*/

        composable(MillanoScreans.shipingscrean.name){
            Shipping(navController=navController)
        }
        composable(MillanoScreans.favouritescrean.name){
            favourite(navController=navController)
        }
        composable(MillanoScreans.profilescrean.name){
            profile(navController=navController)
        }
        composable(MillanoScreans.editprofile.name){
            Edit(navController=navController)
        }
        composable(MillanoScreans.reportscrean.name){
            Report(navController=navController)
        }
        composable(MillanoScreans.forgetpasswoed.name){
            passwoed(navController=navController)
        }
            composable(MillanoScreans.aftersignUpscrean.name) {
                aftersignup(navController = navController)

            }
        composable(MillanoScreans.codescrean.name){
            EnterCode(navController=navController)
        }
        composable(MillanoScreans.shipedscrean.name){
            shipped(navController=navController)
        }
        composable(MillanoScreans.confirmscrean.name){
            confirm(navController=navController)
        }
        composable(MillanoScreans.beforeorder.name){
            BeforeOrder(navController=navController)
        }
        composable(MillanoScreans.DesignerHomeScrean.name){
            DescribeDesign(navController=navController)
        }
        composable(MillanoScreans.myDesignsScreans.name){
            mydesigns(navController=navController)
        }
        composable(MillanoScreans.designerScrean.name){
            mydesigner(navController=navController)
        }
        composable(MillanoScreans.myDesignsScreans.name){
            designs(navController=navController)
        }
        composable(MillanoScreans.controlscreen.name){
            ControlScreen(navController=navController)
        }
        composable(MillanoScreans.designScrean.name){
            DesignScreen(navController=navController)
        }
        composable(MillanoScreans.mangprofile.name){
            mangerprofile(navController=navController)
        }

































    }

}

