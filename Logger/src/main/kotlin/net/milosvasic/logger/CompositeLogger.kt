package net.milosvasic.logger

class CompositeLogger : CommonLogger() {

    private val loggers = mutableListOf<Logger>()

    fun addLogger(logger: Logger): Boolean {
        return loggers.add(logger)
    }

    fun removeLogger(logger: Logger): Boolean {
        return loggers.remove(logger)
    }

    override fun v(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.v(tag, message)
        }
    }

    override fun d(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.d(tag, message)
        }
    }

    override fun c(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.c(tag, message)
        }
    }

    override fun n(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.n(tag, message)
        }
    }

    override fun i(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.i(tag, message)
        }
    }

    override fun w(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.w(tag, message)
        }
    }

    override fun e(tag: String, message: String) {
        loggers.forEachIndexed { i, logger ->
            logger.e(tag, message)
        }
    }

}
