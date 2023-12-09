package com.example.booky.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.booky.screens.SplashScreen
import com.example.booky.screens.login.LoginScreen
import com.example.booky.screnns.details.DetailsScreen
import com.example.booky.screnns.home.HomeScreen
import com.example.booky.screnns.search.SearchScreen
import com.example.booky.screnns.stats.StatsScreen
import com.example.booky.screnns.update.UpdateScreen


@Composable
fun ReaderNavigation() {



    val navController= rememberNavController()


    NavHost(navController = navController, startDestination = ReaderScreens.SplashScreen.name) {


        composable(ReaderScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }

        composable(ReaderScreens.DetailsScreen.name) {
          DetailsScreen(navController= navController)
        }

        composable(ReaderScreens.SearchScreen.name) {
          SearchScreen(navController= navController)
        }

        composable(ReaderScreens.HomeScreen.name) {
          HomeScreen(navController= navController)
        }

        composable(ReaderScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(ReaderScreens.StatsScreen.name) {
          StatsScreen(navController= navController)
        }

        composable(ReaderScreens.UpdateScreen.name) {
          UpdateScreen(navController= navController)
        }


    }

}