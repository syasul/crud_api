package com.example.api_pbb.network

import com.example.api_pbb.model.ResultStaff
import com.example.api_pbb.model.ResultStatus
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface StaffService{
    @FormUrlEncoded
    @POST("addStaff")
    fun  addStaff(@Field("name") name : String,
                  @Field("hp") hp : String,
                  @Field("alamat") alamat : String) : Call<ResultStatus>

    @GET("getDataStaff")

    fun getData() : Call<ResultStaff>

    @FormUrlEncoded
    @POST("updateStaff")
    fun  updateStaff(@Field("id") id : String,
                     @Field("name") name : String,
                     @Field("hp") hp : String,
                     @Field("alamat") alamat : String) : Call<ResultStatus>

    @FormUrlEncoded
    @POST("deleteStaff")
    fun  deleteStaff(@Field("id") id : String?) : Call<ResultStatus>
}