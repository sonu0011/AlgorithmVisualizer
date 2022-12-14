package com.sonu.alogrithmvisualizer.algo.domain.usecases

import com.sonu.alogrithmvisualizer.algo.domain.model.BubbleSortInfo
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class BubbleSortUseCase {

    operator fun invoke(list: MutableList<Int>): Flow<BubbleSortInfo> = flow {
        var listSizeToCompare = list.size - 1

        while (listSizeToCompare > 1) {
            var innerIterator = 0
            while (innerIterator < listSizeToCompare) {
                emit(
                    BubbleSortInfo(currentItem = innerIterator, shouldSwap = false, hadNoEffect = false)
                )
                val currentItem = list[innerIterator]
                val nextItem = list[innerIterator + 1]
                delay(500)
                if (currentItem > nextItem) {
                    list.swap(innerIterator, innerIterator + 1)
                    emit(
                        BubbleSortInfo(
                            currentItem = innerIterator,
                            shouldSwap = true,
                            hadNoEffect = false
                        )
                    )
                } else {
                    emit(
                        BubbleSortInfo(
                            currentItem = innerIterator,
                            shouldSwap = false,
                            hadNoEffect = true
                        )
                    )
                }
                delay(500)
                innerIterator++
            }
            listSizeToCompare--
        }

    }
}

fun <T> MutableList<T>.swap(indexOne:Int, indexTwo:Int){
    val tempOne = this[indexOne]
    this[indexOne] = this[indexTwo]
    this[indexTwo] = tempOne
}
