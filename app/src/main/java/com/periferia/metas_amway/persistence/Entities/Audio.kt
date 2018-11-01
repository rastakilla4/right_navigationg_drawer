package com.periferia.metas_amway.persistence.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "audio")
class Audio {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var name: Int? = null

    var quantity: Int? = null

    var created: String? = null

    var finished: String? = null
}