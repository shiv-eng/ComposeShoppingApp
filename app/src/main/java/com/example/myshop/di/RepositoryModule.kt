package com.example.myshop.di

import com.example.myshop.data.datasource.local.shopping.cart.CartLocalDataSource
import com.example.myshop.data.datasource.local.shopping.favorite_product.FavoriteProductLocalDatasource
import com.example.myshop.data.datasource.local.shopping.product.ProductLocalDataSource
import com.example.myshop.data.datasource.remote.firebase.auth.FirebaseAuthDataSource
import com.example.myshop.data.datasource.remote.firebase.fcm.FirebaseFcmDataSource
import com.example.myshop.data.datasource.remote.firebase.storage.FirebaseStorageDataSource
import com.example.myshop.data.datasource.remote.firebase.store.FirebaseFirestoreDataSource
import com.example.myshop.data.datasource.remote.shopping.ShoppingRemoteDataSource
import com.example.myshop.domain.repository.FirebaseRepository
import com.example.myshop.data.repository.FirebaseRepositoryImpl
import com.example.myshop.domain.repository.ShoppingRepository
import com.example.myshop.data.repository.ShoppingRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    @Provides
    @Singleton
    fun provideFirebaseRepository(
        authDataSource: FirebaseAuthDataSource,
        storageDataSource: FirebaseStorageDataSource,
        firestoreDataSource: FirebaseFirestoreDataSource,
        fcmDataSource: FirebaseFcmDataSource
    ): FirebaseRepository {
        return FirebaseRepositoryImpl(
            authDataSource,
            storageDataSource,
            firestoreDataSource,
            fcmDataSource
        )
    }

    @Provides
    @Singleton
    fun provideShoppingRepository(
        remoteDataSource: ShoppingRemoteDataSource,
        productLocalDataSource: ProductLocalDataSource,
        favoriteProductLocalDatasource: FavoriteProductLocalDatasource,
        cartLocalDataSource: CartLocalDataSource
    ): ShoppingRepository {
        return ShoppingRepositoryImpl(
            remoteDataSource,
            productLocalDataSource,
            favoriteProductLocalDatasource,
            cartLocalDataSource
        )
    }
}