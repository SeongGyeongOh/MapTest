package com.osg.maptest

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class RetrofitHelper {
    val retrofit: Retrofit
        get() {
            return Retrofit.Builder()
                    .baseUrl("https://naveropenapi.apigw.ntruss.com")
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build()
        }
}