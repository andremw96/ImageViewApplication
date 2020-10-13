package com.andreamw96.imageviewapplication.feature.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.main.MainActivity
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
            if (isLoginFieldFilled()) {
                loginViewModel.saveUserLogin(edt_email.text.toString())
            } else {
                Toast.makeText(this, getString(R.string.login_failed), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isLoginFieldFilled() : Boolean {
        edt_email.error = null
        edt_password.error = null

        if(edt_email.text.isNullOrEmpty()) {
            edt_email.error = getString(R.string.email_must_be_filled)
            return false
        }

        if(edt_password.text.isNullOrEmpty()) {
            edt_password.error = getString(R.string.pwd_must_be_filled)
            return false
        }

        return true
    }

}