package net.milosvasic.tryout.logger

import net.milosvasic.logger.ConsoleLogger
import net.milosvasic.logger.FilesystemLogger

fun main() {

    val tag = "[main]"
    val logger = ConsoleLogger()
    val loggerFs = FilesystemLogger()

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

    for (suffix in 0..5){
        if (suffix > 0) {

            loggerFs.setFilenameSuffix("sfx$suffix")
        }
        for (x in 0..100) {

            loggerFs.v(tag, "Verbose [ $x ]")
            loggerFs.i(tag, "Info [ $x ]")
            loggerFs.w(tag, "Warning [ $x ]")
            loggerFs.c(tag, "- - - - - - - - - - - - -")
        }
    }

    for (x in 0..10) {
        Thread {

            loggerFs.e(tag, "Appending $x")
        }.start()
    }
}
