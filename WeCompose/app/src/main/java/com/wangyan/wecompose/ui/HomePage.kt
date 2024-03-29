package com.wangyan.wecompose.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.wangyan.wecompose.WeViewModel
import kotlinx.coroutines.launch

@Composable
@OptIn(ExperimentalPagerApi::class)
fun HomePage(weViewModel: WeViewModel) {
    Column {
        val pagerState = rememberPagerState()
        HorizontalPager(
            count = 4, Modifier.weight(1f), pagerState
        ) { page ->
            when (page) {
                0 -> ChatList(weViewModel.chats)
                1 -> ContactList()
                2 -> DiscoveryList()
                3 -> MeList()
            }
        }

        val scope = rememberCoroutineScope() // 创建 CoroutineScope
        // 不显示 viewModel.selectedTab，改为 pagerState.currentPage
        WeBottomBar(pagerState.currentPage) { page ->
            // 点击页签后，在协程里翻页
            scope.launch {
                pagerState.animateScrollToPage(page)
            }
        }
    }
}