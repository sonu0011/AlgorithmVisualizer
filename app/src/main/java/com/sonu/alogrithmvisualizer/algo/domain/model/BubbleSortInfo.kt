package com.sonu.alogrithmvisualizer.algo.domain.model

data class BubbleSortInfo(
    val currentItem: Int,
    val shouldSwap: Boolean,
    /*
    if we are not doing any swapping then this value sets to true . we could have used shouldSwap
    but this is false in first time and hadNoEffect so
     */
    val hadNoEffect: Boolean

)
