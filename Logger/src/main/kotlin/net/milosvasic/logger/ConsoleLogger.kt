package net.milosvasic.logger


import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

class ConsoleLogger : Logger {

    private val space = 12
    private val tagLength = 30
    private val output = System.out
    private val dateFormat = SimpleDateFormat("HH:mm:ss:S")
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

    private fun getLogLevel(level: LOG_LEVEL): String = getText(level.name, space)

    private fun getDatetime(): String = getText(dateFormat.format(Date()), space - 1)

    private fun getTag(tag: KClass<*>): String {
        var tagValue = "${tag.simpleName}"
        if (tagValue.length >= tagLength) {
            tagValue = "${tagValue.substring(0, tagLength - 2)}..."
        }
        return getText(tagValue, tagLength)
    }

    private fun getMessage(message: String, tag: String): String {
        if (message.contains("\n")) {
            val builder = StringBuilder()
            val items = message.split("\n")
            items.forEachIndexed { i, item ->
                if (i > 0) {
                    builder.append("\n")
                    val spaces = (space * 3) + tag.length + 1
                    for (x in 0..spaces) {
                        builder.append(" ")
                    }
                }
                builder.append(item)
            }
            return builder.toString()
        }
        return message
    }

    private fun getText(text: String, length: Int): String {
        val builder = StringBuilder()
        builder.append(text)
        for (x in 0..(length - text.length)) {
            builder.append(" ")
        }
        return builder.toString()
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
