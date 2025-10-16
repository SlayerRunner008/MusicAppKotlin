package com.example.musicapp.Routes

import kotlinx.serialization.Serializable

@Serializable
object HomeScreenRoute

@Serializable
data class AlbumDetailScreenRoute(val id : String)