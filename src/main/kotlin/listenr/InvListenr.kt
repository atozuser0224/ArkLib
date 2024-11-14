package org.gang.listenr

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.gang.inv.InvManager

class InvListenr : Listener {
    @EventHandler
    fun onClickInventory(e : InventoryClickEvent){
        InvManager.getClickEvent(e)
    }

    @EventHandler
    fun onCloseInventory(e : InventoryCloseEvent){
        InvManager.getCloseEvent(e)
    }

    @EventHandler
    fun onOpenInventory(e : InventoryOpenEvent){
        InvManager.getOpenEvent(e)
    }
}

