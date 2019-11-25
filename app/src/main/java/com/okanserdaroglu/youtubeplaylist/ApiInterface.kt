package com.okanserdaroglu.youtubeplaylist

import PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    // https://www.googleapis.com/youtube/v3/playlists?part=snippet&channelId=UCJbPGzawDH1njbqV-D5HqKw&maxResults=50&key=AIzaSyCJ24xaHhO6Y6EW0OjPOqIZPdJ9RC33x-I

    @GET("playlists?part=snippet")
    fun getList(
        @Query("channelId") channelId: String,
        @Query("key") key: String,
        @Query("maxResults") maxResults: Int
    ): Call<PlayList>

}