package com.pinygod.exchangeratesapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pinygod.exchangeratesapp.domain.usecase.FetchRatesUseCase
import com.pinygod.exchangeratesapp.domain.usecase.GetLastCurrencyUseCase
import com.pinygod.exchangeratesapp.domain.usecase.SetLastCurrencyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@OptIn(FlowPreview::class)
@HiltViewModel
class MainViewModel @Inject constructor(
    private val fetchRatesUseCase: FetchRatesUseCase,
    private val getLastCurrencyUseCase: GetLastCurrencyUseCase,
    private val setLastCurrencyUseCase: SetLastCurrencyUseCase
) : ViewModel() {

    private val _error = Channel<Unit>()
    val error = _error.receiveAsFlow()

    val baseCurrency = MutableStateFlow("RUB")

    init {
        viewModelScope.launch {
            baseCurrency.value = getLastCurrencyUseCase() ?: "RUB"

            baseCurrency
                .debounce(300)
                .collectLatest { base ->
                    fetchRatesUseCase(base)
                        .onSuccess {
                            setLastCurrencyUseCase(base)
                        }.onFailure {
                            _error.send(Unit)
                        }
                }
        }
    }
}