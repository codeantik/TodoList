package com.example.todolist

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoRVAdapter(private val context: Context, private val listener: ITodoRVAdapter): RecyclerView.Adapter<TodoRVAdapter.TodoViewHolder>() {

    private val allTodo = ArrayList<Todo>()

    inner class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.text)
        val deleteButton: ImageView = itemView.findViewById(R.id.deleteButton)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val viewHolder = TodoViewHolder(LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false))
        viewHolder.deleteButton.setOnClickListener{
            listener.onItemClicked(allTodo[viewHolder.adapterPosition])
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentTodo = allTodo[position]
        holder.textView.text = currentTodo.text
    }

    override fun getItemCount(): Int {
        return allTodo.size
    }

    fun updateList(newList: List<Todo>) {
        allTodo.clear()
        allTodo.addAll(newList)

        notifyDataSetChanged()
    }
}

interface ITodoRVAdapter {
    fun onItemClicked(todo: Todo)
}