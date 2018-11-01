package com.periferia.metas_amway.persistence.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_sale")
class DetailSale {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "id_product")
    var idProduct: Int? = null

    @ColumnInfo(name = "product_name")
    var productName: String? = null

    var quantity: Int? = null

    @ColumnInfo(name = "sale_price")
    var salePrice: Int? = null

    var points: Int? = null

    var subTotal: Int? = null
}