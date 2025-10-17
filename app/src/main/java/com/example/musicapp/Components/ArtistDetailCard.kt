package com.example.musicapp.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import com.example.musicapp.Models.Album
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ArtistDetailCard(album: Album?){
    Row (
        modifier = Modifier
            .drawBehind {
                drawRoundRect(
                    color = Color(0xFF8B0000),
                    topLeft = Offset(4f, 4f),
                    size = Size(size.width, size.height),
                    cornerRadius = CornerRadius(20.dp.toPx()),
                    alpha = 0.4f
                )
            }
            .clip(RoundedCornerShape(20.dp))
            .background(Color.Black)
            .padding(6.dp)
    ){

        Text(
            text = "Artist: ",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Text(
            text = "${album?.artist}",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Light,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtistDetailCardPreview() {
    val sampleAlbum = Album(
        id = "12334443ef3",
        title = "Tales of Ithiria",
        artist = "Haggard",
        description = "Un álbum sinfónico que mezcla elementos de música clásica con death metal melódico.",
        image = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7ugde1AEMq01vmC8BVEpLdF0Xek6AY9bGlBiOU5KnDJwkIfGTjfPDgNDzOdO_IiigYdzctv_esbkP2J-Q4A7KczJJMotAnqNg7hRCCQYD5Ej8Q4gWq3FidTimmOG79GXLx3jiHwI-hA0/w1200-h630-p-k-no-nu/51TLuWZMYeL._SS500_-tn-600x470-0-FFFFFF.jpg"
    )
    ArtistDetailCard(album = sampleAlbum)
}