package com.periferia.metas_amway.persistence.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "project")
class Project {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    var category: Int? = null

    var name:String? = null

    var quantity:String? = null

    var created:String? = null

    var finished:String? = null
}