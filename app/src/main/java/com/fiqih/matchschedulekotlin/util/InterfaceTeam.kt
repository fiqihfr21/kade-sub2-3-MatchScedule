package com.fiqih.matchschedulekotlin.util

import com.fiqih.matchschedulekotlin.model.DetailTeam

interface InterfaceTeam {

    fun isLoading()
    fun stopLoading()
    fun showTeam(data : List<DetailTeam>?, dataB : List<DetailTeam>?)
}