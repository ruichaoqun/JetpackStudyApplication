package com.ruichaoqun.jetpackstudyapplication.utils

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 17:41
 * @Description:    WhatIf
 * @Version:        1.0
 */
public inline fun <T> T?.whatIfNotNull(whatIf: (T) -> Unit,whatIfNot:() -> Unit): T?{
    if(this != null){
        whatIf(this)
        return this
    }
    whatIfNot()
    return this
}

public inline fun <T> T?.whatIfNotNull(whatIf: (T) -> Unit): T?{
    return whatIfNotNull(
        whatIf = whatIf,
        whatIfNot = {}
    )
}