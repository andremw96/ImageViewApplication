package com.andreamw96.imageviewapplication.feature.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.feature.dotahero.list.ListDotaHeroFragment
import com.andreamw96.imageviewapplication.feature.profile.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.home_menu -> {
                loadFragment(ListDotaHeroFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.profile_menu -> {
                loadFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btm_nav_view_main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        if (savedInstanceState == null) {
            btm_nav_view_main.selectedItemId = R.id.home_menu
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, fragment, fragment.javaClass.simpleName)
            .commit()
    }
}