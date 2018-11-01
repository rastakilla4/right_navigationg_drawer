package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailAudio

@Dao
interface DetailAudioDao {

    @Insert
    fun saveDetailAudio(detail: DetailAudio)

    @Query("SELECT * FROM detail_audio")
    fun detailList() : List<DetailAudio>

}