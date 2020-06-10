package net.milosvasic.tryout.logger

import net.milosvasic.logger.CompositeLogger
import net.milosvasic.logger.FilesystemLogger
import net.milosvasic.logger.SimpleLogger
import java.lang.Exception

fun main() {

    val tag = "[CompositeLogger]"

    val logger = CompositeLogger()
    val simple = SimpleLogger()
    val filesystem = FilesystemLogger(getHome())

    logger.addLogger(simple)
    logger.addLogger(filesystem)

    for (x in 0..10) {
        logger.v(tag, "Item [ $x ]")
    }

    val e = Exception("Trying out")
    logger.w(tag, e, SimpleLogger::class)
    logger.e(tag, e, SimpleLogger::class)
    logger.w(tag, e, FilesystemLogger::class)
    logger.e(tag, e, FilesystemLogger::class)
}