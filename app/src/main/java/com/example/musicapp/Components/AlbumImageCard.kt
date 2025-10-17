package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.musicapp.Models.Album

@Composable
fun AlbumImageCard(album: Album?){
    Box (
        modifier = Modifier
            .width(300.dp)
            .height(300.dp),
        contentAlignment = Alignment.Center
    ) {

        AsyncImage(
            model = album?.image,
            contentDescription = album?.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
                .clip(RoundedCornerShape(20.dp))
        )
        Box(
            modifier = Modifier
                .matchParentSize()
                .clip(RoundedCornerShape(20.dp))
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF8B0000).copy(alpha = 0.3f),
                            Color.Black
                        ),
                        startY = 0f,
                        endY = Float.POSITIVE_INFINITY
                    )
                )

        )

    }
}