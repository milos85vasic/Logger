package net.milosvasic.`try`.logger

import net.milosvasic.logger.ConsoleLogger
import net.milosvasic.logger.FilesystemLogger

// val logger = ConsoleLogger()
val logger = FilesystemLogger()

private class TryMeNow

private class TryClassWithVeryVeryVeryVeryVeryVeryLongNameNow

private class Other

fun main(args: Array<String>) {
    logger.v(TryMeNow::class, "This is a simple verbose log.")
    logger.d(TryMeNow::class, "This is a simple debug log.")
    logger.c(TryMeNow::class, "This is a confirmation.")
    logger.n(TryMeNow::class, "This is a notification.")
    logger.i(TryMeNow::class, "This is a simple info log.")
    logger.w(TryMeNow::class, "This is a simple warning log.")
    logger.e(TryMeNow::class, "This is a simple error log.")
    logger.v(TryMeNow::class, "Multiline log:\nThis is a simple multiline log.\nThis is a simple multiline log.")
    logger.n(TryClassWithVeryVeryVeryVeryVeryVeryLongNameNow::class, "This class has a long name.")
    logger.e(TryClassWithVeryVeryVeryVeryVeryVeryLongNameNow::class, "Error occurred:\nError line 1\nError line 2\nError line 3\nLooooooong error line")
    logger.c(TryMeNow::class, "New data.")
    logger.n(TryMeNow::class, "And more data...")
    logger.n(TryClassWithVeryVeryVeryVeryVeryVeryLongNameNow::class, "And even more data...")
    logger.e(TryMeNow::class, "Multiline log:\nThis is a simple multiline log.\nThis is a simple multiline log.")
    logger.d(Other::class, "This is a simple debug log.")
    logger.c(Other::class, "This is a confirmation.")
}
