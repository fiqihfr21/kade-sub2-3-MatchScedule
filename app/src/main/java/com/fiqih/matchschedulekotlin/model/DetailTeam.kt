package com.fiqih.matchschedulekotlin.model

import com.google.gson.annotations.SerializedName

data class DetailTeam(

    @SerializedName("strTeamBadge")
    var strTeamBadge: String? = null,

    @SerializedName("idTeam")
    var teamId: String? = null,

    @SerializedName("strTeam")
    var teamName: String? = null,

    @SerializedName("intFormedYear")
    var teamFormedYear: String? = null,

    @SerializedName("strStadium")
    var teamStadium: String? = null,

    @SerializedName("strDescriptionEN")
    var teamDescription: String? = null
)
