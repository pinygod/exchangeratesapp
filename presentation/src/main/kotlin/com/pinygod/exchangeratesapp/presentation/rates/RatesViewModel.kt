package com.pinygod.exchangeratesapp.presentation.rates

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinygod.exchangeratesapp.domain.entity.SortType
import com.pinygod.exchangeratesapp.domain.usecase.ChangeIsFavoriteUseCase
import com.pinygod.exchangeratesapp.domain.usecase.GetRatesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RatesViewModel @Inject constructor(
    private val getRatesUseCase: GetRatesUseCase,
    private val changeIsFavoriteUseCase: ChangeIsFavoriteUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val isFavorite: Boolean =
        savedStateHandle.get<Boolean>("isFavorite")
            ?: throw IllegalStateException("isFavorite argument was expected")

    val sort = MutableStateFlow(0)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getRates() = sort.flatMapLatest {
        val sortType = when (it) {
            0 -> SortType.AlphabetDesc
            1 -> SortType.AlphabetAsc
            2 -> SortType.ValueDesc
            else -> SortType.ValueAsc
        }

        getRatesUseCase(sortType = sortType, favoriteOnly = isFavorite)
    }

    fun changeIsFavorite(name: String) {
        viewModelScope.launch {
            changeIsFavoriteUseCase(name)
        }
    }
}