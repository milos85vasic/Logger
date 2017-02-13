package net.milosvasic.logger

import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

class FilesystemLogger(val root: File = File(System.getProperty("user.dir"))) : CommonLogger() {

    var extension = "log"
    var structured = true
    private val loggingPattern = "[ %s ][ %s ][ %s ] %s"
    private val filenameDateFormat = SimpleDateFormat("Y_M_d")

    override fun v(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.VERBOSE),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun d(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.DEBUG),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun c(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.CONFIRMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun n(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.NOTIFICATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun i(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.INFORMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun w(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.WARNING),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    override fun e(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.ERROR),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                )
        )
        getDestination().appendText("\n")
    }

    private fun getDestination(): File {
        var home = root
        val filename = "${filenameDateFormat.format(Date())}.$extension"
        if (structured) {
            // TODO: To be implemented.
        }
        return File(home.absolutePath, filename)
    }

}