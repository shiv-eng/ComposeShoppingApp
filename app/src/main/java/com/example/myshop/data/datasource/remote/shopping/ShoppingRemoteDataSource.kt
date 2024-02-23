package com.example.myshop.data.datasource.remote.shopping

import com.example.myshop.common.Response
import com.example.myshop.model.shopping.Product

interface ShoppingRemoteDataSource {

    suspend fun getCategories(): Response<List<String>>

    suspend fun getProducts(): Response<List<Product>>
}