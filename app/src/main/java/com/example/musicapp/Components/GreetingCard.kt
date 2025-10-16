package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
@Composable
fun GreetingCard(){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Magenta)
            .padding(20.dp)
    ) {
        Row {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menú",
                modifier = Modifier
                    .padding(bottom = 10.dp)

            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Buscar",

                modifier = Modifier
                    .padding(bottom = 10.dp)
            )
        }
        Text(text = "Good Morning!")
        Text(text = "Mariano Jara ")
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingCardPreview() {
    GreetingCard()
}
