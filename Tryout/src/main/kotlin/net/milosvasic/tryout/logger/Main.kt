package net.milosvasic.tryout.logger

import net.milosvasic.logger.ConsoleLogger
import net.milosvasic.logger.FilesystemLogger
import net.milosvasic.logger.VariantsConfiguration
import java.io.File

fun main(args: Array<String>) {
    val tag = "[main]"
    val logger = ConsoleLogger(VariantsConfiguration(BuildConfig.VARIANT, listOf("DEV", "STAGING")))
    val loggerFs = FilesystemLogger(VariantsConfiguration(BuildConfig.VARIANT, listOf("DEV", "STAGING")))

    logger.v(tag, "This is a simple verbose log.")
    logger.d(tag, "This is a simple debug log.")
    logger.c(tag, "This is a confirmation.")
    logger.n(tag, "This is a notification.")
    logger.i(tag, "This is a simple info log.")
    logger.w(tag, "This is a simple warning log.")
    logger.e(tag, "This is a simple error log.")
    logger.v(tag, "Multiline log:\nThis is a simple multiline log.\nThis is a simple multiline log.")
    logger.n(tag, "This class has a long name.")
    logger.e(tag, "Error occurred:\nError line 1\nError line 2\nError line 3\nLooooooong error line")
    logger.c(tag, "New data.")
    logger.n(tag, "And more data...")
    logger.n(tag, "And even more data...")
    logger.e(tag, "Multiline log:\nThis is a simple multiline log.\nThis is a simple multiline log.")
    logger.d(tag, "This is a simple debug log.")
    logger.c(tag, "This is a confirmation.")

    for (x in 0..100) {
        loggerFs.v(tag, "Verbose [ $x ]")
        loggerFs.i(tag, "Info [ $x ]")
        loggerFs.w(tag, "Warning [ $x ]")
        loggerFs.c(tag, "- - - - - - - - - - - - -")
    }

    for(x in 0..10){
        Thread(Runnable {
            loggerFs.e(tag, "Appending $x")
        }).start()
    }
}
