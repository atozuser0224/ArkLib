package org.gang.util

import kotlin.random.Random


fun <T> Map<T, Int>.getElementByRandom(): T? {
    val totalWeight = this.values.sum()
    if (totalWeight == 0) return null
    val randomValue = Random.nextInt(totalWeight)
    var index = totalWeight
    this.entries.forEach {
        index-=it.value
        if (randomValue in index ..totalWeight){
            return it.key
        }
    }
    return null
}


fun <T> Map<T, Int>.toPercentMap(): List<Int> {
    val totalWeight = this.values.sum()
    return this.map { ((it.value.toFloat() / totalWeight.toFloat()) * 100).toInt() }
}