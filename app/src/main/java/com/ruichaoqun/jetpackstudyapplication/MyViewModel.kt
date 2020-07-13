package com.ruichaoqun.jetpackstudyapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

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
        users.value = MutableList<User>().
    }

}

