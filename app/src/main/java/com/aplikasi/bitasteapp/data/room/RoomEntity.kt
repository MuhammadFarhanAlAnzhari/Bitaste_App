package com.aplikasi.bitasteapp.data.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "food")
data class RoomEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int,
    var namaFood: String,
    var poto:Int,
    var harga:String,
    var stock:Int
): Serializable