package com.example.myshop.data.datasource.local.shopping.product.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myshop.model.shopping.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class ProductDatabase : RoomDatabase() {

    abstract fun productDao() : ProductDao
}