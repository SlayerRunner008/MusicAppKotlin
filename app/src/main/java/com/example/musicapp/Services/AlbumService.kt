package com.example.musicapp.Services

import com.example.musicapp.Models.Album
import retrofit2.http.GET
import retrofit2.http.Path

interface AlbumService {
    @GET("albums")
    suspend fun getAllAlbums() : List<Album>

    @GET("albums/{id}")
    suspend fun getAlbumId(@Path("id") id: String ) : Album
}