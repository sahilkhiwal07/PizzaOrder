package com.example.bookmovie.data.Model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity
@Parcelize
data class PizzaItem(
    val Crust: String,
    val Flavor: String,
    @PrimaryKey
    val Order_ID: Int,
    val Size: String,
    val Table_No: Int,
    val Timestamp: String
) :Parcelable