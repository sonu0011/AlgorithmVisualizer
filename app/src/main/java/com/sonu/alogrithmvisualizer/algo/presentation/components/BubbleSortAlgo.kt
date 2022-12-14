package com.sonu.alogrithmvisualizer.algo.presentation.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sonu.alogrithmvisualizer.algo.presentation.viewmodels.BubbleSortViewModel
import com.sonu.alogrithmvisualizer.ui.theme.gray

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BubbleSortAlgo() {
    val bubbleSortViewModel = BubbleSortViewModel()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {
        Button(onClick = { bubbleSortViewModel.startSorting() }) {
            Text(
                text = "Sort List (Bubble Sort)", fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
        }
        LazyColumn(
        ) {
            items(
                bubbleSortViewModel.listToSort,
                key = {
                    it.id
                }
            ) {
                val borderStroke = if (it.isCurrentlyCompare) {
                    BorderStroke(width = 3.dp, Color.White)
                } else BorderStroke(width = 0.dp, Color.Transparent)

                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .padding(5.dp)
                        .size(64.dp)
                        .background(it.color, RoundedCornerShape(15.dp))
                        .border(borderStroke, RoundedCornerShape(15.dp))
                        .animateItemPlacement(
                            tween(300)
                        )

                ) {
                    Text(
                        text = " ${it.value}",
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}