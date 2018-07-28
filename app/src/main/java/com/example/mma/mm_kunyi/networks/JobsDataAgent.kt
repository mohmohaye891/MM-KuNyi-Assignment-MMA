package com.example.mma.mm_kunyi.networks

import com.example.mma.mm_kunyi.events.DataEvent
import com.example.mma.mm_kunyi.events.ErrorEvent
import com.example.mma.mm_kunyi.networks.responses.GetJobsResponse
import com.google.gson.Gson
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class JobsDataAgent {

    companion object {
        private var INSTANCE: JobsDataAgent? = null
        fun getInstance(): JobsDataAgent {
            if (INSTANCE == null) {
                INSTANCE = JobsDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mJobsApi: JobsApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/final-projects/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mJobsApi = retrofit.create(JobsApi::class.java)
    }

    fun loadJobs(accessToken: String, page: Int) {
        val jobsResponseCall = mJobsApi.loadMMJobs(accessToken)
        jobsResponseCall.enqueue(object  : Callback<GetJobsResponse> {
            override fun onFailure(call: Call<GetJobsResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetJobsResponse>, response: Response<GetJobsResponse>) {
                val jobsResponse: GetJobsResponse? = response.body()
                if (jobsResponse != null
                        && jobsResponse.getCode() == 200
                        && jobsResponse.getJobsList().isNotEmpty()) {
                    val jobsLoadedEvent = DataEvent.JobsLoadedEvent(jobsResponse.getJobsList())
                    EventBus.getDefault().post(jobsLoadedEvent)
                }else {
                    if (jobsResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(jobsResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }

        } )
    }
}