package com.example.musicapp.Components
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import coil3.compose.AsyncImage
import com.example.musicapp.Models.Album
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max

@Composable
fun AlbumRowCard(album: Album, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() }
    ) {

        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier.matchParentSize()
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(Color(0xFF120000).copy(alpha = 0.1f))
        )


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .padding(top = 75.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF2B0000).copy(alpha = 0.6f))
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Column (
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = album.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    maxLines = 2
                )
                Text(
                    text = album.artist,
                    style = MaterialTheme.typography.bodySmall,
                    color = Color.LightGray,
                    maxLines = 2
                )
            }

            Icon(
                imageVector = Icons.Default.PlayArrow,
                contentDescription = "Reproducir",
                tint = Color.White,
                modifier = Modifier
                    .size(40.dp)

            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AlbumRowCardPreview() {
    val sampleAlbum = Album(
        id = "12334443ef3",
        title = "Tales of Ithiria",
        artist = "Haggard",
        description = "Un álbum sinfónico que mezcla elementos de música clásica con death metal melódico.",
        image = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7ugde1AEMq01vmC8BVEpLdF0Xek6AY9bGlBiOU5KnDJwkIfGTjfPDgNDzOdO_IiigYdzctv_esbkP2J-Q4A7KczJJMotAnqNg7hRCCQYD5Ej8Q4gWq3FidTimmOG79GXLx3jiHwI-hA0/w1200-h630-p-k-no-nu/51TLuWZMYeL._SS500_-tn-600x470-0-FFFFFF.jpg"
    )

    AlbumRowCard(album = sampleAlbum, onClick = {})
}
