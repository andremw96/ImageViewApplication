package com.andreamw96.imageviewapplication.feature.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.login.LoginActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel = ViewModelProviders.of(this, MyViewModelFactory)
            .get(MainViewModel::class.java)

        mainViewModel.userLogin.observe(this, Observer {
                if (it == null) {
                    startActivity(Intent(this, LoginActivity::class.java))
                    finish()
                }
            }
        )

        logout.setOnClickListener {
            mainViewModel.deleteUserLogin()
        }
    }
}