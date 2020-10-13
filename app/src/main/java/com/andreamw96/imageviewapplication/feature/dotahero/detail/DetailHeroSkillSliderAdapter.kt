package com.andreamw96.imageviewapplication.feature.dotahero.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.SkillHero
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarteist.autoimageslider.SliderViewAdapter

class DetailHeroSkillSliderAdapter :
    SliderViewAdapter<DetailHeroSkillSliderAdapter.DetailHeroSkillSliderViewHolder>() {

    var listSkillHero = listOf<SkillHero>()

    override fun getCount(): Int {
        return listSkillHero.size
    }

    override fun onCreateViewHolder(parent: ViewGroup): DetailHeroSkillSliderViewHolder {
        return DetailHeroSkillSliderViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image_slider_layout_item, null, false)
        )
    }

    override fun onBindViewHolder(viewHolder: DetailHeroSkillSliderViewHolder, position: Int) {
        val skill = listSkillHero[position]

        viewHolder.apply {
            textViewDescription.text = skill.skill
            Glide.with(viewHolder.itemView)
                .load(skill.skill_photo_url)
                .placeholder(R.drawable.ic_profile)
                .apply(RequestOptions().override(350, 550))
                .into(imageViewBackground)
        }
    }


    class DetailHeroSkillSliderViewHolder(itemView: View) : SliderViewAdapter.ViewHolder(itemView) {
        val imageViewBackground: ImageView = itemView.findViewById(R.id.iv_auto_image_slider)
        val textViewDescription: TextView = itemView.findViewById(R.id.tv_auto_image_slider)
    }
}