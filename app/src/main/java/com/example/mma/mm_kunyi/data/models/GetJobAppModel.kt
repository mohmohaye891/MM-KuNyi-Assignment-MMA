package com.example.mma.mm_kunyi.data.models

import com.example.mma.mm_kunyi.data.vos.JobsVO
import com.example.mma.mm_kunyi.events.DataEvent
import com.example.mma.mm_kunyi.networks.JobsDataAgent
import com.example.mma.mm_kunyi.utils.AppConstants
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class GetJobAppModel {

    companion object {
        private var INSTANCE: GetJobAppModel? = null
        fun getInstance(): GetJobAppModel {
            if (INSTANCE == null) {
                INSTANCE = GetJobAppModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)
    }

    private var mJobData: HashMap<String, JobsVO> = HashMap()

    fun loadJob() {
        JobsDataAgent.getInstance().loadJobs(AppConstants.ACCESS_TOKEN)
    }

    fun forceLoadJob() {
        mJobData = HashMap()
        JobsDataAgent.getInstance().loadJobs(AppConstants.ACCESS_TOKEN)
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onJobsLoadedEvent(jobsLoadedEvent: DataEvent.JobsLoadedEvent) {
        for (jobs: JobsVO in jobsLoadedEvent.loadedJobs) {
            mJobData[jobs.jobPostId] = jobs
        }
    }
}