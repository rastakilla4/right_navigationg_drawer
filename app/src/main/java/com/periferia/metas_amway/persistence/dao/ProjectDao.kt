package com.periferia.metas_amway.persistence.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.periferia.metas_amway.persistence.Entities.Project


@Dao
interface ProjectDao {

    @Insert
    fun saveProject(project: Project)

    @Query("SELECT * FROM project")
    fun projectList() : List<Project>
}