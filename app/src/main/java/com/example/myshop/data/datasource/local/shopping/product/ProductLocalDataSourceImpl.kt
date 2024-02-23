package com.example.myshop.data.datasource.local.shopping.product

import com.example.myshop.common.Response
import com.example.myshop.common.caller.dbCall
import com.example.myshop.data.datasource.local.shopping.product.db.ProductDao
import com.example.myshop.model.shopping.ProductEntity
import javax.inject.Inject

class ProductLocalDataSourceImpl @Inject constructor(private val productDao: ProductDao) :
    ProductLocalDataSource {

    override suspend fun addProduct(productEntity: ProductEntity): Response<Unit> {
        return dbCall { productDao.addProduct(productEntity) }
    }

    override suspend fun getAllProducts(): Response<List<ProductEntity>> {
        return dbCall { productDao.getAllProducts() }
    }
}