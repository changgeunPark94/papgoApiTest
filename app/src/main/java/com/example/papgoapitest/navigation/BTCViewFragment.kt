package com.example.papgoapitest.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.papgoapitest.*
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.fragment_btc.*
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import android.content.ContentValues
import android.os.AsyncTask
import android.os.AsyncTask.execute
import com.example.papgoapitest.adapter.FragmentAdapter as FragmentAdapter


class BTCViewFragment() : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = LayoutInflater.from(activity).inflate(R.layout.fragment_btc,container,false)

        val rv = view.findViewById(R.id.main_recycleView) as RecyclerView
        rv.setHasFixedSize(true)

        val llm = LinearLayoutManager(activity)
        rv.layoutManager = llm

        var adapter = FragmentAdapter(arrayOf("Example One", "Example Two", "Example Three", "Example Four", "Example Five", "Example Six", "Example Seven"))
        rv.adapter = adapter

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}