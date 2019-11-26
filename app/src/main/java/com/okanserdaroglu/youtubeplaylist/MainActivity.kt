package com.okanserdaroglu.youtubeplaylist

import Items
import PlayList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val API_KEY = "AIzaSyCJ24xaHhO6Y6EW0OjPOqIZPdJ9RC33x-I"
    private val CHANNEL_ID = "UCJbPGzawDH1njbqV-D5HqKw"
    private val MAX_RESULTS: Int = 20
    var data: List<Items>? = null
    var adapter : YouTubePlayListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiClient.client?.create(ApiInterface::class.java)
        val apiCall = apiInterface?.getList(CHANNEL_ID, API_KEY, MAX_RESULTS)

        apiCall?.enqueue(object : Callback<PlayList> {
            override fun onFailure(call: Call<PlayList>, t: Throwable) {

                Log.e("error", t.toString())

            }

            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {

                Log.e("playlist", response.message())

                data = response.body()?.items
                adapter = YouTubePlayListAdapter(data)
                recyclerViewPlayList.adapter = adapter
            }


        })


    }
}
