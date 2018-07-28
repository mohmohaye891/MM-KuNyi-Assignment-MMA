package com.example.mma.mm_kunyi.networks.responses

import com.example.mma.mm_kunyi.data.vos.JobsVO
import com.google.gson.annotations.SerializedName

class GetJobsResponse {

    @SerializedName("code")
    private val code: Int = 0

    @SerializedName("message")
    private val message: String? = null

    @SerializedName("apiVersion")
    private val apiVersion: String? = null

    @SerializedName("jobs")
    private var jobsList: List<JobsVO>? = null

    fun getCode() : Int {
        return code
    }

    fun getMessage() : String? {
        return  message
    }

    fun getApiVersion() : String? {
        return apiVersion
    }

    fun getJobsList() : List<JobsVO> {
        if (jobsList == null) {
            jobsList = ArrayList<JobsVO>()
        }
        val jobsListVal = jobsList
        return jobsListVal!!
    }
}