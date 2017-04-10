package net.milosvasic.logger


class SimpleLogger(variants: List<String>? = null) : CommonLogger(variants) {

    private val output = System.out
    private val loggingPattern = "%s%s%s"

    @Synchronized
    override fun v(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_WHITE,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun d(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_YELLOW,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun c(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_GREEN,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun n(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_BLUE,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun i(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_CYAN,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun w(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_PURPLE,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
    }

    @Synchronized
    override fun e(tag: String, message: String) {
        if (variantOk()) {
            output.println(
                    String.format(
                            loggingPattern,
                            LogColor.ANSI_RED,
                            getMessage(message),
                            LogColor.ANSI_RESET
                    )
            )
        }
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