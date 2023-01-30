package com.wangyan.wecompose.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wangyan.wecompose.R
import com.wangyan.wecompose.ui.theme.WeComposeTheme

@Composable
fun WeBottomBar(selected: Int, onSelectChange: ((Int) -> Unit)? = null) {
    Row(Modifier.background(WeComposeTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectChange?.invoke(0)
                },
            "聊天",
            if (selected == 0) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectChange?.invoke(1)
                },
            "通讯录",
            if (selected == 1) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectChange?.invoke(2)
                },
            "发现",
            if (selected == 2) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
        TabItem(
            if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            Modifier
                .weight(1f)
                .clickable {
                    onSelectChange?.invoke(3)
                },
            "我",
            if (selected == 3) WeComposeTheme.colors.iconCurrent else WeComposeTheme.colors.icon
        )
    }
}

@Composable
fun TabItem(@DrawableRes iconId: Int, modifier: Modifier = Modifier, title: String, tint: Color) {
    Column(
        modifier.padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Icon(
            painter = painterResource(id = iconId),
            title,
            modifier = Modifier.size(24.dp),
            tint = tint
        )
        Text(title, fontSize = 12.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomPreviewLight() {
    WeComposeTheme(WeComposeTheme.Theme.Light) {
        var selectTab by remember { mutableStateOf(0) }
        WeBottomBar(selectTab) {
            selectTab = it
        }    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomPreviewDark() {
    WeComposeTheme(WeComposeTheme.Theme.Dark) {
        var selectTab by remember { mutableStateOf(0) }
        WeBottomBar(selectTab) {
            selectTab = it
        }    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomPreviewNewYear() {
    WeComposeTheme(WeComposeTheme.Theme.NewYear) {
        var selectTab by remember { mutableStateOf(0) }
        WeBottomBar(selectTab) {
            selectTab = it
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(R.drawable.ic_chat_filled, Modifier, "聊天", WeComposeTheme.colors.icon)
}