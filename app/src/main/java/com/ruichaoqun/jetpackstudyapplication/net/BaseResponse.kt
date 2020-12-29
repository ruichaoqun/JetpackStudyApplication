package com.ruichaoqun.jetpackstudyapplication.net

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 17:20
 * @Description:    BaseResponse
 * @Version:        1.0
 */
class BaseResponse<T>(val data:T?,val message:String,val code:Int)

@JvmSynthetic
suspend fun <T> BaseResponse<T>.onSuccess(
    onResult: suspend BaseResponse<T>.() -> Unit
): BaseResponse<T> {
    if (this.code == 0) {
        onResult(this)
    }
    return this
}

suspend fun <T> BaseResponse<T>.onError(
    onResult: suspend BaseResponse<T>.() -> Unit
): BaseResponse<T> {
    if (this.code != 0) {
        onResult(this)
    }
    return this
}