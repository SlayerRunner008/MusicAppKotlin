package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.musicapp.Models.Album

@Composable
fun ReproducerCard(album: Album?,modifier: Modifier = Modifier){
    Row (
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(30.dp))
            .background(Color(0xFF8B0000))
            .padding(3.dp)
            .padding(horizontal = 5.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(16.dp))
        ) {
            AsyncImage(
                model = album?.image,
                contentDescription = album?.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.matchParentSize()
            )

        }

        Column (
            modifier = Modifier
                .padding(8.dp)
                .weight(1f),

            ) {
            Text("${album?.title}",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(5.dp))
                Text("${album?.artist}",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                    modifier = Modifier
                )

        }

        Icon(
            imageVector = Icons.Default.PlayArrow,
            contentDescription = "Menú",
            tint = Color(0xFF8B0000),
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
                .align(Alignment.CenterVertically)
                .background(Color.Black)
                .padding(horizontal = 8.dp)
        )
    }
}
