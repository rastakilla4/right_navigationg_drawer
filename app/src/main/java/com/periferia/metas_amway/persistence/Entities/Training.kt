package com.periferia.metas_amway.persistence.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training")
class Training {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var category:String? = null

    var name:String? = null

    var quantity:Int? = null

    var created:String? = null

    var finished:String? = null

}