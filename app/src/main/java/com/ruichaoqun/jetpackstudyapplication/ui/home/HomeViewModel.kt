package com.ruichaoqun.jetpackstudyapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ruichaoqun.jetpackstudyapplication.data.HomeListBean

class HomeViewModel : ViewModel() {
    val mDataList:LiveData<HomeListBean> = MutableLiveData()
    private val pageNumber:LiveData<Int> = MutableLiveData(0)

    init {
        mDataList =
    }

    fun loadMore(){
        pageNumber.value++
    }
}