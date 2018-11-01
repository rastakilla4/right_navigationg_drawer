package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Event


@Dao
interface EventDao {

    @Insert
    fun saveEvent(event:Event)

    @Query("SELECT * FROM event")
    fun eventList() : List<Event>

}