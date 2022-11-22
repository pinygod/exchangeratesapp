package com.pinygod.exchangeratesapp.domain.entity

sealed class SortType {
    object AlphabetAsc : SortType()
    object AlphabetDesc : SortType()
    object ValueAsc : SortType()
    object ValueDesc : SortType()
}
