package com.andreamw96.imageviewapplication.feature.dotahero

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.DotaHero
import com.andreamw96.imageviewapplication.utils.RvItemClickHelper
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListDotaHeroAdapter(private val ctx: Context) : RecyclerView.Adapter<ListDotaHeroAdapter.ListDotaHeroViewHolder>() {

    var listDotaHero = listOf<DotaHero>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDotaHeroViewHolder {
        return ListDotaHeroViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cardview_dota_character,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return listDotaHero.size
    }

    override fun onBindViewHolder(holder: ListDotaHeroViewHolder, position: Int) {
        val dataHero = listDotaHero[position]

        holder.apply {
            Glide.with(ctx)
                .load(dataHero.photo)
                .apply(RequestOptions().override(350, 550))
                .into(imgPhoto)

            txtName.text = dataHero.name
            txtDetail.text = dataHero.detail

            cardView.setOnClickListener(
                RvItemClickHelper(
                    position,
                    object : RvItemClickHelper.OnItemClickCallback {
                        override fun onItemClicked(view: View?, position: Int) {
                            val i = Intent(ctx, DetailHeroDotaActivity::class.java)
                            i.putExtra("HERO", listDotaHero[position])
                            ctx.startActivity(i)
                        }
                    })
            )
        }
    }

    class ListDotaHeroViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView = itemView.findViewById<CardView>(R.id.card1view_dota_character)
        val imgPhoto = itemView.findViewById<ImageView>(R.id.img_dota_character)
        val txtName = itemView.findViewById<TextView>(R.id.txt_dota_charname)
        val txtDetail = itemView.findViewById<TextView>(R.id.txt_dota_char_detail)
    }
}