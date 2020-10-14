package com.andreamw96.imageviewapplication.feature.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.main.MainActivity
import com.andreamw96.imageviewapplication.utils.EditTextUtils.afterTextChanged
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProvider(this, MyViewModelFactory)
            .get(LoginViewModel::class.java)

        loginViewModel.getUserLogin()
        loginViewModel.userLogin.observe(this, Observer {
                if (it != null) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }
        )

        btn_login.setOnClickListener {
            loginViewModel.saveUserLogin(edt_email.text.toString())
        }

        loginViewModel.loginState.observe(this, Observer {
            if (it.usernameState != null) {
                edt_email.error = it.usernameState
            }

            if (it.passwordState != null) {
                edt_password.error = it.passwordState
            }
        })

        edt_email.afterTextChanged {
            loginViewModel.login(edt_email.text.toString(), edt_password.text.toString())
        }

        edt_password.afterTextChanged {
            loginViewModel.login(edt_email.text.toString(), edt_password.text.toString())
        }
    }
}