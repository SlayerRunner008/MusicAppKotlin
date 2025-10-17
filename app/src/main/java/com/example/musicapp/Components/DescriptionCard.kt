package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.musicapp.Models.Album
import androidx.compose.ui.graphics.Color

@Composable
fun DescriptionCard(album: Album){
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF8B0000),
                    topLeft = Offset(4f, 4f),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(16.dp.toPx()),
                    alpha = 0.4f
                )
            }
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .padding(20.dp)


    ) {

        Text(
            text = "About this album",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = Color.White )
        Text(
            text = album.description,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            color = Color.White
        )
    }
}