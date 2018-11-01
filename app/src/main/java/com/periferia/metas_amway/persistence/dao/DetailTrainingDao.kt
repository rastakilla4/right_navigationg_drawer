package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailTraining

@Dao
interface DetailTrainingDao {

    @Insert
    fun saveDetailTraining(detail: DetailTraining)


    @Query("SELECT * FROM detail_training")
    fun detailList() : List<DetailTraining>

}