package com.salem.foodapp.presentation.extentions

import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerScope

@ExperimentalPagerApi
fun PagerScope.calculateCurrentOffsetForPage(page: Int): Float {
    return (currentPage - page) + currentPageOffset
}
