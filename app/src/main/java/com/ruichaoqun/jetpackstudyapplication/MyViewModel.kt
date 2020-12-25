package com.ruichaoqun.jetpackstudyapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author Rui Chaoqun
 * @date :2020/7/13 14:21
 * description:
 */
class MyViewModel: ViewModel() {
    private val users: MutableLiveData<List<User>> by lazy {
        MutableLiveData<List<User>>().also {
            loadUsers()
        }
    }

    fun getUser(): MutableLiveData<List<User>> {
        return users
    }

    private fun loadUsers() {

    }

}

