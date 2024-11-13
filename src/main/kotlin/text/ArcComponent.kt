package org.gang.text

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.NamedTextColor
import net.kyori.adventure.text.format.TextColor
import net.kyori.adventure.text.format.TextDecoration


@ArcComponentDsl
fun textComponent(init : ArcComponent.()->Unit): TextComponent {
    val component = ArcComponent()
    component.init()
    return component.component

}
@ArcComponentDsl
class ArcComponent{
    val component = Component.empty()
    @ArcComponentDsl
    fun appendText(content : String,init: ArcTextComponent.()-> Unit){
        val component = Component.text(content)
        ArcTextComponent(component).init()
        this.component.append(component)

    }
    @ArcComponentDsl
    fun appendNewLine(){
        this.component.appendNewline()
    }
    @ArcComponentDsl
    fun appendSpace(){
        this.component.appendSpace()
    }
}
@ArcComponentDsl
class ArcTextComponent(val content: TextComponent){
    @ArcComponentDsl
    fun decoration(vararg textDecoration: TextDecoration){
        content.decorations(textDecoration.toMutableSet(),true)
    }
    @ArcComponentDsl
    fun color(color : TextColor){
        content.color(color)
    }
}

@DslMarker
annotation class ArcComponentDsl