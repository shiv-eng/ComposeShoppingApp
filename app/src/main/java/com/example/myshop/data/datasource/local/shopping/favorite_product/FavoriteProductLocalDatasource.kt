package com.example.myshop.data.datasource.local.shopping.favorite_product

import com.example.myshop.common.Response
import com.example.myshop.model.shopping.ProductEntity

interface FavoriteProductLocalDatasource {

    suspend fun addFavoriteProduct(productEntity: ProductEntity): Response<Unit>

    suspend fun getAllFavoriteProducts(): Response<List<ProductEntity>>

    suspend fun findFavoriteProduct(productId: Int): Response<ProductEntity?>

    suspend fun removeFavoriteProduct(productId: Int): Response<Unit>
}