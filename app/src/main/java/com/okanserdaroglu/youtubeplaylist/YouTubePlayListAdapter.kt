package com.okanserdaroglu.youtubeplaylist

import Items
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.adapter_youtube_list.view.*


class YouTubePlayListAdapter(var playList: List<Items>?) :
    RecyclerView.Adapter<YouTubePlayListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


      return ViewHolder(LayoutInflater.from(parent.context).
          inflate(R.layout.adapter_youtube_list,parent,false))

    }

    override fun getItemCount(): Int {
       return playList?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val play = playList?.get(position)
        holder.setData(play,position)

    }

    class ViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

        var rowLayout = itemView as CardView

        var textViewPlayListTitle = rowLayout.textViewTitle
        var imagePlayList = rowLayout.imageViewPlay

        fun setData(play: Items?, position: Int) {

              textViewPlayListTitle.text = play?.snippet?.channelTitle // play?.snippet?.thumbnails?.medium.url
            Glide
                .with(itemView.context)
                .load(play?.snippet?.thumbnails?.medium?.url)
                .centerCrop()
                .placeholder(R.drawable.common_full_open_on_phone)
                .into(imagePlayList)

        }


    }


}