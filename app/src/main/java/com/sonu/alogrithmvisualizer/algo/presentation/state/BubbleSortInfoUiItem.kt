package com.sonu.alogrithmvisualizer.algo.presentation.state

import androidx.compose.ui.graphics.Color
import com.sonu.alogrithmvisualizer.algo.domain.model.SortState

data class BubbleSortInfoUiItem(
    val id:String,
    val depth:Int,
    val sortState: SortState,
    val sortParts:List<List<Int>>,
    val color: Color
)
