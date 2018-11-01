package com.periferia.metas_amway.persistence.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product_category")
class ProductCategory {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var name: String? = null

    var description: String? = null

}