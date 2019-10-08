package com.example.papgoapitest.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.papgoapitest.CoinDataSet
import com.example.papgoapitest.R
import com.example.papgoapitest.adapter.FragmentAdapter
import kotlinx.android.synthetic.main.fragment_btc.*

class BTCViewFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_btc,container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var list:List<CoinDataSet>

        main_recycleView.adapter = FragmentAdapter(list)
        main_recycleView.layoutManager = LinearLayoutManager(view.context) // 여기 에러날거같음

    }
}