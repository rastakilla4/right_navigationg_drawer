package com.periferia.metas_amway.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.periferia.metas_amway.persistence.AppDb.Companion.DATABASE_VERSION
import com.periferia.metas_amway.persistence.Entities.*
import com.periferia.metas_amway.persistence.dao.*

@Database(entities = [(Book::class),
    (Audio::class),
    (DetailAudio::class),
    (DetailBook::class),
    (DetailEvent::class),
    (DetailProject::class),
    (DetailSale::class),
    (DetailTraining::class),
    (Event::class),
    (Product::class),
    (ProductCategory::class),
    (Project::class),
    (Sale::class),
    (Training::class)] , version = DATABASE_VERSION)
abstract class AppDb : RoomDatabase() {

    abstract fun audioDao(): AudioDao
    abstract fun bookDao(): BookDao
    abstract fun detailAudioDao(): DetailAudioDao
    abstract fun detailBookDao(): DetailBookDao
    abstract fun detailEventDao(): DetailEventDao
    abstract fun detailProjectDao(): DetailProjectDao
    abstract fun detailSaleDao(): DetailSaleDao
    abstract fun detailTrainingDao(): DetailTrainingDao
    abstract fun evenDao(): EventDao
    abstract fun productCategoryDao(): ProductCategoryDao
    abstract fun producDao(): ProductDao
    abstract fun projectDao(): ProjectDao
    abstract fun saleDao(): SaleDao
    abstract fun trainingDao(): TrainigDao


    companion object {
        const val DATABASE_VERSION = 1
                    val DATABASE_NAME = "amway_goals"

                    private var mIstance: AppDb? = null

                    fun getInstance(context:Context):AppDb {
                        if (mIstance == null) {
                            synchronized(AppDb::class) {
                    mIstance = Room.databaseBuilder(context.applicationContext,
                            AppDb::class.java,
                            DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build()
                }
            }

            return mIstance!!
        }

        fun destroyInstance() {
            mIstance = null
        }
    }
}