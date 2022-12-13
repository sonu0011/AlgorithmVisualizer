package com.sonu.alogrithmvisualizer.bubblesort.domain.model

data class SortInfo(
    val currentItem: Int,
    val shouldSwap: Boolean,
    /*
    if we are not doing any swapping then this value sets to true . we could have used shouldSwap
    but this is false in first time and hadNoEffect so
     */
    val hadNoEffect: Boolean

)
