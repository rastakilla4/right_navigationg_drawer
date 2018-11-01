package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.periferia.metas_amway.persistence.Entities.Book

@Dao
interface BookDao {

    @Insert
    fun saveBook(book:Book)

    @Query("SELECT * FROM book")
    fun bookList() : List<Book>

    @Update
    fun setCurrentPage(book:Book)


}