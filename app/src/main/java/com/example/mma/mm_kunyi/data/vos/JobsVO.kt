package com.example.mma.mm_kunyi.data.vos

import com.google.gson.annotations.SerializedName

open class JobsVO(applicant: List<ApplicantVO> = ArrayList(),
                  availablePostCount: String = "",
                  email: String = "",
                  fullDesc: String = "",
                  genderForJob: String = "",
                  images: List<String> = ArrayList(),
                  importantNotes: List<String> = ArrayList(),
                  interested: List<InterestedVO> = ArrayList(),
                  isActive: String = "",
                  jobDuration: JobDurationVO? = null,
                  jobPostId: String = "",
                  jobTags: List<JobTagsVO>? = ArrayList(),
                  location: String = "",
                  makeMoneyRating: String = "",
                  offerAmount: OfferAmountVO? = null,
                  phoneNo: String = "",
                  postClosedDate: String = "",
                  postedDate: String = "",
                  relevant: List<RelevantVO>? = ArrayList(),
                  requiredSkill: List<RequiredSkillVO>? = ArrayList(),
                  shortDesc: String = "",
                  viewed: List<ViewedVO>? = ArrayList())  {

    @SerializedName("applicant")
    var applicant: List<ApplicantVO>? = applicant
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("availablePostCount")
    val availablePostCount: String = availablePostCount

    @SerializedName("email")
    val email: String = email

    @SerializedName("fullDesc")
    var fullDesc: String = fullDesc

    @SerializedName("genderForJob")
    val genderForJob: String = genderForJob

    @SerializedName("images")
    var images: List<String>? = images
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("importantNotes")
    var importantNotes: List<String>? = importantNotes
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("interested")
    var interested: List<InterestedVO>? = interested
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("isActive")
    val isActive: String = isActive

    @SerializedName("jobDuration")
    var jobDuration: JobDurationVO? = jobDuration

    @SerializedName("jobPostId")
    val jobPostId: String = jobPostId

    @SerializedName("jobTags")
    var jobTags: List<JobTagsVO>? = jobTags
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("location")
    val location: String = location

    @SerializedName("makeMoneyRating")
    val makeMoneyRating: String = makeMoneyRating

    @SerializedName("offerAmount")
    var offerAmount: OfferAmountVO? = offerAmount

    @SerializedName("phoneNo")
    val phoneNo: String = phoneNo

    @SerializedName("postClosedDate")
    val postClosedDate: String = postClosedDate

    @SerializedName("postedDate")
    val postedDate: String = postedDate

    @SerializedName("relevant")
    var relevant: List<RelevantVO>? = relevant
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("requiredSkill")
    var requiredSkill: List<RequiredSkillVO>? = requiredSkill
        get() {
            return if (field == null)
                ArrayList()
            else
                field
        }

    @SerializedName("shortDesc")
    val shortDesc: String = shortDesc

    @SerializedName("viewed")
    var viewed: List<ViewedVO>? = viewed
    get() {
        return if (field == null)
            ArrayList()
        else
            field
    }
}