package com.yjh.room

import androidx.room.Entity
import androidx.room.PrimaryKey

//一张表
@Entity
data class Student (val name: String?, val age: Int?){

    //主键唯一 主键自动增长
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}