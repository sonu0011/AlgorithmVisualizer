package com.sonu.alogrithmvisualizer.bubblesort.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonu.alogrithmvisualizer.bubblesort.domain.usecase.BubbleSortUseCase
import com.sonu.alogrithmvisualizer.bubblesort.presentation.state.ListUiItem
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SortViewModel(
    private val sortUseCase: BubbleSortUseCase = BubbleSortUseCase()
) : ViewModel() {
    val listToSort = mutableStateListOf<ListUiItem>()

    init {
        for (i in 0 until 9) {
            listToSort.add(
                ListUiItem(
                    id = i,
                    value = (0..150).random(),
                    isCurrentlyCompare = false,
                    color = Color(
                        255,
                        (0..130).random(),
                        (0..70).random(),
                        255

                    )
                )
            )
        }
    }

    fun startSorting() {
        viewModelScope.launch {
            sortUseCase(listToSort.map { it.value }.toMutableList())
                .collect { sortInfo ->
                    val currentItemIndex = sortInfo.currentItem

                    //show compare animation
                    listToSort[currentItemIndex] =
                        listToSort[currentItemIndex].copy(isCurrentlyCompare = true)
                    listToSort[currentItemIndex + 1] =
                        listToSort[currentItemIndex + 1].copy(isCurrentlyCompare = true)

                    if (sortInfo.shouldSwap) {
                        //show swap
                        val currentItem =
                            listToSort[currentItemIndex].copy(isCurrentlyCompare = false)
                        listToSort[currentItemIndex] =
                            listToSort[currentItemIndex + 1].copy(isCurrentlyCompare = false)
                        listToSort[currentItemIndex+1] = currentItem
                    }

                    if (sortInfo.hadNoEffect) {
                        //reset compare animation with hadNoEffect set to true
                        listToSort[currentItemIndex] =
                            listToSort[currentItemIndex].copy(isCurrentlyCompare = false)
                        listToSort[currentItemIndex + 1] =
                            listToSort[currentItemIndex + 1].copy(isCurrentlyCompare = false)
                    }

                    delay(500)
                }
        }
    }
}