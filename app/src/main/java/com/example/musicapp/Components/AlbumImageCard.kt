package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.musicapp.Models.Album

@Composable
fun AlbumImageCard(album: Album?){
    Box (
        modifier = Modifier
            .width(400.dp)
            .height(400.dp),
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp)

                .align(Alignment.TopStart),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(8.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(Color.Black.copy(alpha = 0.3f))
                    .padding(8.dp)
            )
        }

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .padding(top = 70.dp, start = 16.dp, end = 16.dp)

        ) {
            Text(
                text = "${album?.title}",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
            Text(
                text = "${album?.artist}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Normal,
                color = Color.White
            )
        }

        Row (
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(horizontal = 20.dp)
        ) {

            Box(
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .size(90.dp)
                    .drawBehind {
                        drawCircle(
                            color = Color(0xFF8B0000),
                            radius = size.minDimension / 2f + 2f,
                            center = center + Offset(3f, 3f),
                            alpha = 0.5f
                        )
                    }
                    .clip(CircleShape)
                    .background(Color.Black)
                    .clip(CircleShape)
                    .background(Color.Black)
            ) {
                Icon(
                    imageVector = Icons.Default.PlayArrow,
                    contentDescription = null,
                    tint = Color(0xFF8B0000),
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 15.dp)
                )
            }
            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Menú",
                tint = Color.Black,
                modifier = Modifier
                    .size(90.dp)
                    .padding(10.dp)
                    .clip(CircleShape)
                    .align(Alignment.CenterVertically)
                    .background(Color(0xFF8B0000))
                    .padding(horizontal = 15.dp)
            )
        }

    }
}