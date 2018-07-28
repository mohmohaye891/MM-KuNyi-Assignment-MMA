package com.example.mma.mm_kunyi.data.vos

import com.google.gson.annotations.SerializedName

class InterestedVO(interestedTimeStamp: String = "",
                   seekerId: String = "",
                   seekerName: String = "",
                   seekerProfilePicUrl: String = "",
                   seekerSkill: List<SeekerSkillVO> = ArrayList()
                  ) {

    @SerializedName("interestedTimeStamp")
    val interestedTimeStamp: String = interestedTimeStamp

    @SerializedName("seekerId")
    val seekerId: String = seekerId

    @SerializedName("seekerName")
    val seekerName: String = seekerName

    @SerializedName("seekerProfilePicUrl")
    val seekerProfilePicUrl: String = seekerProfilePicUrl

    @SerializedName("seekerSkill")
    var seekerSkill: List<SeekerSkillVO>? = seekerSkill
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }
}