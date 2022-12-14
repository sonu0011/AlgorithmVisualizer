package com.sonu.alogrithmvisualizer.algo.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.flowlayout.FlowRow
import com.google.accompanist.flowlayout.MainAxisAlignment
import com.sonu.alogrithmvisualizer.algo.presentation.viewmodels.MergeSortViewModel
import com.sonu.alogrithmvisualizer.ui.theme.gray
import com.sonu.alogrithmvisualizer.ui.theme.orange

@Composable
fun MergeSortAlgo() {
    val sortViewModel = MergeSortViewModel()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gray)
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ){
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.TopCenter),
            verticalArrangement = Arrangement.spacedBy(30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            itemsIndexed(
                sortViewModel.sortInfoUiItemList,
                key = { _, it ->
                    it.id
                }
            ){ index, it ->
                val depthParts = it.sortParts
                if(index == 0){
                    Text(
                        "Dividing",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 26.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
                if(index == 4){
                    Text(
                        "Merging",
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        fontSize = 26.sp,
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                }
                FlowRow(
                    mainAxisAlignment  = MainAxisAlignment.Center,
                    modifier = Modifier.fillMaxWidth()
                ){
                    for(part in depthParts){
                        FlowRow(
                            mainAxisAlignment  = MainAxisAlignment.Center,
                            modifier = Modifier
                                .padding(start = if (depthParts.indexOf(part) == 0) 0.dp else 17.dp, top = 5.dp)
                                .background(it.color, RoundedCornerShape(10.dp))
                                .padding(5.dp)

                        ){
                            for(numberInformation in part){
                                if (part.indexOf(numberInformation) != part.size-1){
                                    Text(
                                        "$numberInformation |",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 19.sp
                                    )
                                }else{
                                    Text(
                                        "$numberInformation",
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White,
                                        fontSize = 19.sp
                                    )
                                }

                            }
                        }
                    }
                }

            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(gray)
                .padding(15.dp)
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ){
            Text(
                "${sortViewModel.listToSort}",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Button(
                onClick = {
                    sortViewModel.startSorting()
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = orange,
                    contentColor = Color.White
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
            ){
                Text(
                    "Start Merge sort",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}