package com.example.testtaskgithubapi.presentation.search.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testtaskgithubapi.R
import com.example.testtaskgithubapi.ui.theme.Grey
import com.example.testtaskgithubapi.ui.theme.OnDarkSurface

@Composable
fun SearchEditText(
    value: String = "",
    placeholder: String = "",
    focusRequester: FocusRequester = FocusRequester(),
    onValueChange: (String) -> Unit = { }
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        cursorBrush = SolidColor(Color.Red),
        textStyle = TextStyle(color = OnDarkSurface, fontSize = 16.sp),
        modifier = Modifier.fillMaxWidth().focusRequester(focusRequester)
    )

    if (value.isEmpty()) {
        Text(
            text = placeholder,
            style = TextStyle(color = Grey, fontSize = 16.sp)
        )
    }
}

@Composable
fun SearchLeadingIcon(
    size: Dp = 24.dp,
    padding: PaddingValues = PaddingValues(6.dp)
) {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "Search",
        modifier = Modifier.padding(padding),
        tint = Grey
    )
}

@Composable
fun SearchTrailingIcon(
    size: Dp = 24.dp,
    padding: PaddingValues = PaddingValues(6.dp),
    onClick: () -> Unit
) {
    IconButton(
        modifier = Modifier.then(Modifier.size(size)),
        onClick = onClick,
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_close),
            contentDescription = "Close"
        )
    }
}