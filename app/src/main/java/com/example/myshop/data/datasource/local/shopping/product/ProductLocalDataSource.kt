package com.example.myshop.data.datasource.local.shopping.product

import com.example.myshop.common.Response
import com.example.myshop.model.shopping.ProductEntity

interface ProductLocalDataSource {

    suspend fun addProduct(productEntity: ProductEntity): Response<Unit>

    suspend fun getAllProducts(): Response<List<ProductEntity>>
}