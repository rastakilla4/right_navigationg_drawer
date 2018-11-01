package com.periferia.metas_amway.persistence.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "book")
class Book {

    @PrimaryKey(autoGenerate = true)
    var id: Int ? = null

    @ColumnInfo(name = "total_pages")
    var totalPages: Int? = null

    var name: String? = null

    @ColumnInfo(name = "current_page")
    var currentPage: Int = 0

    var created: String = ""

    var finished: Int = 0

}