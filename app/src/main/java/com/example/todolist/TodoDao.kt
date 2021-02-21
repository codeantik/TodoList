package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(todo: Todo)

    @Delete
    suspend fun delete(todo: Todo)

    @Query("Select * from todo_table order by id ASC")
    fun getAllTodo(): LiveData<List<Todo>>
}