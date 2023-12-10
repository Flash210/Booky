package com.example.booky.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.booky.componets.ReaderLogo
import com.example.booky.navigation.ReaderScreens

@Composable
fun SplashScreen(navController: NavHostController) {



    navController.navigate(ReaderScreens.HomeScreen.name)

    Surface(
        modifier = Modifier
            .padding(15.dp)
            .size(330.dp),
        shape = CircleShape,
        color = Color.White,
        border = BorderStroke(width = 3.dp, color = Color.Gray)


    ) {
Column (
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
){
    ReaderLogo()
    Spacer(modifier =Modifier.height(15.dp))
    Text(text = " Read , Change , Yourself",
        style = MaterialTheme.typography.bodyMedium,
        color = Color.Gray
        )


}
    }


}


@Composable
fun UserForm(

){


}

