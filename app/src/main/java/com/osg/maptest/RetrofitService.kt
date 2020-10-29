package com.osg.maptest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RetrofitService {
    @Headers("X-NCP-APIGW-API-KEY-ID: qfcpl7h66t", "X-NCP-APIGW-API-KEY: AtBE3v1W0hyiMTUraoNNkScUzaUffhQzxTWtJqrL")
    @GET("/map-geocode/v2/geocode?")
    fun getGeo(@Query("query") query: String?): Call<String?>?

    @Headers("X-NCP-APIGW-API-KEY-ID: qfcpl7h66t", "X-NCP-APIGW-API-KEY: AtBE3v1W0hyiMTUraoNNkScUzaUffhQzxTWtJqrL")
    @GET("/map-direction-15/v1/driving")
    fun getDir(@Query("start") start: String?, @Query("goal") goal: String?): Call<String?>?
}