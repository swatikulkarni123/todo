package com.example.todolistinkotlin.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *   Created by Swati Kulkarni on 5/8/19.
 */

@Entity(tableName = "todolist")
data class ToDoListDataEntity (
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "title" ) val title : String ="",
    @ColumnInfo(name = "date" ) val date : String="",
    @ColumnInfo(name = "time" ) val time : String="",
    @ColumnInfo(name = "isShow" ) val isShow : Int=0
)
