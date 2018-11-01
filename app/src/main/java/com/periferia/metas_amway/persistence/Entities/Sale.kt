package com.periferia.metas_amway.persistence.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "sales")
class Sale {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var idClient: Int? = null

    var total: Int? = null

    var pointsAdquired: Int? = null

    var created: String? = null
}