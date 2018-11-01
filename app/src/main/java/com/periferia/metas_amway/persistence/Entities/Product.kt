package com.periferia.metas_amway.persistence.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "product")
class Product {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "id_category")
    var idCategory: Int? = null

    var name: String? = null

    var description: String? = null

    @ColumnInfo(name = "purchase_price")
    var purchasePrice: Int? = null

    var points: Int? = null

    var stock: Int? = null

}