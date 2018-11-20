package com.fiqih.matchschedulekotlin.presenter

import com.fiqih.matchschedulekotlin.api.APIRepository
import com.fiqih.matchschedulekotlin.api.TheSportsDBAPI
import com.fiqih.matchschedulekotlin.model.Teams
import com.fiqih.matchschedulekotlin.util.InterfaceTeam
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg


class TeamPresenter(
    private val view: InterfaceTeam,
    private val apiRepository: APIRepository,
    private val gson: Gson
) {

    fun geDetailTeamList(teamA: String?, teamB: String?) {
        view.isLoading()

        async(UI) {
            val dataA = bg {
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportsDBAPI.getTeam(teamA)),
                    Teams::class.java
                )
            }
            val dataB = bg {
                gson.fromJson(
                    apiRepository
                        .doRequest(TheSportsDBAPI.getTeam(teamB)),
                    Teams::class.java
                )
            }
            view.showTeam(dataA.await().teams, dataB.await().teams)
            view.stopLoading()
        }
    }
}