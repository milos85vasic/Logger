package net.milosvasic.logger

interface Logger {

    fun v(tag: String, message: String)

    fun d(tag: String, message: String)

    fun c(tag: String, message: String)

    fun n(tag: String, message: String)

    fun i(tag: String, message: String)

    fun w(tag: String, message: String)

    fun e(tag: String, message: String)

}