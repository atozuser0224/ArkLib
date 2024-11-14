package org.gang.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration


fun textComponent(init : ArcComponent.()->Unit): TextComponent {
    val component = ArcComponent()
    component.init()
    return component.component

}
class ArcComponent{
    val component = Component.empty()
    fun appendText(content : String,init: (ArcTextComponent.()-> Unit)? = null){
        val component = Component.text(content)
        init?.let { ArcTextComponent(component).it() }
        this.component.append(component)

    }
    fun appendNewLine(){
        this.component.appendNewline()
    }
    fun appendSpace(){
        this.component.appendSpace()
    }
}
class ArcTextComponent(val content: TextComponent){
    fun decoration(vararg textDecoration: TextDecoration){
        content.decorations(textDecoration.toMutableSet(),true)
    }
    fun color(color : TextColor){
        content.color(color)
    }
}

@DslMarker
annotation class ArcComponentDsl