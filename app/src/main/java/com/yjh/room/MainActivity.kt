package com.yjh.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yjh.room.manager.DBEngine

class MainActivity : AppCompatActivity() {
    lateinit var dbEngine: DBEngine

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbEngine = DBEngine(this)
    }

    fun insertAction(view: View) {
        val student1 = Student("张三", 20)
        val student2 = Student("李四", 23)
        val student3 = Student("王五", 26)
        dbEngine.insertStudents(student1, student2, student3)
    }

    fun updateAction(view: View) {
        val student = Student("yjh", 24)
        student.id = 1
        dbEngine.updateStudents(student)
    }

    fun deleteAction(view: View) {
        val student = Student(null ,null)
        student.id = 1
        dbEngine.deleteStudents(student)
    }

    fun queryAction(view: View) {
        dbEngine.queryAllStudents()
    }

    fun deleteAllAction(view: View) {
        dbEngine.deleteAllStudents()
    }
}