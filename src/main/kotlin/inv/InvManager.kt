package org.gang.inv

import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent

object InvManager {
    val invs = mutableListOf<ArcInv>()

    fun getClickEvent(e : InventoryClickEvent){
        invs.firstOrNull { it.inv == e.inventory }?.inventoryClickEvent
    }

    fun getCloseEvent(e : InventoryCloseEvent){
        invs.firstOrNull { it.inv == e.inventory }?.inventoryCloseEvent
    }

    fun getOpenEvent(e : InventoryOpenEvent){
        invs.firstOrNull { it.inv == e.inventory }?.inventoryOpenEvent
    }
}