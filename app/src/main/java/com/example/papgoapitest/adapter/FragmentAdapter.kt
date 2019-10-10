package com.example.papgoapitest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.papgoapitest.R
import kotlinx.android.synthetic.main.item_cardview.view.*

// Adapter = > Recyclerview의 항목을 구성한다.
class FragmentAdapter(private val mDataset: Array<String>): RecyclerView.Adapter<FragmentAdapter.CoinViewHolder>() {
    override fun getItemCount(): Int  = mDataset.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentAdapter.CoinViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cardview, parent,false)
        return CoinViewHolder(view)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.mTextviewCoinCondition.text = mDataset[position]
    }
    //viewHolder = > 각 항모ㅓㄱ의 구성 뷰의 재활용 목적으로 사용함
    inner class CoinViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){
        var mTextviewCoinCondition:TextView = itemView.textview_coin_conditions
    }
}