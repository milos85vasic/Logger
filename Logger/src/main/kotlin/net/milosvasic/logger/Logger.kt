package net.milosvasic.logger

import kotlin.reflect.KClass


interface Logger {

    fun v(tag: KClass<*>, message: String)

    fun d(tag: KClass<*>, message: String)

    fun c(tag: KClass<*>, message: String)

    fun n(tag: KClass<*>, message: String)

    fun i(tag: KClass<*>, message: String)

    fun w(tag: KClass<*>, message: String)

    fun e(tag: KClass<*>, message: String)

}