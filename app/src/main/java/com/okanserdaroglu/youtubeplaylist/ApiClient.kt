package com.okanserdaroglu.youtubeplaylist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient { // singleton retrofit

    // firstly build retrofit here with base url

    private const val baseUrl = "https://www.googleapis.com/youtube/v3/"
    private var retrofit: Retrofit? = null

    val client: Retrofit?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create()).build()

            }
            return retrofit
        }


}