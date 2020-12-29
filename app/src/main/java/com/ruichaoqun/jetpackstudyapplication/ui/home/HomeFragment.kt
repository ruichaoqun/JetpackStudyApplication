package com.ruichaoqun.jetpackstudyapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.ruichaoqun.jetpackstudyapplication.AppExecutors
import com.ruichaoqun.jetpackstudyapplication.data.HomeListBean
import com.ruichaoqun.jetpackstudyapplication.databinding.FragmentHomeBinding
import com.ruichaoqun.jetpackstudyapplication.net.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()
    private var binding:FragmentHomeBinding ?= null
//    @Inject
    lateinit var appExecutors: AppExecutors

    lateinit var adapter:HomeListAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        adapter = HomeListAdapter(appExecutors)
        binding?.recyclerView?.adapter = adapter
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.homeList.observe(viewLifecycleOwner,
            Observer<Resource<HomeListBean>> {result->
                adapter.submitList(result.data?.datas)
            })
    }
}