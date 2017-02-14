package net.milosvasic.logger

import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

class FilesystemLogger(val root: File = File(System.getProperty("user.dir"))) : CommonLogger() {

    var extension = "log"
    var structured = true
    private val calendar = GregorianCalendar()
    private val loggingPattern = "[ %s ][ %s ][ %s ] %s"
    private val filenameDateFormat = SimpleDateFormat("Y_M_d")

    @Synchronized
    override fun v(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.VERBOSE),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun d(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.DEBUG),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun c(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.CONFIRMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun n(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.NOTIFICATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun i(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.INFORMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun w(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.WARNING),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun e(tag: KClass<*>, message: String) {
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LOG_LEVEL.ERROR),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    private fun getDestination(): File {
        var home = root
        val date = Date()
        val filename = "${filenameDateFormat.format(date)}.$extension"
        if (structured) {
            val builder = StringBuilder(root.absolutePath)
            builder.append(File.separator)
            builder.append(calendar.get(Calendar.YEAR))
            builder.append(File.separator)
            builder.append(calendar.get(Calendar.MONTH))
            home = File(builder.toString())
            if (!home.exists()) {
                home.mkdirs()
            }
        }
        return File(home.absolutePath, filename)
    }

}