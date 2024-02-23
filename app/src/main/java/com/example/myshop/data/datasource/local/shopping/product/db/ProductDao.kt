package com.example.myshop.data.datasource.local.shopping.product.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myshop.model.shopping.ProductEntity

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM ProductEntity")
    suspend fun getAllProducts(): List<ProductEntity>
}