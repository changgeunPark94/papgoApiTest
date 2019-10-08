package com.example.papgoapitest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.papgoapitest.CoinDataSet
import com.example.papgoapitest.R

class FragmentAdapter(private val list:List<CoinDataSet>): RecyclerView.Adapter<FragmentAdapter.CoinViewHolder>() {
    override fun getItemCount(): Int  = list.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentAdapter.CoinViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return CoinViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: FragmentAdapter.CoinViewHolder, position: Int) {
        val coinDataSet:CoinDataSet
    }
    inner class CoinViewHolder(inflater: LayoutInflater, parent: ViewGroup)
        :RecyclerView.ViewHolder(inflater.inflate(R.layout.item_cardview, parent, false)){
        private var mImageView_Coin:ImageView? = null
        private var mCoinhighlow_Coin:ImageView? = null
        private var mTextviewCoinName:TextView? = null
        private var mTextviewCoinCondition:TextView? = null
        init {
            mTextviewCoinCondition = itemView.findViewById(R.id.textview_coin_conditions)
            mImageView_Coin = itemView.findViewById(R.id.textview_coinName)
            mCoinhighlow_Coin = itemView.findViewById(R.id.image_coin_highlow)
            mTextviewCoinName = itemView.findViewById(R.id.image_coin)
        }
        /*여기에 이제 그 .... 어떻게 바꿀껀지 메소드 들어가야할듯*/
        /*어떤 메소드가 들어가야하냐면 ~~
        * 코인텍스트. 컨디션. 이름. 등락 바꿔주는 메소드 ㅎ_ㅎ */
    }
}