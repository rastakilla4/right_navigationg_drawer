package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.DetailSale


@Dao
interface DetailSaleDao {

    @Insert
    fun saveDetailSale(detail: DetailSale)

    @Query("SELECT * FROM detail_sale")
    fun detailList() : List<DetailSale>
}