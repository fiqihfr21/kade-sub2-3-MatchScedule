package com.fiqih.matchschedulekotlin.model

import com.google.gson.annotations.SerializedName

data class Matchs (
    @SerializedName("events")
    val events: List<DetailMatch>? = null,

    @SerializedName("event")
    val event: List<DetailMatch>? = null,

    @SerializedName("teams")
    val teams: List<DetailTeam>? = null
)