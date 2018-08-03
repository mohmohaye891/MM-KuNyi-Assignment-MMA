package com.example.mma.mm_kunyi.adapters

import android.content.Context
import android.view.ViewGroup
import com.example.mma.mm_kunyi.R
import com.example.mma.mm_kunyi.data.vos.JobsVO
import com.example.mma.mm_kunyi.delegates.GetJobDelegate
import com.example.mma.mm_kunyi.view.holders.GetJobsViewHolder

class GetJobAdapter(context: Context,
                    private val mGetJobDelegate: GetJobDelegate) : BaseRecyclerAdapter<GetJobsViewHolder<Any?>, JobsVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GetJobsViewHolder<JobsVO> {
        val jobsItemView = mLayoutInflater.inflate(R.layout.view_item_job_list, parent, false)
        return GetJobsViewHolder(jobsItemView, mGetJobDelegate)
    }
}