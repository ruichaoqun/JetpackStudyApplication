package com.ruichaoqun.jetpackstudyapplication.repository

import com.ruichaoqun.jetpackstudyapplication.net.*
import com.ruichaoqun.jetpackstudyapplication.net.ApiResponse.Companion.create
import com.ruichaoqun.jetpackstudyapplication.utils.whatIfNotNull
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
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

    suspend fun getHomeList(page:Int) = transferData { wanAndroidService.getHomeList(page) }



    suspend fun <T> transferData(fetchResponse:suspend ()-> BaseResponse<T>):BaseResponse<T>{
        return try {
            fetchResponse()
        }catch (e:Exception){
            BaseResponse(null,"未知错误",-1)
        }
    }
}