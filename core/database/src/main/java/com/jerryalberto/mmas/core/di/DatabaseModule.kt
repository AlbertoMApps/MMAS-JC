package com.jerryalberto.mmas.core.di

import android.content.Context
import androidx.room.Room
import com.jerryalberto.mmas.core.database.MmasDatabase
import com.jerryalberto.mmas.core.database.dao.MoneyDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideAssessmentDatabase(@ApplicationContext context: Context): MmasDatabase {
        return Room.databaseBuilder(
            context,
            MmasDatabase::class.java,
            "MmasDatabase.db"
        ).build()
    }

    @Provides
    fun providesMoneyDao(
        database: MmasDatabase,
    ): MoneyDao = database.moneyDao()

}