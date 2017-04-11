package net.milosvasic.tryout.logger

import net.milosvasic.logger.CompositeLogger
import net.milosvasic.logger.FilesystemLogger
import net.milosvasic.logger.SimpleLogger
import net.milosvasic.logger.VariantsConfiguration

fun main(args: Array<String>) {

    val tag = "[CompositeLogger]"

    val logger = CompositeLogger()
    val simple = SimpleLogger()
    val filesystem = FilesystemLogger(VariantsConfiguration(BuildConfig.VARIANT, listOf("DEV")), getHome())

    logger.addLogger(simple)
    logger.addLogger(filesystem)

    for(x in 0..10){
        logger.v(tag, "Item [ $x ]")
    }

}