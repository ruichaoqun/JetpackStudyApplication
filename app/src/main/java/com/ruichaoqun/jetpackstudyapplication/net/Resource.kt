package com.ruichaoqun.jetpackstudyapplication.net

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/3 14:53
 * @Description:    Resource
 * @Version:        1.0
 */
data class Resource<out T>(val status:Status,val data:T?,val message:String?,val code:Int?){
    companion object{
        fun <T> success(data:T?): Resource<T> {
            return Resource(
                Status.SUCCESS,
                data,
                null,
                null
            )
        }

        fun <T> error(code:Int,msg:String): Resource<T> {
            return Resource(
                Status.ERROR,
                null,
                msg,
                null
            )
        }

        fun <T> loading(): Resource<T> {
            return Resource(
                Status.LOADING,
                null,
                "",
                null
            )
        }
     }
}