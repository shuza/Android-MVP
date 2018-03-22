package me.shuza.android_mvp.injection.modules

import com.google.gson.GsonBuilder
import com.orhanobut.logger.Logger
import dagger.Module
import dagger.Provides
import me.shuza.android_mvp.models.StudentModel
import me.shuza.android_mvp.networkIO.ApiService
import me.shuza.android_mvp.networkIO.BASE_URL
import me.shuza.android_mvp.networkIO.deserializers.StudentDeserializer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/23/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/

@Module
class NetworkModule {

    @Provides
    fun provideClient(): OkHttpClient {
        var interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BASIC
        var interceptorBody = HttpLoggingInterceptor()
        interceptorBody.level = HttpLoggingInterceptor.Level.BODY

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(interceptorBody)
                .addInterceptor({ chain ->
                    var request = chain.request().newBuilder()
                            .addHeader("Token", "API_AUTHENTICATION_TOKEN")
                            .build()

                    Logger.d("URL   ==/   ${request.url()}")
                    Logger.d(request.headers())
                    chain.proceed(request)
                })
                .build()
    }

    @Provides
    fun provideRetrofit(baseUrl: String, client: OkHttpClient): Retrofit {
        val gson = GsonBuilder()
                .registerTypeAdapter(StudentModel::class.java, StudentDeserializer())
                .create()

        return Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
    }

    @Provides
    fun provideApiService(): ApiService {
        return provideRetrofit(BASE_URL, provideClient()).create(ApiService::class.java)
    }
}