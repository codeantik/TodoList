package com.example.todolist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_table")
class Todo(@ColumnInfo(name = "text") val text: String) {
    @PrimaryKey(autoGenerate = true) var id = 0
}