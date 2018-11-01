package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailBook

@Dao
interface DetailBookDao {

    @Insert
    fun saveDetailBook(detail:DetailBook)

    @Query("SELECT * FROM detail_book")
    fun detailList() : List<DetailBook>

    @Query("SELECT * FROM detail_book WHERE idGoal = :idBook")
    fun historyList(idBook:Int) :List<DetailBook>

}