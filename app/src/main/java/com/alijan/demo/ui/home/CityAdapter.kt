package com.alijan.demo.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alijan.demo.databinding.ItemCityBinding

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    private val cityList = ArrayList<String>()
    lateinit var onClick: (city: String) -> Unit

    inner class CityViewHolder(val itemCityBinding: ItemCityBinding) :
        RecyclerView.ViewHolder(itemCityBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CityViewHolder {
        val view = ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CityViewHolder(view)
    }

    override fun getItemCount(): Int = cityList.size

    override fun onBindViewHolder(holder: CityViewHolder, position: Int) {
        val currentItem = cityList[position]
        holder.itemCityBinding.item = currentItem
        holder.itemCityBinding.clItemCity.setOnClickListener {
            onClick(currentItem.lowercase())
        }
    }

    fun updateList(newList: List<String>) {
        cityList.clear()
        cityList.addAll(newList)
        notifyDataSetChanged()
    }

}