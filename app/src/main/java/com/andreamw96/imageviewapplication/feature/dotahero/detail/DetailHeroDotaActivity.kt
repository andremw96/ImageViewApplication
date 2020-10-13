package com.andreamw96.imageviewapplication.feature.dotahero.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.datasource.mockdata.dotahero.DotaHero
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.activity_detail_hero_dota.*

class DetailHeroDotaActivity : AppCompatActivity() {

    private var dotaHeroChoosen : DotaHero? = null
    private lateinit var adapter: DetailHeroSkillSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hero_dota)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        dotaHeroChoosen = intent.getParcelableExtra("HERO")

        adapter = DetailHeroSkillSliderAdapter()
        detail_image_skill_slider.apply {
            setSliderAdapter(adapter)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
            autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
            isAutoCycle = true
            scrollTimeInSec = 2
            startAutoCycle()
        }

        dataDetailHeroToView()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun dataDetailHeroToView() {
        dotaHeroChoosen?.apply {
            Glide.with(this@DetailHeroDotaActivity)
                .load(photo)
                .placeholder(R.drawable.ic_profile)
                .apply(RequestOptions().override(350, 550))
                .into(detail_image_dotahero)

            detail_name_dotachar.text = name
            detail_detail_dotachar.text = detail
            detail_description_dotachar.text = description

            adapter.listSkillHero = listSkillHero
            adapter.notifyDataSetChanged()
        }
    }
}