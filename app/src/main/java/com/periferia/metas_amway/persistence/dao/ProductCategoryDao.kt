package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.ProductCategory

@Dao
interface ProductCategoryDao {


    @Insert
    fun saveCategory(category: ProductCategory)

    @Query("SELECT * FROM product_category")
    fun categoryList() : List<ProductCategory>

}