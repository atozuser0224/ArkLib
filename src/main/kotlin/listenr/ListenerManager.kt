package org.gang.listenr

import org.bukkit.event.Listener
import org.bukkit.plugin.Plugin

object ListenerManager {
    val list : List<Listener> = listOf(
        InvListenr()
    )

    fun register(plugin: Plugin){
        list.forEach {
            plugin.server.pluginManager.registerEvents(it,plugin)
        }
    }
}