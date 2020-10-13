package com.andreamw96.imageviewapplication.feature.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.login.LoginActivity
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewModel = ViewModelProvider(this, MyViewModelFactory)
            .get(ProfileViewModel::class.java)


        profileViewModel.userLogin.observe(viewLifecycleOwner, Observer {
                if (it == null) {
                    startActivity(Intent(activity, LoginActivity::class.java))
                    activity?.finish()
                }
            }
        )

        btn_logout.setOnClickListener {
            profileViewModel.deleteUserLogin()
        }
    }
}