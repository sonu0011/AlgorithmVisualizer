package com.sonu.alogrithmvisualizer.algo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.graphics.toArgb
import com.sonu.alogrithmvisualizer.algo.presentation.components.BubbleSortAlgo
import com.sonu.alogrithmvisualizer.algo.presentation.components.MergeSortAlgo
import com.sonu.alogrithmvisualizer.ui.theme.AlogrithmVisualizerTheme
import com.sonu.alogrithmvisualizer.ui.theme.orange

class BubbleSortActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = orange.toArgb()
        window.navigationBarColor = orange.toArgb()

        setContent {
            AlogrithmVisualizerTheme {
//              BubbleSortAlgo()
                MergeSortAlgo()
            }
        }
    }
}