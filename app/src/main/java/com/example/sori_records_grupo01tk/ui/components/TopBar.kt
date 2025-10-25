package com.example.sori_records_grupo01tk.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sori_records_grupo01tk.R
import com.example.sori_records_grupo01tk.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    title: String,
    onOpenDrawer: () -> Unit
) {
    Column{
        CenterAlignedTopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(7.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.logo_icon_app),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .height(35.dp)
                            .width(35.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = title,
                        style = TextStyle(
                            color = TextOnDark,
                            fontSize = 24.sp,
                            shadow = Shadow(
                                color = BackgroundDark,
                                offset = Offset(3f, 3f),
                                blurRadius = 1f
                            )
                        )
                    )
                }
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Menu",
                    modifier = Modifier
                        .clickable {
                        onOpenDrawer()
                    }
                        .padding(15.dp)
                )
            },

            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = PrimaryColor,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        HorizontalDivider(
            thickness = 2.dp,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}