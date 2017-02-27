package net.milosvasic.logger

import kotlin.reflect.KClass

class CompositeLogger : CommonLogger() {

    private val loggers = mutableListOf<Logger>()

    fun addLogger(logger: Logger): Boolean {
        return loggers.add(logger)
    }

    fun removeLogger(logger: Logger): Boolean {
        return loggers.remove(logger)
    }

    override fun v(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.v(tag, message)
        }
    }

    override fun d(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.d(tag, message)
        }
    }

    override fun c(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.c(tag, message)
        }
    }

    override fun n(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.n(tag, message)
        }
    }

    override fun i(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.i(tag, message)
        }
    }

    override fun w(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.w(tag, message)
        }
    }

    override fun e(tag: KClass<*>, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.e(tag, message)
        }
    }

}
