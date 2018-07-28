package com.example.mma.mm_kunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobDurationVO {

    @SerializedName("jobEndDate")
    val jobEndDate: String = ""

    @SerializedName("jobStartDate")
    val jobStartDate: String = ""

    @SerializedName("totalWorkingDays")
    val totalWorkingDays: String = ""

    @SerializedName("workingDaysPerWeek")
    val workingDaysPerWeek: String = ""

    @SerializedName("workingHoursPerDay")
    val workingHoursPerDay: String = ""
}