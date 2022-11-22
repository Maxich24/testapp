package com.example.testgravity2

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class Model: MainContract.Model {
    companion object {
        private val reqUrl = "https://efs5i1ube5.execute-api.eu-central-1.amazonaws.com/"
    }

    override fun loadMessage(callback: MainContract.MyCallback){

        val retrofit = Retrofit.Builder()
            .baseUrl(reqUrl)
            .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        val apiService: APIService = retrofit.create(APIService::class.java)
        apiService.getData()?.enqueue(object : Callback<String?> {
            override fun onResponse(call: Call<String?>, response: Response<String?>) {
                val resp = response.body()
                callback.success(resp);
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {callback.failure(t)}

        })
    }
}