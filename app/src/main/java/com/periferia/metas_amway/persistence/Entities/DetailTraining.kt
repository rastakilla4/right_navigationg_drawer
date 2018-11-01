package com.periferia.metas_amway.persistence.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detail_training")
class DetailTraining {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var idGoal: Int? = null

    var name: String? = null

    var created: String? = null
}