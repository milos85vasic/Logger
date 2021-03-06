package net.milosvasic.logger

interface Logger {

    companion object {

        fun getMessage(e: Exception, fullStackTrace: Boolean = false): String {

            var trace = ""
            e.message?.let {
                trace = "${e::class.simpleName}: $it"
            }
            if (fullStackTrace) {
                val stackTrace = e.stackTrace
                if (stackTrace.isNotEmpty()) {
                    trace += "\n"
                }
                stackTrace.forEachIndexed { index, element ->

                    trace += "${element.className}.${element.methodName}(${element.fileName}:${element.lineNumber})"
                    if (index != stackTrace.lastIndex) {
                        trace += "\n"
                    }
                }
            }
            return trace
        }
    }

    fun v(tag: String, message: String)

    fun d(tag: String, message: String)

    fun c(tag: String, message: String)

    fun n(tag: String, message: String)

    fun i(tag: String, message: String)

    fun w(tag: String, message: String)

    fun w(tag: String, exception: Exception)

    fun e(tag: String, message: String)

    fun e(tag: String, exception: Exception)
}