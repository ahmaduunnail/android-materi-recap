package com.lleans.androidmateri1recap.RestAPI

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lleans.androidmateri1recap.R

class AdapterRecycler(private val dataList: ArrayList<JsonData>): RecyclerView.Adapter<AdapterRecycler.AdapterDataViewHolder>() {
    class AdapterDataViewHolder(item: View): RecyclerView.ViewHolder(item) {
        var text_title: TextView = item.findViewById(R.id.txt_name)
        var img_photo: ImageView = item.findViewById(R.id.img_profile)
        var text_status: TextView = item.findViewById(R.id.txt_status)
        fun bind(jsonData: JsonData){
            with(itemView) {
                Glide.with(itemView.context).load(jsonData.urlThumbnail)
                    .apply { RequestOptions().override(128, 128) }.into(img_photo)
                text_title.text = jsonData.title
                text_status.text = jsonData.status
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDataViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_actors, parent, false)
        return AdapterDataViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdapterDataViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int = dataList.size
}