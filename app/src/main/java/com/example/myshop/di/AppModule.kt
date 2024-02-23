package com.example.myshop.di

import android.content.Context
import com.example.myshop.BuildConfig
import com.example.myshop.common.helpers.PreferenceManager
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.FirebaseStorage
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance()

    @Provides
    @Singleton
    fun provideFirestore(@ApplicationContext context: Context): FirebaseFirestore {
        val options = FirebaseOptions.Builder()
            .setProjectId(BuildConfig.PROJECT_ID)
            .setApplicationId(BuildConfig.APPLICATION_ID)
            .setApiKey(BuildConfig.API_KEY)
            .build()

        FirebaseApp.initializeApp(context, options, "secondary")
        val secondary = FirebaseApp.getInstance("secondary")

        return FirebaseFirestore.getInstance(secondary)
    }

    @Provides
    @Singleton
    fun provideDispatcherIO(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Singleton
    fun provideFirebaseMessaging(): FirebaseMessaging = FirebaseMessaging.getInstance()

    @Provides
    @Singleton
    fun providePreferenceManager(@ApplicationContext context: Context): PreferenceManager =
        PreferenceManager(context)
}
