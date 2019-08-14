package com.example.todolistinkotlin

import android.app.Application
import android.util.Log
import android.view.View
import androidx.annotation.WorkerThread
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.todolistinkotlin.database.ToDoListDataEntity
import com.example.todolistinkotlin.database.ToDoListDatabase

/**
 *   Created by Swati Kulkarni on 5/8/19.
 */
class ToDoListViewModel(val context: Application) : AndroidViewModel(context) {
    var toDoListData = MutableLiveData<ToDoListData>()

    var database: ToDoListDatabase? = null

    var getAllData = mutableListOf(ToDoListDataEntity())
    val toDoList = MutableLiveData<List<ToDoListDataEntity>>()


    init {
        database = ToDoListDatabase.getInstance(context)
        database?.toDoListDao()?.getAll()?.let {
            getAllData = it as MutableList<ToDoListDataEntity>
        }
    }

    var title = ObservableField<String>("")
    var date = ObservableField<String>("")
    var time = ObservableField<String>("")
    var position: Int = -1;
    var index: Long = -1;


    fun click(v: View) {


        Log.d("Click", "click")
        if (title.get().toString().isNotBlank() && date.get().toString().isNotBlank() && time.get().toString().isNotBlank()) {
            addData(title.get().toString(), date.get().toString(), time.get().toString(),id = index)
          }

        title.set("")
        date.set("")
        time.set("")
    }

    @WorkerThread
    private fun addData(title: String, date: String, time: String,id: Long) {
        //database?.toDoListDao()?.insert(ToDoListDataEntity(title = title, date = date, time = time))
        if(position!=-1){
            database?.toDoListDao()?.update(title = title, date = date, time = time,id = id )
        }else{
            database?.toDoListDao()?.insert(ToDoListDataEntity(title = title, date = date, time = time))
        }

        database?.toDoListDao()?.getAll().let {
            getAllData = it as MutableList<ToDoListDataEntity>
            getPreviousList()
        }
    }


    fun getPreviousList() {
        toDoList.value = getAllData
    }

    fun delete(id : Long){
        database?.toDoListDao()?.Delete(id)
        database?.toDoListDao()?.getAll().let {
            getAllData = it as MutableList<ToDoListDataEntity>
            getPreviousList()
        }
    }
}