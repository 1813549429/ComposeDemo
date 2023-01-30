package com.wangyan.wecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wangyan.wecompose.ui.ChatPage
import com.wangyan.wecompose.ui.HomePage
import com.wangyan.wecompose.ui.theme.WeComposeTheme

class MainActivity : ComponentActivity() {

    private val weViewModel by viewModels<WeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeTheme(theme = weViewModel.theme) {
                HomePage(weViewModel)
                ChatPage()
            }
        }
    }



    @Composable
    @Preview
    fun MainPreview() {
        val weViewModel = viewModel<WeViewModel>()
        WeComposeTheme(theme = weViewModel.theme) {
            HomePage(weViewModel)
            ChatPage()
        }
    }

    override fun onBackPressed() {
        if (!weViewModel.endChat()) {
            super.onBackPressed()
        }
    }
}


