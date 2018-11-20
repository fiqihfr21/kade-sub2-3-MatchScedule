package com.fiqih.matchschedulekotlin.util

import kotlinx.coroutines.experimental.android.UI
import kotlin.coroutines.experimental.CoroutineContext

open class Context {
    open val main: CoroutineContext by lazy { UI }
}