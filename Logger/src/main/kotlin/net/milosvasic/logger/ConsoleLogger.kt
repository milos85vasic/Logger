package net.milosvasic.logger

class ConsoleLogger : CommonLogger() {

    private val output = System.out
    private val loggingPattern = "%s[ %s ][ %s ][ %s ] %s%s"

    @Synchronized
    override fun v(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.WHITE,
                        getLogLevel(LEVEL.VERBOSE),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun d(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.YELLOW,
                        getLogLevel(LEVEL.DEBUG),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun c(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.GREEN,
                        getLogLevel(LEVEL.CONFIRMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun n(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.BLUE,
                        getLogLevel(LEVEL.NOTIFICATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun i(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.CYAN,
                        getLogLevel(LEVEL.INFORMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun w(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.PURPLE,
                        getLogLevel(LEVEL.WARNING),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }

    @Synchronized
    override fun e(tag: String, message: String) {

        val tagValue = getTag(tag)
        output.println(
                String.format(
                        loggingPattern,
                        Color.RED,
                        getLogLevel(LEVEL.ERROR),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue),
                        Color.RESET
                )
        )
    }
}
