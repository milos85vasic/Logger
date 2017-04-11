package net.milosvasic.logger

class ConsoleLogger(variantsConfiguration: VariantsConfiguration? = null) : CommonLogger(variantsConfiguration) {

    private val output = System.out
    private val loggingPattern = "%s[ %s ][ %s ][ %s ] %s%s"

    @Synchronized
    override fun v(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_WHITE,
                            getLogLevel(LOG_LEVEL.VERBOSE),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun d(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_YELLOW,
                            getLogLevel(LOG_LEVEL.DEBUG),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun c(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_GREEN,
                            getLogLevel(LOG_LEVEL.CONFIRMATION),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun n(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_BLUE,
                            getLogLevel(LOG_LEVEL.NOTIFICATION),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun i(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_CYAN,
                            getLogLevel(LOG_LEVEL.INFORMATION),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun w(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_PURPLE,
                            getLogLevel(LOG_LEVEL.WARNING),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun e(tag: String, message: String) {
        if (variantOk()) {
            val tagValue = getTag(tag)
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_RED,
                            getLogLevel(LOG_LEVEL.ERROR),
                            getDatetime(),
                            tagValue,
                            getMessage(message, tagValue),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

}
