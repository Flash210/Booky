package com.example.booky.componets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
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
