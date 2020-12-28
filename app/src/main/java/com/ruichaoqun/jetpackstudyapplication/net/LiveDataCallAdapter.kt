package com.android.example.livedatabuilder.utils

import androidx.lifecycle.LiveData
import com.ruichaoqun.jetpackstudyapplication.net.ApiResponse
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/24 14:46
 * @Description:    LiveDataCallAdapter
 * @Version:        1.0
 */
class LiveDataCallAdapter<R>(private val responseType:Type):CallAdapter<R,LiveData<ApiResponse<R>>> {
    override fun adapt(call: Call<R>): LiveData<ApiResponse<R>> {
        return object:LiveData<ApiResponse<R>>(){
            private var started = AtomicBoolean(false)
            override fun onActive() {
                super.onActive()
                if(started.compareAndSet(false,true)){
                    call.enqueue(object : Callback<R>{
                        /**
                         * Invoked when a network exception occurred talking to the server or when an unexpected exception
                         * occurred creating the request or processing the response.
                         */
                        override fun onFailure(call: Call<R>, t: Throwable) {
                            postValue(ApiResponse.create(t))
                        }

                        /**
                         * Invoked for a received HTTP response.
                         *
                         *
                         * Note: An HTTP response may still indicate an application-level failure such as a 404 or 500.
                         * Call [Response.isSuccessful] to determine if the response indicates success.
                         */
                        override fun onResponse(call: Call<R>, response: Response<R>) {
                            postValue(ApiResponse.create(response))
                        }

                    })
                }
            }
        }
    }


    override fun responseType() = responseType
}