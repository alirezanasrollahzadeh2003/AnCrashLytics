package com.alirezanasrollahzadeh.ancrashlytics.Services

import com.alirezanasrollahzadeh.ancrashlytics.Login_data
import com.google.gson.Gson
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

/*Developed By Alireza Nasrollahzadeh*/

interface ApiServices {

    @POST
    @FormUrlEncoded
    suspend fun SendData(@Url url:String,@Field("exception") exception:String = "",@Field("android_version")
    android_version:String = "",@Field("app_version") app_version:String = "") : Response<Login_data>

    companion object{
        operator fun invoke() : ApiServices{
            return Retrofit.Builder()
                .baseUrl("http://192.168.1.53/AlirezaNasrollahzadeh/")
                .addConverterFactory(GsonConverterFactory.create(Gson().newBuilder().setLenient().create()))
                .build()
                .create(ApiServices::class.java)
        }
    }
}