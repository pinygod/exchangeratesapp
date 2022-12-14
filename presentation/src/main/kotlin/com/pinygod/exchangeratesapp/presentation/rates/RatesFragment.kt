package com.pinygod.exchangeratesapp.presentation.rates

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.pinygod.exchangeratesapp.presentation.databinding.FragmentRatesBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RatesFragment : Fragment(), RatesAdapter.RateClickListener {

    private lateinit var binding: FragmentRatesBinding
    private val ratesAdapter: RatesAdapter by lazy { RatesAdapter(this) }
    private val viewModel: RatesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRatesBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            data = viewModel
            rvRates.adapter = ratesAdapter
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.rates.collectLatest { pagingData ->
                    ratesAdapter.submitData(pagingData)
                }
            }
        }
    }

    override fun onIsFavoriteClicked(name: String) {
        viewModel.changeIsFavorite(name)
    }
}