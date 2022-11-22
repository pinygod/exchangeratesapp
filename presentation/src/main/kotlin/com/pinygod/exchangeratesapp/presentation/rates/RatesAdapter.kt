package com.pinygod.exchangeratesapp.presentation.rates

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.pinygod.exchangeratesapp.domain.entity.Rate
import com.pinygod.exchangeratesapp.presentation.databinding.RateItemBinding

class RatesAdapter(private val clickListener: RateClickListener) :
    ListAdapter<Rate, RatesAdapter.RateViewHolder>(Companion) {

    class RateViewHolder(val binding: RateItemBinding) : RecyclerView.ViewHolder(binding.root)

    companion object : DiffUtil.ItemCallback<Rate>() {
        override fun areItemsTheSame(oldItem: Rate, newItem: Rate): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Rate, newItem: Rate): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RateViewHolder {
        val binding = RateItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return RateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RateViewHolder, position: Int) {
        val rate = getItem(position) ?: return

        holder.binding.data = rate
        holder.binding.clickListener = clickListener
    }

    interface RateClickListener {
        fun onIsFavoriteClicked(name: String)
    }
}