package com.example.booky.screnns.home

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.ColumnScope

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.booky.R
import com.example.booky.componets.FabContent
import com.example.booky.componets.ReaderAppBar
import com.example.booky.componets.titleSection
import com.example.booky.model.MBook
import com.example.booky.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController = NavController(LocalContext.current)) {


    Scaffold(
        topBar = {
            ReaderAppBar(
                title = "Booky",
                showProfile = true,
                navController = navController
            )
        },
        floatingActionButton = {
            FabContent(onTap = {

            })
        },
    ) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {

            HomeContent(navController)

        }

    }

}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    navController: NavController
) {

    val email = FirebaseAuth.getInstance().currentUser?.email
    val currentUserName= if ( !email.isNullOrEmpty())
        FirebaseAuth.getInstance().currentUser?.email?.split("@")?.get(0) else "N/A"



    Column(
        modifier = Modifier.padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Row(
            modifier = Modifier.align(alignment = Alignment.Start)

        ) {
            titleSection(labl = "Reading Right Now")
Spacer(modifier = Modifier.fillMaxWidth(0.7f))
            Column {

                Icon(imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "profile",
                    modifier= Modifier
                        .clickable {
                            navController.navigate(ReaderScreens.StatsScreen.name)
                        }
                        .size(50.dp),
                    tint = Color.Green)
                Text(text = "Name",
                    modifier = Modifier.padding(2.dp),
                    style=MaterialTheme.typography.bodyMedium,
                    color = Color.Red,
                    fontSize = 15.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Clip)

                Divider()

            }

        }




    }


}



@Composable
fun ReadingRighNowArea(
    books: List<MBook>,
    navController: NavController
) {


}



@Composable
fun ListCard(
    book: MBook= MBook( "1","title","author","notes"),
    onPressdetails:(String)->Unit = {},
){

    val context= LocalContext.current
    val resources=context.resources
    val displayMetrics=resources.displayMetrics
    val screenWidth=displayMetrics.widthPixels/displayMetrics.density


val spacing=10.dp
    Card(
        shape = RoundedCornerShape(29.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .height(245.dp)
            .width(205.dp)
            .clickable {
                onPressdetails.invoke(book.title.toString())
            }
    ) {
        Column (
            modifier=Modifier.width(screenWidth.dp-(spacing*2)),
            horizontalAlignment = Alignment.Start,
        ){
            Row (

            ){

            }

        }

    }



}

