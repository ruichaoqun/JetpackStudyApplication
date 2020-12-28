package com.ruichaoqun.jetpackstudyapplication.di

import com.android.example.livedatabuilder.utils.LiveDataCallAdapterFactory
import com.google.gson.Gson
import com.ruichaoqun.jetpackstudyapplication.net.WanAndroidService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * @Author:         芮超群
 * @CreateDate:     2020/12/24 15:52
 * @Description:    AppModule
 * @Version:        1.0
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    fun providesWanAndroidService(retrofit:Retrofit): WanAndroidService?{
        return retrofit.create(WanAndroidService::class.java)
    }

    @Provides
    fun provideRetrofit(okHttpClient:OkHttpClient,gson:Gson):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }

    @Provides
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor())
            .build()
    }

    @Provides
    fun provideGson():Gson{
        return Gson()
    }
}