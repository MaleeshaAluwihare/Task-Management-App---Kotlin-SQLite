package com.example.trekgo

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter (private var task: List<Task>,context: Context) :
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

        private val db: TasksDatabase = TasksDatabase(context)

    class TaskViewHolder(taskView:View): RecyclerView.ViewHolder(taskView){
        val nameTextView: TextView = taskView.findViewById(R.id.nameTextview)
        val dateTextView: TextView = taskView.findViewById(R.id.dateTextView)
        val timeTextView: TextView = taskView.findViewById(R.id.timeTextView)
        val descriptionTextView: TextView = taskView.findViewById(R.id.descriptionTextView)
        val updateButton: ImageView = taskView.findViewById(R.id.UpdateBtn)
        val deleteButton: ImageView = taskView.findViewById(R.id.DeleteBtn)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task  = task[position]
        holder.nameTextView.text = task.name
        holder.dateTextView.text = task.date
        holder.timeTextView.text = task.time
        holder.descriptionTextView.text = task.description

        holder.updateButton.setOnClickListener{
            val intent = Intent(holder.itemView.context,TaskUpdateActivity::class.java).apply {
                putExtra("task_id",task.id)
            }
            holder.itemView.context.startActivity(intent)
        }

        holder.deleteButton.setOnClickListener{
            db.deleteTask(task.id)
            refreshData(db.getAllTasks())
            Toast.makeText(holder.itemView.context,"Task Deleted",Toast.LENGTH_SHORT).show()
        }
    }

    fun refreshData(newTask: List<Task>){
        task = newTask
        notifyDataSetChanged()
    }
}