package com.fiqih.matchschedulekotlin.presenter

import com.fiqih.matchschedulekotlin.api.APIRepository
import com.fiqih.matchschedulekotlin.api.TheSportsDBAPI
import com.fiqih.matchschedulekotlin.model.Matchs
import com.fiqih.matchschedulekotlin.util.InterfaceMatch
import com.google.gson.Gson
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MatchPresenter(
    private val view: InterfaceMatch,
    private val apiRepository: APIRepository,
    private val gson: Gson
) {

    fun getMatchList(isNext: Boolean?) {
        view.isLoading()
        if (!isNext!!) {
            async(UI) {
                val data = bg {
                    gson.fromJson(
                        apiRepository
                            .doRequest(TheSportsDBAPI.getLastMatch()),
                        Matchs::class.java
                    )
                }
                view.showMatch(data.await().events)
                view.stopLoading()
            }
        }

        else{
            async(UI) {
                val data = bg {
                    gson.fromJson(
                        apiRepository
                            .doRequest(TheSportsDBAPI.getNextMatch()),
                        Matchs::class.java
                    )
                }
                view.showMatch(data.await().events)
                view.stopLoading()
            }
        }
    }
}