package com.ruichaoqun.jetpackstudyapplication.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.ruichaoqun.jetpackstudyapplication.AppExecutors
import com.ruichaoqun.jetpackstudyapplication.R
import com.ruichaoqun.jetpackstudyapplication.databinding.FragmentDashboardBinding
import com.ruichaoqun.jetpackstudyapplication.ui.home.HomeListAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

class DashboardFragment : Fragment() {

    private val dashboardViewModel: DashboardViewModel by viewModels()
    private var binding:FragmentDashboardBinding ?= null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.refreshLayout?.isRefreshing = true
        binding?.refreshLayout?.setOnRefreshListener {

        }
    }

    override fun onDestroy() {
        binding = null
        super.onDestroy()
    }
}