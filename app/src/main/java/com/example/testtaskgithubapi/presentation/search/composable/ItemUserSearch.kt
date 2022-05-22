package com.example.testtaskgithubapi.presentation.search.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.testtaskgithubapi.domain.models.ContentSearch
import com.example.testtaskgithubapi.ui.theme.Grey

@Composable
fun ItemUserSearch(
    modifier: Modifier = Modifier,
    data: ContentSearch
) {
    val painter = rememberAsyncImagePainter(
        ImageRequest.Builder(LocalContext.current).data(data = data.avatarURL).apply(block = fun ImageRequest.Builder.() {
            crossfade(true)
        }).build()
    )

    Row {

        Box(
            modifier = Modifier.size(64.dp)
        ) {
            if (painter.state is AsyncImagePainter.State.Loading) {
//                CenterCircularProgressIndicator(
//                    strokeWidth = 2.dp,
//                    size = 20.dp,
//                    color = MyColor.Yellow500
//                )
            }
            Image(
                painter = painter,
                contentDescription = "Thumbnail",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
//                    .border(2.dp, Color.Gray)
            )
        }

        Column(
            modifier = Modifier
                .weight(1f)
                .height(74.dp)
                .padding(16.dp, 0.dp, 0.dp, 4.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                if (!isSystemInDarkTheme()) {
                    Text(
                        text = data.login,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Text(
                        text = data.type,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = Color.Black,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )
                } else {
                    Text(
                        text = data.login,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        modifier = Modifier.padding(top = 2.dp)
                    )

                    Text(
                        text = data.type,
                        maxLines = 4,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Normal
                        ),
                        modifier = Modifier
                            .padding(bottom = 3.dp)
                    )
                }
            }
        }
    }
    Divider(
        color = Grey,
        thickness = 1.dp,
        modifier = Modifier.padding(bottom = 8.dp)
    )

}