package net.milosvasic.logger

import kotlin.reflect.KClass

class SimpleLogger : CommonLogger() {

    private val output = System.out
    private val loggingPattern = "%s%s%s"

    @Synchronized
    override fun v(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_WHITE,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun d(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_YELLOW,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun c(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_GREEN,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun n(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_BLUE,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun i(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_CYAN,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun w(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_PURPLE,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    @Synchronized
    override fun e(tag: KClass<*>, message: String) {
        output.println(
                String.format(
                        loggingPattern,
                        LogColor.ANSI_RED,
                        getMessage(message),
                        LogColor.ANSI_RESET
                )
        )
    }

    private fun getMessage(message: String): String {
        if (message.contains("\n")) {
            val builder = StringBuilder()
            val items = message.split("\n")
            items.forEachIndexed { i, item ->
                if (i > 0) {
                    builder.append("\n\t")
                }
                builder.append(item)
            }
            return builder.toString()
        }
        return message
    }

}