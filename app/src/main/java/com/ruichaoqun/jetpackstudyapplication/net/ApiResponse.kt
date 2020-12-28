package com.ruichaoqun.jetpackstudyapplication.net

import retrofit2.Response

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/3 17:26
 * @Description:    ApiResponse
 * @Version:        1.0
 */
sealed class ApiResponse<T>{
    companion object{
        fun <T> create(error:Throwable):ApiErrorResponse<T>{
            return ApiErrorResponse(error.message?:"未知错误")
        }

        fun  <T> create(data:T):ApiResponse<T>{
            return ApiSuccessResponse(data)
        }
    }
}

class ApiSuccessResponse<T>(
    var data:T
):ApiResponse<T>()

class ApiErrorResponse<T>(var errorMessage:String):ApiResponse<T>()