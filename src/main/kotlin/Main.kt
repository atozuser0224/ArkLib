package org.gang

import org.bukkit.configuration.file.YamlConfiguration
import org.gang.util.getElementByRandom
import org.gang.util.toPercentMap
import java.io.File
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.jvmErasure


//
//object ConfigManager{
//    fun parsingClass(clazz: KClass<*>): List<KProperty1<out Any, *>> {
//        return clazz.memberProperties.filter { property ->
//            // 반환 타입이 List인지 확인
//            property.returnType.jvmErasure == List::class
//        }
//    }
//    fun saveClassToConfig(instance: Any, config: YamlConfiguration, file: File) {
//        val clazz: KClass<*> = instance::class
//
//        // 모든 속성 저장
//        clazz.memberProperties.forEach { property ->
//            val value = property.get(instance)
//            config.set(property.name, value)
//        }
//
//        // 파일에 저장
//        config.save(file)
//    }
//
//}