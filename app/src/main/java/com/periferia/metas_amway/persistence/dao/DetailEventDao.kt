package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailEvent

@Dao
interface DetailEventDao {

    @Insert
    fun saveDetailEvent( detail: DetailEvent )

    @Query("SELECT * FROM detail_event")
    fun detailList() : List<DetailEvent>

}