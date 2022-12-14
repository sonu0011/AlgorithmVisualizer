package com.sonu.alogrithmvisualizer.algo.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sonu.alogrithmvisualizer.algo.domain.usecases.MergeSortUseCase
import com.sonu.alogrithmvisualizer.algo.presentation.state.BubbleSortInfoUiItem
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.util.*

class MergeSortViewModel(
    private val mergeSortUseCase: MergeSortUseCase = MergeSortUseCase()
) : ViewModel() {
    val listToSort = mutableListOf<Int>()

    val sortInfoUiItemList = mutableStateListOf<BubbleSortInfoUiItem>()

    init {
        for (i in 0 until 8) {
            listToSort.add(
                (10..99).random()
            )
        }
    }

    fun startSorting() {
        sortInfoUiItemList.clear()
        subscribeToSortChanges()
        viewModelScope.launch {
            mergeSortUseCase(listToSort, 0)
        }
    }

    private var job: Job? = null
    private fun subscribeToSortChanges() {
        job?.cancel()
        job = viewModelScope.launch {
            mergeSortUseCase.sortFlow.collect { sortInfo ->
                val depthAlreadyExistListIndex = sortInfoUiItemList.indexOfFirst {
                    it.depth == sortInfo.depth && it.sortState == sortInfo.sortState
                }

                if (depthAlreadyExistListIndex == -1) {
                    sortInfoUiItemList.add(
                        BubbleSortInfoUiItem(
                            id = UUID.randomUUID().toString(),
                            depth = sortInfo.depth,
                            sortParts = listOf(sortInfo.sortParts),
                            color = Color(
                                255,
                                (0..250).random(),
                                (0..70).random(),
                                255
                            ),
                            sortState = sortInfo.sortState
                        )
                    )
                } else {

                    val currentPartList =
                        sortInfoUiItemList[depthAlreadyExistListIndex].sortParts.toMutableList()
                    currentPartList.add(sortInfo.sortParts)

                    sortInfoUiItemList[depthAlreadyExistListIndex] =
                        sortInfoUiItemList[depthAlreadyExistListIndex].copy(sortParts = currentPartList)

                    sortInfoUiItemList.sortedWith(
                        compareBy(
                            { it.sortState },
                            { it.depth }
                        )
                    )
                }
            }
        }
    }
}