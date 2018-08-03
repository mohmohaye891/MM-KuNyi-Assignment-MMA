package com.example.mma.mm_kunyi.view.holders

import android.view.View
import com.example.mma.mm_kunyi.data.vos.JobsVO
import com.example.mma.mm_kunyi.delegates.GetJobDelegate
import kotlinx.android.synthetic.main.view_item_job_list.view.*

class GetJobsViewHolder<T>(itemView: View, private val mDelegate: GetJobDelegate) : BaseViewHolder<JobsVO>(itemView){

    override fun setData(data: JobsVO) {
        mData = data

        itemView.tv_jotitle!!.text = data.shortDesc
        itemView.tv_job_desc!!.text = data.fullDesc
        itemView.tv_amount!!.text = data.offerAmount!!.amount
    }

    override fun onClick(v: View?) {
       mDelegate.onTapJobList(mData)
    }


}