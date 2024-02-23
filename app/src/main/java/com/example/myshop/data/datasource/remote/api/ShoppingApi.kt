package com.example.myshop.data.datasource.remote.api

import com.example.myshop.model.shopping.Product
import com.example.myshop.utils.EndPoints
import retrofit2.http.GET

interface ShoppingApi {

    @GET(EndPoints.CATEGORY)
    suspend fun getCategories(): ArrayList<String>

    @GET(EndPoints.PRODUCT)
    suspend fun getProducts(): List<Product>
}