package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Sale


@Dao
interface SaleDao {

    @Insert
    fun saveSale(sale: Sale)

    @Query("SELECT * FROM sales")
    fun saleList() : List<Sale>
}