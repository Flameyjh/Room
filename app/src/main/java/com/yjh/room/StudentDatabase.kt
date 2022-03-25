package com.yjh.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//数据库 关联 之前的 表 数据库信息
@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class StudentDatabase : RoomDatabase() {

    //暴露Dao给用户使用
    abstract fun getStudentDao(): StudentDao

    //单例模式 返回DB
    companion object {
        var INSTANCE: StudentDatabase? = null
        fun getInstance(context: Context): StudentDatabase {
            synchronized(this) {
                if (INSTANCE == null) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            StudentDatabase::class.java,
                            "student_database"
                        )
                            //默认是异步线程
                            //慎用：强制开启主线程操作数据库（测试用，真实环境不要用）
//                            .allowMainThreadQueries()
                            .build()
                }
                return INSTANCE!!
            }


        }
    }

}