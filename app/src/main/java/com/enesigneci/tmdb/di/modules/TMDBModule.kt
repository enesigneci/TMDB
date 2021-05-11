package com.enesigneci.tmdb.di.modules

import com.enesigneci.tmdb.network.TMDBService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object TMDBModule {

    @Provides
    fun provideTMDBService(
        client: OkHttpClient
    ): TMDBService {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TMDBService::class.java)
    }

    @Provides
    fun provideOkHttpClient(

    ): OkHttpClient {
        var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

}