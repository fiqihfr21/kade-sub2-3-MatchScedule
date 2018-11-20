package com.fiqih.matchschedulekotlin.api

import java.net.URL

class APIRepository {
    fun doRequest(url: String): String {
        return URL(url).readText()
    }
}