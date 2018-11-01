package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Audio

@Dao
interface AudioDao {

    @Insert
    fun saveAudio(audio:Audio)

    @Query("SELECT * FROM audio")
    fun audios() : List<Audio>


}