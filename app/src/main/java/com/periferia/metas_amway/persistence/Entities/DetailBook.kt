package com.periferia.metas_amway.persistence.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



@Entity(tableName = "detail_book")
class DetailBook {

    @PrimaryKey(autoGenerate = true)
    var id:Int? = null

    var idGoal: Int? = null

    @ColumnInfo(name = "last_page_read")
    var lastPageRead:Int? = null

    var created:String? = null

}