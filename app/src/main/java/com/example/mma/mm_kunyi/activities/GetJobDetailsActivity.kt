package com.example.mma.mm_kunyi.activities

import android.os.Bundle
import com.example.mma.mm_kunyi.R
import com.example.mma.mm_kunyi.data.models.GetJobAppModel
import com.example.mma.mm_kunyi.data.vos.JobsVO
import kotlinx.android.synthetic.main.activity_jobs_details.*

class GetJobDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs_details)

        val jobsId = intent.getStringExtra("jobId")

    }

    fun bindData(jobsVO: JobsVO) {
        tv_jobtitle_name.text = jobsVO.shortDesc
        tv_township_name.text = jobsVO.location
        tv_payment_name.text = jobsVO.offerAmount!!.amount
        tv_period_name.text = jobsVO.jobDuration!!.totalWorkingDays
        tv_period_name.text = jobsVO.jobPostId
        tv_desc_name.text = jobsVO.fullDesc
    }
}