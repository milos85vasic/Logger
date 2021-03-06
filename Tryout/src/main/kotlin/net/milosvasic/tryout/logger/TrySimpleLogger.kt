package net.milosvasic.tryout.logger

import net.milosvasic.logger.SimpleLogger

fun main() {

    val logger = SimpleLogger()
    val tag = "[SimpleLogger]"

    logger.v(tag, "This is verbose log.")
    logger.v(tag, "This is verbose log\nWith line 2\nWith line 3...")
    logger.w(tag, "This is warning log.")
    logger.c(tag, "This is confirmation log.")
}
