package com.example.myshop.data.mapper

import com.example.myshop.model.shopping.Product
import com.example.myshop.model.shopping.ProductEntity
import com.example.myshop.model.shopping.Rating

fun Product.toProductEntity(): ProductEntity {
    return ProductEntity(
        id = this.id,
        title = this.title,
        price = this.price,
        description = this.description,
        category = this.category,
        image = this.image,
        rating = this.rating?.rate,
        count = this.rating?.count
    )
}

fun ProductEntity.toProduct(): Product {
    return Product(
        id,
        title,
        price,
        description,
        category,
        image,
        Rating(
            rating,
            count
        )
    )
}