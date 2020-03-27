package net.milosvasic.logger

class CompositeLogger : CommonLogger() {

    private val loggers = mutableListOf<Logger>()

    fun addLogger(logger: Logger): Boolean {
        return loggers.add(logger)
    }

    fun addLoggers(vararg loggersToAdd: Logger): Boolean {
        return loggers.addAll(loggersToAdd)
    }

    fun removeLogger(logger: Logger): Boolean {
        return loggers.remove(logger)
    }

    override fun v(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.v(tag, message)
        }
    }

    override fun d(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.d(tag, message)
        }
    }

    override fun c(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.c(tag, message)
        }
    }

    override fun n(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.n(tag, message)
        }
    }

    override fun i(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.i(tag, message)
        }
    }

    override fun w(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.w(tag, message)
        }
    }

    override fun e(tag: String, message: String) {
        loggers.forEach { logger ->
            logger.e(tag, message)
        }
    }
}
