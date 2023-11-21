package net.milosvasic.logger

import java.io.File
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.GregorianCalendar
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger

class FilesystemLogger(private val root: File = File(System.getProperty("user.dir"))) : CommonLogger() {

    private var extension = "log"
    private var filenameSuffix = ""
    private val calendar = GregorianCalendar()
    private var structured = AtomicBoolean(true)
    private val loggingPattern = "[ %s ][ %s ][ %s ] %s"
    private var maxFileSize = AtomicInteger(3)
    private val filenameDateFormat = SimpleDateFormat("Y_M_d")

    @Synchronized
    override fun v(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.VERBOSE),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun d(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.DEBUG),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun c(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.CONFIRMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun n(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.NOTIFICATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun i(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.INFORMATION),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun w(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.WARNING),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun w(tag: String, exception: Exception) {

        val message = Logger.getMessage(exception, true)
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.WARNING),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun e(tag: String, message: String) {

        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.ERROR),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    @Synchronized
    override fun e(tag: String, exception: Exception) {

        val message = Logger.getMessage(exception, true)
        val tagValue = getTag(tag)
        getDestination().appendText(
                String.format(
                        loggingPattern,
                        getLogLevel(LEVEL.ERROR),
                        getDatetime(),
                        tagValue,
                        getMessage(message, tagValue)
                ) + "\n"
        )
    }

    fun isStructured(): Boolean {
        return structured.get()
    }

    fun setStructured(structured: Boolean) {
        this.structured.set(structured)
    }

    fun getMaxLogFileSizeInMegabytes(): Int {
        return maxFileSize.get()
    }

    fun setMaxLogFileSizeInMegabytes(size: Int) {
        maxFileSize.set(size)
    }

    fun getLogFileExtension(): String {
        return extension
    }

    @Synchronized
    fun setLogFileExtension(extension: String) {
        this.extension = extension
    }

    fun getFilenameSuffix() = filenameSuffix

    fun setFilenameSuffix(suffix: String) {

        filenameSuffix = suffix
    }

    private fun getDestination(): File {

        var home = root
        val date = Date()
        if (structured.get()) {
            val builder = StringBuilder(root.absolutePath)
            builder.append(File.separator)
            builder.append("Logs")
            builder.append(File.separator)
            builder.append(calendar.get(Calendar.YEAR))
            builder.append(File.separator)
            builder.append(calendar.get(Calendar.MONTH) + 1)
            home = File(builder.toString())
            if (!home.exists()) {
                home.mkdirs()
            }
        }
        var suffix = 0
        var filename = getFilename(date, suffix)
        var file = File(home.absolutePath, filename)
        while (file.exists() && file.length() / 1024 / 1024 > maxFileSize.get()) {
            suffix++
            filename = getFilename(date, suffix)
            file = File(home.absolutePath, filename)
        }
        return file
    }

    private fun getFilename(date: Date, suffix: Int) =
            "${filenameDateFormat.format(date)}_$filenameSuffix$suffix.$extension"
}