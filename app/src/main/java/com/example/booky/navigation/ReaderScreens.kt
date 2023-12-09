package com.example.booky.navigation


enum class ReaderScreens {

    SplashScreen,
    DetailsScreen,
    SearchScreen,
    HomeScreen,
    LoginScreen,
    StatsScreen,
    UpdateScreen;


    companion object {
        fun fromRoute(route:String?) :ReaderScreens
        = when(route?.substringBefore("*/")){
         SplashScreen.name -> SplashScreen
            DetailsScreen.name -> DetailsScreen
            SearchScreen.name -> SearchScreen
            HomeScreen.name -> HomeScreen
            LoginScreen.name -> LoginScreen
            StatsScreen.name -> StatsScreen
            UpdateScreen.name -> UpdateScreen
            null -> SplashScreen
            else -> throw IllegalArgumentException("Route $route is not recognized.")


        }

    }
}