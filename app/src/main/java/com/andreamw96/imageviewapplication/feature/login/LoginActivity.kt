package com.andreamw96.imageviewapplication.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this, MyViewModelFactory)
            .get(LoginViewModel::class.java)

        loginViewModel.getUserLogin()
        loginViewModel.userLogin.observe(this, Observer {
                if (it != null) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        )

        login.setOnClickListener {
            loginViewModel.saveUserLogin(username.text.toString())
        }
    }

}