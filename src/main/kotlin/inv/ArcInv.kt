package org.gang.inv

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryCloseEvent
import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack
import org.gang.text.textComponent

class ArcInv(val inv : Inventory)  {
    var inventoryClickEvent : (InventoryClickEvent.()-> Unit)? = null
    var inventoryCloseEvent : (InventoryCloseEvent.()-> Unit)? = null
    var inventoryOpenEvent : (InventoryOpenEvent.()-> Unit)? = null

    fun onClick(init : InventoryClickEvent.()-> Unit){
        inventoryClickEvent = init
    }
    fun onOpen(init : InventoryOpenEvent.()-> Unit){
        inventoryOpenEvent = init
    }
    fun onClose(init : InventoryCloseEvent.()-> Unit){
        inventoryCloseEvent = init
    }
    fun item(x : Int , y : Int, itemStack: ItemStack){
        inv.setItem(y * 9 + x, itemStack)
    }
    operator fun Int.invoke(action: () -> Unit) {
        println("This is number $this")
        action()
    }
    fun open(player: Player){
        player.openInventory(inv)
    }
}



fun inv(name : Component, size : Int,init : ArcInv.()-> Unit): ArcInv {
    val inv = Bukkit.createInventory(null,size * 9 , name)
    val arcInv = ArcInv(inv)
    InvManager.invs.add(arcInv)
    return arcInv
}