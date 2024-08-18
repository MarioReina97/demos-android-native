package it.marioreina.demoviews.deal

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import it.marioreina.demoviews.databinding.ItemDealBinding
import it.marioreina.demoviews.domain.entity.DealEntity

class DealAdapter(
    val clickListener: (DealEntity) -> Unit
): ListAdapter<DealEntity, DealAdapter.ViewHolder>(DiffDealsCallbackAdapter()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDealBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DealAdapter.ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bindTo(item)
    }

    inner class ViewHolder(val binding: ItemDealBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindTo(item: DealEntity) {
            binding.imgIcon.load(item.thumb) {
                listener(
                    onStart = { binding.progressBarLoader.isVisible = true },
                    onSuccess = { _ , _ ->
                        binding.progressBarLoader.isVisible = false
                    }
                )
            }
            binding.txtTitle.text = item.title
            binding.txtDiscountPrice.text = String.format("%s$", item.salePrice)
            binding.txtOriginalPrice.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            binding.txtOriginalPrice.text = String.format("%s$", item.normalPrice)
            binding.root.setOnClickListener {
                clickListener(item)
            }
        }
    }
}

class DiffDealsCallbackAdapter : DiffUtil.ItemCallback<DealEntity>() {
    override fun areItemsTheSame(
        oldItem: DealEntity,
        newItem: DealEntity
    ): Boolean = oldItem.dealID == newItem.dealID

    override fun areContentsTheSame(
        oldItem: DealEntity,
        newItem: DealEntity
    ): Boolean = oldItem.toString() == newItem.toString()
}