package com.example.musicapp.Screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.musicapp.Components.AlbumImageCard
import com.example.musicapp.Components.ArtistDetailCard
import com.example.musicapp.Components.DescriptionCard
import com.example.musicapp.Components.RecentAlbumsCard
import com.example.musicapp.Components.ReproducerCard
import com.example.musicapp.Components.SongsCard
import com.example.musicapp.Models.Album
import com.example.musicapp.Routes.AlbumDetailScreenRoute
import com.example.musicapp.Services.AlbumService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun AlbumDetail(id: String ){

    var album by remember {
        mutableStateOf<Album?>(null)
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
                service.getAlbumId(id)
            }

            album = result
            Log.i("ProductDetailScreen", album.toString())

        } catch (e: Exception) {
            Log.e("ProductDetailScreen", e.toString())
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF120000))
            .padding(10.dp)
            .padding(vertical = 30.dp),
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 60.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            item {
                AlbumImageCard(album)
            }

            item {
                DescriptionCard(album)
            }

            item {
                ArtistDetailCard(album)
            }

            items(10){ index ->
                SongsCard(album,index)
            }

            }

        ReproducerCard(album = album ,
            modifier = Modifier
                .align(alignment = Alignment.BottomCenter)
        )
    }

}