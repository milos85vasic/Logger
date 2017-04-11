package net.milosvasic.logger

import java.text.SimpleDateFormat
import java.util.*

abstract class CommonLogger(val varinatsConfiguration: VariantsConfiguration? = null) : Logger {

    private val space = 12
    private val tagLength = 30
    private val dateFormat = SimpleDateFormat("HH:mm:ss:S")

    protected fun getLogLevel(level: LOG_LEVEL): String = getText(level.name, space)

    protected fun getDatetime(): String = getText(dateFormat.format(Date()), space - 1)

    protected fun getTag(tag: String): String {
        var tagValue = tag
        if (tagValue.length >= tagLength) {
            tagValue = "${tagValue.substring(0, tagLength - 2)}..."
        }
        return getText(tagValue, tagLength)
    }

    open protected fun getMessage(message: String, tag: String): String {
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

    protected fun getText(text: String, length: Int): String {
        val builder = StringBuilder()
        builder.append(text)
        for (x in 0..(length - text.length)) {
            builder.append(" ")
        }
        return builder.toString()
    }

    protected fun variantOk(): Boolean {
        if (varinatsConfiguration != null
                && varinatsConfiguration.supportedVariants != null
                && !varinatsConfiguration.supportedVariants.isEmpty()
                && varinatsConfiguration.currentModuleVariant != null
                && !varinatsConfiguration.currentModuleVariant.isEmpty()) {

            return varinatsConfiguration.supportedVariants.contains(
                    varinatsConfiguration.currentModuleVariant
            )
        }
        return true
    }

}