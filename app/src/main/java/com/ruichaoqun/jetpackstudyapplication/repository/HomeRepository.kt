package com.ruichaoqun.jetpackstudyapplication.repository

import com.ruichaoqun.jetpackstudyapplication.net.*
import com.ruichaoqun.jetpackstudyapplication.net.ApiResponse.Companion.create
import com.ruichaoqun.jetpackstudyapplication.utils.whatIfNotNull
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 14:09
 * @Description:    HomeRepository
 * @Version:        1.0
 */
class HomeRepository @Inject constructor(private val wanAndroidService:WanAndroidService){

    suspend fun getHomeList(page:Int) =
        flow {
             transferData { wanAndroidService.getHomeList(page) }
                 .onSuccess {
                     data.whatIfNotNull{
                         emit(it)
                     }

                 }
                 .onError {

                 }
        }


    fun <T> transferData(fetchResponse:()-> BaseResponse<T>):BaseResponse<T>{
        return try {
            fetchResponse()
        }catch (e:Exception){
            BaseResponse(null,"未知错误",-1)
        }
    }
}