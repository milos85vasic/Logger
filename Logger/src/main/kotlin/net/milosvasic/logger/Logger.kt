package net.milosvasic.logger

interface Logger {

    companion object {

        fun getMessage(e: Exception) = if (e.message == null) {
            "Exception without message has been caught: $e"
        } else {
            e.message as String
        }
    }

    fun v(tag: String, message: String)

    fun d(tag: String, message: String)

    fun c(tag: String, message: String)

    fun n(tag: String, message: String)

    fun i(tag: String, message: String)

    fun w(tag: String, message: String)

    fun e(tag: String, message: String)

    fun e(tag: String, exception: Exception)
}