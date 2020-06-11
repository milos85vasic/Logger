package net.milosvasic.logger


class SimpleLogger(private val printStacktrace: Boolean = false) : CommonLogger() {

    private val output = System.out
    private val loggingPattern = "%s%s%s"

    @Synchronized
    override fun v(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.WHITE,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun d(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.YELLOW,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun c(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.GREEN,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun n(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.BLUE,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun i(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.CYAN,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun w(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.PURPLE,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun w(tag: String, exception: Exception) {

        val message = Logger.getMessage(exception, printStacktrace)
        output.println(
                String.format(
                        loggingPattern,
                        Color.PURPLE,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun e(tag: String, message: String) {

        output.println(
                String.format(
                        loggingPattern,
                        Color.RED,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun e(tag: String, exception: Exception) {

        val message = Logger.getMessage(exception, printStacktrace)
        output.println(
                String.format(
                        loggingPattern,
                        Color.RED,
                        getMessage(message),
                        Color.RESET
                )
        )
    }

    private fun getMessage(message: String): String {
        if (message.contains("\n")) {
            val builder = StringBuilder()
            val items = message.split("\n")
            items.forEachIndexed { i, item ->
                if (i > 0) {
                    builder.append("\n")
                }
                builder.append(item)
            }
            return builder.toString()
        }
        return message
    }

}