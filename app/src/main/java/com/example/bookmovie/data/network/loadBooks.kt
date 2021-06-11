package com.example.bookmovie.data.network

import com.example.bookmovie.data.Model.Pizza
import com.example.bookmovie.data.Model.PizzaItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://order-pizza-api.herokuapp.com/api/"

interface PizzaInterface{

    @GET("orders")
    suspend fun getOrder() : Response<Pizza>
}

object PizzaService{
    val instance: PizzaInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        instance = retrofit.create(PizzaInterface::class.java)
    }
}