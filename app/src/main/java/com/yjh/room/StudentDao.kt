package com.yjh.room

import androidx.room.*

//对表进行增删改查
@Dao
interface StudentDao {

    //增
    @Insert
    fun insertStudents(vararg student: Student)

    //改
    @Update
    fun updateStudents(vararg student: Student)

    //删 条件
    @Delete
    fun deleteStudents(vararg student: Student)

    //删 所有
    @Query("DELETE FROM Student")
    fun daleteAllStudents()

    //查 所有
    @Query("SELECT * FROM Student ORDER BY ID DESC")
    fun getAllStudents(): List<Student>
}