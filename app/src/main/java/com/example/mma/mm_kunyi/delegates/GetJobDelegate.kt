package com.example.mma.mm_kunyi.delegates

import com.example.mma.mm_kunyi.data.vos.JobsVO

interface GetJobDelegate {

    fun onTapJobList(jobList: JobsVO?)
    fun onTapApply()
    fun onTapSave()
}