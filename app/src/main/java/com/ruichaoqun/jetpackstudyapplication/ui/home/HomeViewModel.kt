package com.ruichaoqun.jetpackstudyapplication.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.ruichaoqun.jetpackstudyapplication.data.HomeListBean
import com.ruichaoqun.jetpackstudyapplication.net.Resource
import com.ruichaoqun.jetpackstudyapplication.net.onError
import com.ruichaoqun.jetpackstudyapplication.net.onSuccess
import com.ruichaoqun.jetpackstudyapplication.repository.HomeRepository

class HomeViewModel @ViewModelInject constructor(val repository: HomeRepository): ViewModel() {
    private var pageNumber = MutableLiveData<Int>()

    var homeList:LiveData<Resource<HomeListBean>> = pageNumber.switchMap {page->
        liveData {
            emit(Resource.loading<HomeListBean>())
            repository.getHomeList(page)
                .onSuccess {
                    emit(Resource.success(data))
                }
                .onError {
                    emit(Resource.error<HomeListBean>(code,message))
                }
        }
    }

    init {
        pageNumber.postValue(0)
    }
}