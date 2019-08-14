package com.example.todolistinkotlin.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 *   Created by Swati Kulkarni on 13/8/19.
 */

@Dao
interface ToDoListDAO {
    @Query("SELECT * from todolist")
    fun getAll(): List<ToDoListDataEntity>

    @Insert
    fun insert(toDoListData: ToDoListDataEntity)

    @Query("UPDATE todolist  SET title = :title, date =:date, time = :time  where id LIKE :id")
    fun update(
        title: String,
        date: String,
        time: String,
        id: Long
    )

    @Query("DELETE From todolist where id = :id")
    fun Delete(id : Long)
}