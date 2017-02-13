package net.milosvasic.logger

import java.io.File
import kotlin.reflect.KClass

class FilesystemLogger(val root: File = File(System.getProperty("user.dir"))) : Logger {

    override fun v(tag: KClass<*>, message: String) {
        
    }

    override fun d(tag: KClass<*>, message: String) {

    }

    override fun c(tag: KClass<*>, message: String) {

    }

    override fun n(tag: KClass<*>, message: String) {

    }

    override fun i(tag: KClass<*>, message: String) {

    }

    override fun w(tag: KClass<*>, message: String) {

    }

    override fun e(tag: KClass<*>, message: String) {

    }

}