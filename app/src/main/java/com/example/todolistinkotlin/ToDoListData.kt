package com.example.todolistinkotlin

import androidx.room.Entity

/**
 *   Created by Swati Kulkarni on 5/8/19.
 */


class ToDoListData(
    val title: String = "",
    val date: String = "",
    val time: String = "",
    var indexDb: Long = 0,
    val isShow : Int = 0
)