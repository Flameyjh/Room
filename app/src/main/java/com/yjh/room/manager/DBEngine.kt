package com.yjh.room.manager

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import com.yjh.room.Student
import com.yjh.room.StudentDao
import com.yjh.room.StudentDatabase

//DB的引擎
class DBEngine(context: Context) {

    val studentDatabase = StudentDatabase.getInstance(context)
    val studentDao = studentDatabase.getStudentDao()

    //Dao增删改查

    //insert插入
    fun insertStudents(vararg students: Student){
        InsertAsyncTask(studentDao).execute(*students)
    }

    //update更新
    fun updateStudents(vararg students: Student){
        UpdateAsyncTask(studentDao).execute(*students)
    }

    //delete删除 条件
    fun deleteStudents(vararg students: Student){
        DeleteAsyncTask(studentDao).execute(*students)
    }

    //delete删除 全部
    fun deleteAllStudents(){
        DeleteAllAsyncTask(studentDao).execute()
    }

    //query查询 全部
    fun queryAllStudents(){
        QueryAllAsyncTask(studentDao).execute()
    }

    //异步操作
    companion object{
        val TAG = "DBEngine"

        //insert插入
        class InsertAsyncTask(studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
            val dao = studentDao
            override fun doInBackground(vararg p0: Student): Void? {
                dao.insertStudents(*p0)
                return null
            }
        }

        //update更新
        class UpdateAsyncTask(studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
            val dao = studentDao
            override fun doInBackground(vararg p0: Student): Void? {
                dao.updateStudents(*p0)
                return null
            }
        }

        //delete删除 条件
        class DeleteAsyncTask(studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
            val dao = studentDao
            override fun doInBackground(vararg p0: Student): Void? {
                dao.deleteStudents(*p0)
                return null
            }
        }

        //delete删除 全部
        class DeleteAllAsyncTask(studentDao: StudentDao) : AsyncTask<Void, Void, Void>() {
            val dao = studentDao
            override fun doInBackground(vararg p0: Void?): Void? {
                dao.daleteAllStudents()
                return null
            }
        }

        //query查询 全部
        class QueryAllAsyncTask(studentDao: StudentDao) : AsyncTask<Void, Void, Void>() {
            val dao = studentDao
            override fun doInBackground(vararg p0: Void?): Void? {
                val allstudent = dao.getAllStudents()

                //打印全部查询结果
                for (student in allstudent){
                    Log.e(TAG, "doInBackground：查询结果：id = " + student.id + ", " + student.toString())
                }
                return null
            }
        }

    }
}