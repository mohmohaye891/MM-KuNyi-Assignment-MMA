package com.example.mma.mm_kunyi.events

import com.example.mma.mm_kunyi.data.vos.JobsVO

class DataEvent {

    class JobsLoadedEvent( val loadedJobs: List<JobsVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")
}