package com.wangyan.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.wangyan.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme {
                Column {
//                    WeBottomBar()
                }
            }
        }
    }

    @Composable
    private fun WeBottomBar(selected: Int) {
        Row {
            TabItem(
                if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
                "聊天"
            )
            TabItem(
                if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
                "通讯录"
            )
            TabItem(
                if (selected == 2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined,
                "发现"
            )
            TabItem(if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined, "我")
        }
    }

    @Composable
    private fun TabItem(@DrawableRes iconId: Int, title: String) {
        Column {
            Icon(painterResource(id = iconId), title, Modifier.padding(8.dp))
            Text(title)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun WeBottomPreview() {
        WeBottomBar(selected = 0)
    }

    @Preview(showBackground = true)
    @Composable
    fun TabItemPreview() {
        TabItem(R.drawable.ic_chat_filled, "聊天")
    }
}


