package com.ruichaoqun.jetpackstudyapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/26 9:21
 * @Description:    RApp
 * @Version:        1.0
 */
@HiltAndroidApp
class RApp:Application() {
    override fun onCreate() {
        super.onCreate()
    }
}