package net.milosvasic.tryout.logger

import java.io.File

fun getHome(): File {

    val home = System.getProperty("user.home")
    val root = File("$home${File.separator}Logger_Logs")
    if (!root.exists()) {
        root.mkdirs()
    }
    return root
}
