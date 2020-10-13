package com.andreamw96.imageviewapplication.feature.dotahero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.andreamw96.imageviewapplication.R
import com.andreamw96.imageviewapplication.di.MyViewModelFactory
import com.andreamw96.imageviewapplication.feature.dotahero.datasource.ListDotaHeroViewModel
import kotlinx.android.synthetic.main.fragment_list_image.*

class ListDotaHeroFragment : Fragment() {

    private lateinit var listDotaHeroViewModel: ListDotaHeroViewModel
    private lateinit var adapter: ListDotaHeroAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listDotaHeroViewModel = ViewModelProvider(this, MyViewModelFactory)
            .get(ListDotaHeroViewModel::class.java)

        adapter = activity?.let {
            ListDotaHeroAdapter(it)
        }!!
        rv_image.adapter = adapter

        listDotaHeroViewModel.getAllDotaHero()
        listDotaHeroViewModel.listDotaHero.observe(viewLifecycleOwner, Observer {
            adapter.listDotaHero = it
            adapter.notifyDataSetChanged()
        })
    }
}