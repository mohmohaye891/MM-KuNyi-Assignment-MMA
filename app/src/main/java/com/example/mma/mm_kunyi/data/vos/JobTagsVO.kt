package com.example.mma.mm_kunyi.data.vos

import com.google.gson.annotations.SerializedName

class JobTagsVO {

    @SerializedName("desc")
    var desc: String = ""

    @SerializedName("jobCountWithTag")
    var jobCountWithTag: String = ""

    @SerializedName("tag")
    var tag: String = ""

    @SerializedName("tagId")
    var tagId: String = ""
}