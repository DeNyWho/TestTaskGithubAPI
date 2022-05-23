package com.example.testtaskgithubapi.presentation.search.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.Shimmer
import com.valentinilk.shimmer.shimmer

@Composable
fun ItemSearchShimmer(shimmerInstance: Shimmer) {
    Row {

        Box(
            modifier = Modifier
                .shimmer(shimmerInstance)
                .size(64.dp)
                .clip(CircleShape)
                .background(color = Color.Gray)
        )

        Column(
            modifier = Modifier
                .shimmer(shimmerInstance)
                .weight(1f)
                .height(50.dp)
                .padding(16.dp, 0.dp, 0.dp, 4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .height(16.dp)
                    .width(40.dp)
                    .background(color = Color.Gray)
            )
            Box(
                modifier = Modifier
                    .height(12.dp)
                    .width(40.dp)
                    .background(color = Color.Gray)
            )

        }

    }
    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
        )
}