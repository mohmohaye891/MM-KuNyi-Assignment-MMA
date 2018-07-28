package com.example.mma.mm_kunyi.networks


import com.example.mma.mm_kunyi.networks.responses.GetJobsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface JobsApi {

    @FormUrlEncoded
    @POST("one-time-jobs/getJobs.php")
    fun loadMMJobs(
            @Field("access_token") accessToken: String) : Call<GetJobsResponse>
}