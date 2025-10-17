package com.example.musicapp.Components
import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.musicapp.Models.Album
import com.google.android.gms.maps.model.Circle


@Composable
fun RecentAlbumsCard (album: Album, onClick: () -> Unit){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(Color.Black)
            .padding(horizontal = 11.dp, vertical = 11.dp)
            .clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ){
        AsyncImage(
            model = album.image,
            contentDescription = album.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(70.dp)
                .width(70.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFF8B0000))
        )

        Column (
            modifier = Modifier
                .padding(16.dp)
                .weight(1f),

        ) {
            Text(album.title,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(5.dp))

            Row (
                modifier = Modifier
            ){
                Text(album.artist,
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                    modifier = Modifier
                    )
                Text(
                    text = "•",
                    color = Color.LightGray,
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .align(Alignment.CenterVertically),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text("Popular Song",
                    style = MaterialTheme.typography.bodySmall,
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                    overflow = TextOverflow.Ellipsis,

                )
            }
        }

        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "Menú",
            tint = Color.White,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterVertically)
                .padding(start = 8.dp)

        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRecentAlbumsCard() {
    val sampleAlbum = Album(
        id = "12334443ef3",
        title = "Tales of Ithiria",
        artist = "Haggard",
        description = "Un álbum sinfónico que mezcla elementos de música clásica con death metal melódico.",
        image = "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj7ugde1AEMq01vmC8BVEpLdF0Xek6AY9bGlBiOU5KnDJwkIfGTjfPDgNDzOdO_IiigYdzctv_esbkP2J-Q4A7KczJJMotAnqNg7hRCCQYD5Ej8Q4gWq3FidTimmOG79GXLx3jiHwI-hA0/w1200-h630-p-k-no-nu/51TLuWZMYeL._SS500_-tn-600x470-0-FFFFFF.jpg"
    )

    RecentAlbumsCard(album = sampleAlbum, onClick = {})
}