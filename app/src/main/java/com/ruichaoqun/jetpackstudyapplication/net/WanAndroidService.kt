package com.ruichaoqun.jetpackstudyapplication.net

import com.ruichaoqun.jetpackstudyapplication.data.HomeListBean
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/14 11:33
 * @Description:    WanAndroidService
 * @Version:        1.0
 */
interface WanAndroidService {
    @GET("list/{page}/json")
    fun getHomeList(@Path("page") page:Int? = 0):BaseResponse<HomeListBean>

}