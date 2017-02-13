package net.milosvasic.logger

import kotlin.reflect.KClass

class ConsoleLogger : CommonLogger() {

    private val output = System.out
    private val loggingPattern = "%s[ %s ][ %s ][ %s ] %s%s"

    override fun v(tag: KClass<*>, message: String) {
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

    override fun d(tag: KClass<*>, message: String) {
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

    override fun c(tag: KClass<*>, message: String) {
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

    override fun n(tag: KClass<*>, message: String) {
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

    override fun i(tag: KClass<*>, message: String) {
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

    override fun w(tag: KClass<*>, message: String) {
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

    override fun e(tag: KClass<*>, message: String) {
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

    private object LogColor {
        val ANSI_RESET = "\u001B[0m"
        val ANSI_RED = "\u001B[31m"
        val ANSI_GREEN = "\u001B[32m"
        val ANSI_YELLOW = "\u001B[33m"
        val ANSI_BLUE = "\u001B[34m"
        val ANSI_PURPLE = "\u001B[35m"
        val ANSI_CYAN = "\u001B[36m"
        val ANSI_WHITE = "\u001B[37m"
    }

}
