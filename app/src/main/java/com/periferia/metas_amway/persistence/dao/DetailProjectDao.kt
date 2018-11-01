package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailProject

@Dao
interface DetailProjectDao {

    @Insert
    fun saveDetailProject(detail: DetailProject)

    @Query("SELECT * FROM detail_project")
    fun detailList() : List<DetailProject>
}