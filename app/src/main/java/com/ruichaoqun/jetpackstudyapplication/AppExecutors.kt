package com.ruichaoqun.jetpackstudyapplication

import android.os.Handler
import android.os.Looper
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject
import javax.inject.Singleton

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/28 11:22
 * @Description:    AppExecutors
 * @Version:        1.0
 */
@Singleton
open class AppExecutors(
    private val diskIo: Executor,
    private val networkIo: Executor,
    private val mainThread: Executor
) {
    @Inject
    constructor():this(
        Executors.newSingleThreadExecutor(),
        Executors.newFixedThreadPool(3),
        MainThreadExecutor()
    )

    fun diskIo():Executor{
        return diskIo
    }

    fun networkIo():Executor{
        return networkIo
    }

    fun mainThread():Executor{
        return mainThread
    }

    private class MainThreadExecutor:Executor{
        /**
         * Executes the given command at some time in the future.  The command
         * may execute in a new thread, in a pooled thread, or in the calling
         * thread, at the discretion of the `Executor` implementation.
         *
         * @param command the runnable task
         * @throws RejectedExecutionException if this task cannot be
         * accepted for execution
         * @throws NullPointerException if command is null
         */
        private val mainThreadHandler = Handler(Looper.getMainLooper())
        override fun execute(command: Runnable?) {
            mainThreadHandler.post(command)
        }

    }
}