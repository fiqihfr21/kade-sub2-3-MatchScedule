package com.fiqih.matchschedulekotlin.util

import com.fiqih.matchschedulekotlin.model.DetailMatch

interface InterfaceMatch {

    fun isLoading()
    fun stopLoading()
    fun showMatch(data : List<DetailMatch>?)
}