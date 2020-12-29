package com.ruichaoqun.jetpackstudyapplication.base

import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.AsyncDifferConfig
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.ruichaoqun.jetpackstudyapplication.AppExecutors

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 11:15
 * @Description:    DataBindAdapter
 * @Version:        1.0
 */
abstract class DataBindAdapter<T, V : ViewDataBinding>(
    appExecutors: AppExecutors, diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, DataBindHolder<V>>(
    AsyncDifferConfig.Builder<T>(diffCallback).setBackgroundThreadExecutor(appExecutors.diskIo())
        .build()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindHolder<V> {
        val binding = createBinding(parent,viewType)
        return DataBindHolder(binding)
    }

    protected abstract fun createBinding(parent:ViewGroup,viewType: Int):V

    override fun onBindViewHolder(holder: DataBindHolder<V>, position: Int) {
        bind(holder.binding,getItem(position))
        holder.binding.executePendingBindings()
    }

    abstract fun bind(binding: V, item: T)
}