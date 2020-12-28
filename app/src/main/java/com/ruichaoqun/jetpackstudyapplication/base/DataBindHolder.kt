package com.ruichaoqun.jetpackstudyapplication.base

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 11:17
 * @Description:    DataBindHolder
 * @Version:        1.0
 */
class DataBindHolder<T:ViewDataBinding>(val binding:T):RecyclerView.ViewHolder(binding.root)