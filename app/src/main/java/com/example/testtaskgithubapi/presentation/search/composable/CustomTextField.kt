package com.example.testtaskgithubapi.presentation.search.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    padding: PaddingValues = PaddingValues(0.dp),
    content: (@Composable () ->  Unit)? = null,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null
) {
    
    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        color = Color.Black,
        elevation = elevation
    ) {
        Row(
            modifier = Modifier.padding(padding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            if(leadingIcon != null)
                leadingIcon()

            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
                if (content != null) {
                    content()
                }
            }

            if (trailingIcon != null) {
                trailingIcon()
            }

        }


        
    }
    
}