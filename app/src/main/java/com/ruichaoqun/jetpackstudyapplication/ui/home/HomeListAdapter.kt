package com.ruichaoqun.jetpackstudyapplication.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.ruichaoqun.jetpackstudyapplication.AppExecutors
import com.ruichaoqun.jetpackstudyapplication.base.DataBindAdapter
import com.ruichaoqun.jetpackstudyapplication.data.HomeListBean
import com.ruichaoqun.jetpackstudyapplication.databinding.ItemAdapterHomeListBinding

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 11:39
 * @Description:    HomeListAdapter
 * @Version:        1.0
 */
class HomeListAdapter (appExecutors: AppExecutors):DataBindAdapter<HomeListBean.Data,ItemAdapterHomeListBinding>(
    appExecutors = appExecutors,
    diffCallback = object :DiffUtil.ItemCallback<HomeListBean.Data>(){
        override fun areItemsTheSame(
            oldItem: HomeListBean.Data,
            newItem: HomeListBean.Data
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: HomeListBean.Data,
            newItem: HomeListBean.Data
        ): Boolean {
            return oldItem.collect == newItem.collect
        }
    }
){
    override fun createBinding(parent: ViewGroup, viewType: Int): ItemAdapterHomeListBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            viewType,
            parent,
            false
        )
    }

    override fun bind(binding: ItemAdapterHomeListBinding, item: HomeListBean.Data) {
        binding.data = item
    }
}