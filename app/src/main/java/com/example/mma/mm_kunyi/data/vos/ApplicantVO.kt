package com.example.mma.mm_kunyi.data.vos

import com.google.gson.annotations.SerializedName

class ApplicantVO(appliedDate: String = "",
                  canLowerOfferAmount: String = "",
                  seekerId: String = "",
                  seekerName: String = "",
                  seekerProfilePicUrl: String = "",
                  seekerSkill: List<SeekerSkillVO> = ArrayList(),
                  whyShouldHire: List<WhyShouldHireVO> = ArrayList()) {

    @SerializedName("appliedDate")
    val appliedDate: String = ""

    @SerializedName("canLowerOfferAmount")
    val canLowerOfferAmount: String = ""

    @SerializedName("seekerId")
    val seekerId: String = ""

    @SerializedName("seekerName")
    val seekerName: String = ""

    @SerializedName("seekerProfilePicUrl")
    val seekerProfilePicUrl: String = ""

    @SerializedName("seekerSkill")
    var seekerSkill : List<SeekerSkillVO>? = seekerSkill
    get() {
        return if (field == null)
            ArrayList()
        else
            field
    }

    @SerializedName("whyShouldHire")
    var whyShouldHire: List<WhyShouldHireVO>? = whyShouldHire
    get() {
        return if (field == null)
            ArrayList()
        else
            field
    }
}