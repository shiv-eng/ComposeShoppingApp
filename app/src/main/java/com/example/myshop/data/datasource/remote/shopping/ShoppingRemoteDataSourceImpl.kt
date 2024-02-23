package com.example.myshop.data.datasource.remote.shopping

import com.example.myshop.common.Response
import com.example.myshop.common.caller.apiCall
import com.example.myshop.data.datasource.remote.api.ShoppingApi
import com.example.myshop.model.shopping.Product
import javax.inject.Inject

class ShoppingRemoteDataSourceImpl @Inject constructor(
    private val api: ShoppingApi
): ShoppingRemoteDataSource {

    override suspend fun getCategories(): Response<List<String>> = apiCall { api.getCategories() }

    override suspend fun getProducts(): Response<List<Product>> = apiCall { api.getProducts() }
}