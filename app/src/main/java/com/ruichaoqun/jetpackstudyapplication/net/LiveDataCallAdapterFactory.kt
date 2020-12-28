package com.android.example.livedatabuilder.utils

import androidx.lifecycle.LiveData
import com.ruichaoqun.jetpackstudyapplication.net.ApiResponse
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/24 14:39
 * @Description:    LiveDataCallAdapterFactory
 * @Version:        1.0
 */
class LiveDataCallAdapterFactory:Factory() {
    /**
     * Returns a call adapter for interface methods that return `returnType`, or null if it
     * cannot be handled by this factory.
     */
    override fun get(
        returnType: Type,
        annotations: Array<Annotation>,
        retrofit: Retrofit
    ): CallAdapter<*, *>? {
        //如果返回类型不是LiveData，null
        if(getRawType(returnType) != LiveData::class.java){
            return null
        }
        //如果LiveData中的第一个泛型的Type
        var observerType = getParameterUpperBound(0,returnType as ParameterizedType)
        //获取该类型的class
        var rawObserverType = getRawType(observerType)
        if(rawObserverType != ApiResponse::class.java){
            throw IllegalArgumentException("type must be a ApiResponse")
        }
        if(observerType !is ParameterizedType){
            throw java.lang.IllegalArgumentException("resource must be a parameterized")
        }
        val bodyType = getParameterUpperBound(0,observerType)
        return LiveDataCallAdapter<Any>(bodyType)
    }
}