package com.example.booky.componets

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.booky.model.MBook
import com.example.booky.navigation.ReaderScreens
import com.google.firebase.auth.FirebaseAuth

@Composable
fun ReaderLogo(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier.padding(bottom = 15.dp),
        text = "Booky",
        style = MaterialTheme.typography.titleLarge,
        color = Color.Red
    )
}

// Home Screen

@Composable
fun titleSection(
    modifier: Modifier = Modifier,
    labl: String
) {
    Surface(
        modifier = modifier.padding(
            start = 5.dp,
            top = 1.dp
        )
    ) {
        Column {
            Text(
                text = labl,
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontSize = 20.sp,
                    textAlign = TextAlign.Left
                ),
            )
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ReaderAppBar(
    title: String,
    showProfile: Boolean = true,
    navController: NavController
) {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (showProfile) {
                    Icon(
                        imageVector = Icons.Default.Favorite,
                        contentDescription = "Logo",
                        modifier = Modifier
                            .clip(
                                RoundedCornerShape(50.dp)
                            )
                            .scale(0.9f)
                    )
                }
                Text(
                    text = title,
                    color = Color.Red,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    ),
                )
                Spacer(modifier = Modifier.width(150.dp))


            }
        },
        actions = {
            IconButton(onClick = {
                FirebaseAuth.getInstance().signOut().run {
                    navController.navigate(ReaderScreens.LoginScreen.name)
                }
            }) {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = "Log Out ",
                    tint = Color.Green
                )

            }
        },


        )

}



@Composable
fun FabContent(onTap: (String) -> Unit) {

    FloatingActionButton(
        onClick = {
            onTap("")

        },
        shape = RoundedCornerShape(50.dp),

        containerColor = Color(0xFF92CBDF),

        ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "Add a new book",
            tint = Color.White
        )
    }

}




@Composable
fun BookRating(score: Double=4.5) {
    Surface(
        modifier = Modifier
            .height(70.dp)
            .padding(4.dp),
        shape = RoundedCornerShape(50.dp),
        shadowElevation = 6.dp,
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .padding(4.dp)){
            Icon(
                imageVector =Icons.Filled.Star ,
                contentDescription = "Start",
                modifier = Modifier
                    .padding(top= 4.dp, start = 6.dp))

            Text(text =score.toString(),

            )

        }

    }




}


@Preview
@Composable
fun ListCard(
    book: MBook = MBook( "1","title","author","notes"),
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
            .padding(5.dp)
            .clickable {
                onPressdetails.invoke(book.title.toString())
            }
    ) {
        Column (
            modifier=Modifier.width(screenWidth.dp-(spacing*2)),
            horizontalAlignment = Alignment.Start,
        ){
            Row(
                horizontalArrangement = Arrangement.Center
            ){
                Image(
                    painter = rememberImagePainter(data=""),
                    contentDescription = "book image",
                    modifier = Modifier
                        .height(140.dp)
                        .width(100.dp)
                        .padding(4.dp)
                )
                Spacer(modifier = Modifier.width(50.dp))

// the heart ,the start and the rating
                Column(
                    modifier=Modifier.padding(top=25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center

                ) {
                    Icon(imageVector = Icons.Rounded.FavoriteBorder,
                        contentDescription = "Fav Icon",
                        modifier = Modifier
                            .padding(bottom = 1.dp))


                    BookRating(score=3.5)

                }
            }


            Text(text = book.title.toString(),
                fontWeight = FontWeight.Bold, maxLines = 2, overflow = TextOverflow.Ellipsis,
                modifier=Modifier.padding(start =10.dp),

                )
            Text(text = book.author.toString(),
                fontWeight = FontWeight.Normal,
                maxLines = 1,
                modifier=Modifier.padding(start =10.dp),
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row (
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom,
        ){
            Roundedutton(label = "Reading",
                raduis = 29,
                onPress = {

                })

        }

    }



}



@Preview
@Composable
fun Roundedutton(
    label:String="Reading",
    raduis:Int=29,
    onPress:() -> Unit={})

{
    Surface(
        modifier= Modifier
            .padding(4.dp)
            .clip(
                RoundedCornerShape(
                    bottomEndPercent = raduis,
                    topStartPercent = raduis
                )
            ),
        color = Color(0xFF92CBDF))
    {
        Column(
            modifier = Modifier
                .heightIn(40.dp)
                .clickable { onPress.invoke() },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text =label,
                style = TextStyle(
                    color = Color.White,
                    fontSize = 15.sp,

                    )
            )

        }}}


