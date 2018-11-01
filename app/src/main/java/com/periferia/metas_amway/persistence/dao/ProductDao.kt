package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Product

@Dao
interface ProductDao {

    @Insert
    fun saveProduct(product: Product)

    @Query("SELECT * FROM product")
    fun productList() : List<Product>

}