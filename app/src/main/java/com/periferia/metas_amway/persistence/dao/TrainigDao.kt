package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Training

@Dao
interface TrainigDao {

    @Insert
    fun saveTrainig(training: Training)

    @Query("SELECT * FROM training")
    fun trainingList() : List<Training>
}