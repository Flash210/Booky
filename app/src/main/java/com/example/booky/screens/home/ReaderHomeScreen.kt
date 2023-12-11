package com.example.booky.screnns.home

import android.annotation.SuppressLint
import android.util.Log


import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import com.example.booky.componets.FabContent
import com.example.booky.componets.ListCard
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

    val listOfBooks= listOf<MBook>(
        MBook(title = "The Alchemist",
            author = "Paulo Coelho",
            notes = "The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller. An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there.",
            id = "1"),

        MBook(title = "The Alchemist",
            author = "Paulo Coelho",
            notes = "The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller. An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there.",
            id = "2"),
        MBook(title = "The Alchemist",
            author = "Paulo Coelho",
            notes = "The Alchemist is a novel by Brazilian author Paulo Coelho that was first published in 1988. Originally written in Portuguese, it became a widely translated international bestseller. An allegorical novel, The Alchemist follows a young Andalusian shepherd in his journey to the pyramids of Egypt, after having a recurring dream of finding a treasure there.",
            id = "3",)

    )


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

ReadingRighNowArea(books = listOf(),
    navController = navController)
titleSection(labl = "ReadingList")
        BookListArea(listOfBooks= listOfBooks,
            navController = navController)


    }


}

@Composable
fun BookListArea(
    listOfBooks: List<MBook>,
                 navController: NavController) {

    HorizonalScrollableComponet(listOfBooks){
        Log.d("TAG", "BookListArea: $it")

    }



}

@Composable
fun HorizonalScrollableComponet(
    listOfBooks: List<MBook>,
    onCardPress:(String)->Unit= {},
    ) {
    val scollState= rememberScrollState()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(280.dp)
            .horizontalScroll(scollState),
        ){

        for (book in listOfBooks){
            ListCard(book = book){
                onCardPress(it)
            }
        }

    }

}


@Composable
fun ReadingRighNowArea(
    books: List<MBook>,
    navController: NavController
) {


    ListCard()


}









