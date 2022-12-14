package com.sonu.alogrithmvisualizer.algo.presentation.state

import androidx.compose.ui.graphics.Color

data class ListUiItem(
    val id: Int,
    val isCurrentlyCompare: Boolean,
    val value: Int,
    val color: Color
)
