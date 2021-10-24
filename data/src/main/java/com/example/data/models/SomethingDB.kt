package com.example.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*

@Entity(tableName = "something_table")
data class SomethingDB(
    @PrimaryKey var uuid: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "sm_title") var title: String,
    @ColumnInfo(name = "sm_subtitle") var subtitle: String
): Serializable
