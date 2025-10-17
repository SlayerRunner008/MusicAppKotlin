package com.example.musicapp.Screens
import android.content.ClipData
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.musicapp.Components.AlbumRowCard
import com.example.musicapp.Components.GreetingCard
import com.example.musicapp.Models.Album
import com.example.musicapp.Routes.AlbumDetailScreenRoute
import com.example.musicapp.Services.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.musicapp.Components.RecentAlbumsCard
import com.example.musicapp.Components.ReproducerCard

@Composable
fun HomeScreen(navController: NavController) {
    var albums by remember {
        mutableStateOf(listOf<Album>())
    }
    val album = albums.find { it.id == "682243ecf60db4caa642a48a" }
    var loading by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(true) {
        try {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://music.juanfrausto.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            val service = retrofit.create(AlbumService::class.java)

            val result = withContext(Dispatchers.IO) {
                service.getAllAlbums()
            }
            Log.i("HomeScreen", "${result}")
            albums = result
            loading = false
        } catch (e: Exception) {
            loading = false
            Log.e("HomeScreen", e.toString())
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF120000))
            .padding(10.dp)
            .padding(vertical = 30.dp)
    ) {
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Color(0xFF8B0000)
            )
        } else {

            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 60.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                item {
                    GreetingCard()
                }

                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp)
                    ) {
                        Text(
                            text = "Albums",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White
                        )
                        Spacer(modifier = Modifier.weight(1f))
                        Text(
                            text = "See more",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.SemiBold,
                            color = Color(0xFFD32F2F)
                        )
                    }
                }

                item {
                    LazyRow(
                        modifier = Modifier.fillMaxSize()
                            .padding(bottom = 20.dp),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        items(albums) { album ->
                            AlbumRowCard(album = album, onClick = {
                                navController.navigate(AlbumDetailScreenRoute(album.id))
                            })
                        }
                    }
                }


                items(albums) { album ->
                    RecentAlbumsCard(album = album, onClick = {
                        navController.navigate(AlbumDetailScreenRoute(album.id))

                    })
                }

            }

            ReproducerCard(
                album = album,
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true )
@Composable
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
