package com.example.paging3withroom.di

import android.app.Application
import com.example.paging3withroom.db.AppDao
import com.example.paging3withroom.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun getAppDatabase(context: Application):AppDatabase{
        return AppDatabase.getAppDbInstance(context)
    }

    @Singleton
    @Provides
    fun appDao(appDatabase: AppDatabase) : AppDao{
        return appDatabase.getAppDao()
    }



}