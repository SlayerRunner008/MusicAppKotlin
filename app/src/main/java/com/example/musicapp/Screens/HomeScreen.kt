package com.example.musicapp.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.Components.GreetingCard

@Composable
fun HomeScreen(navController: NavController){
    Box (
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            item {
                GreetingCard()
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                ) {
                    Text(text = "Albums")
                    Spacer(modifier = Modifier.weight(1f))
                    Text(text = "See more")
                }
            }

        }


    }

}

@Preview(showBackground = true, showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
