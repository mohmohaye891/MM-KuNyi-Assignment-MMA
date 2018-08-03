package com.example.mma.mm_kunyi.activities

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import com.example.mma.mm_kunyi.R
import com.example.mma.mm_kunyi.adapters.GetJobAdapter
import com.example.mma.mm_kunyi.component.SmartScrollListener
import com.example.mma.mm_kunyi.data.models.GetJobAppModel
import com.example.mma.mm_kunyi.data.vos.JobsVO
import com.example.mma.mm_kunyi.delegates.GetJobDelegate
import com.example.mma.mm_kunyi.events.DataEvent
import com.example.mma.mm_kunyi.events.ErrorEvent
import kotlinx.android.synthetic.main.activity_jobs_list.*
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class GetJobListActivity : BaseActivity(), GetJobDelegate{

    private var mJobAdapter: GetJobAdapter? = null
    private var mSmartScrollListener: SmartScrollListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jobs_list)
        //setSupportActionBar(toolbar)

       // supportActionBar!!.setDisplayShowTitleEnabled(false)

        var jobLists: JobsVO = JobsVO()
        jobLists.fullDesc = "full Description"

        rvJobs.setEmptyView(vpEmptyJob)
        rvJobs.layoutManager = LinearLayoutManager(applicationContext)

        mSmartScrollListener = SmartScrollListener(object : SmartScrollListener.OnSmartScrollListener {
            override fun onListEndReach() {
                Snackbar.make(rvJobs, "Loading more data.", Snackbar.LENGTH_LONG).show()
                swipeRefreshLayout.isRefreshing = true
                GetJobAppModel.getInstance().loadJob()
            }
        })

        rvJobs.addOnScrollListener(mSmartScrollListener)

        mJobAdapter = GetJobAdapter(applicationContext, this)
        rvJobs.adapter = mJobAdapter

        swipeRefreshLayout.isRefreshing = true
        GetJobAppModel.getInstance().loadJob()

        swipeRefreshLayout.setOnRefreshListener {
            val jobsAdapterVal = mJobAdapter
            GetJobAppModel.getInstance().forceLoadJob()
        }
    }

    override fun onTapJobList(jobList: JobsVO?) {
       val intent = Intent(applicationContext, GetJobDetailsActivity::class.java)
        startActivity(intent)
    }

    override fun onTapApply() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTapSave() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onJobsLoadedEvent(jobsLoadedEvent: DataEvent.JobsLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        mJobAdapter!!.appendJobListsData(jobsLoadedEvent.loadedJobs as MutableList<JobsVO>)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onErrorLoadedEvent(apiErrorEvent: ErrorEvent.ApiErrorEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvJobs, "ERROR : " + apiErrorEvent.getMsg(), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEmptyLoadedLayout(emptyDataLoadedEvent: DataEvent.EmptyDataLoadedEvent) {
        swipeRefreshLayout.isRefreshing = false
        Snackbar.make(rvJobs, "ERROR:" + emptyDataLoadedEvent.errorMsg, Snackbar.LENGTH_LONG)
                .setAction("Action",null).show()
    }

}