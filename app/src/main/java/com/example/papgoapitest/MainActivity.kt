package com.example.papgoapitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.papgoapitest.adapter.FragmentAdapter
import com.example.papgoapitest.navigation.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_btc.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    var gson = Gson()
    lateinit var coinDatasetList : List<CoinDataSet>
    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
            R.id.navigation_coinBTC -> {
                var fragmentview = BTCViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }
            /*R.id.navigation_coinBCH -> {
                var fragmentview = BCHViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }*/
            R.id.navigation_coinETH -> {
                var fragmentview = ETHViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }
            /*R.id.navigation_coinLTC -> {
                var fragmentview = LTCViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }*/
            R.id.navigation_coinXRP -> {
                var fragmentview = XRPViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }
        }
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate")
        setTitle("Bithumb 투자 API")

        bottom_nav_bar.setOnNavigationItemSelectedListener(this)

    }
    fun setProgressBarVisibility() {
        progress_circular1.visibility = View.GONE
    }
    override fun onStart() {
        super.onStart()
        println("onStart")

        var jsonres:String

        val JSON = MediaType.parse("application/json; charset=utf-8")
        val client = OkHttpClient()
        var url = "https://api.bithumb.com/public/ticker/all"
        var json = JSONObject()

        val body = RequestBody.create(JSON, json.toString())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        //progress_circular1.visibility = View.VISIBLE
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                jsonres = response!!.body()!!.string()
                try {
                    var statueChk = gson.fromJson(jsonres, BithumbStatue::class.java)
                    if (statueChk.status == "0000") {
                        Log.e("TAG", "Statue is not Nomal CODE : ${statueChk.status}")
                    }
                } catch (e:IOException) {
                    e.printStackTrace()
                }
                var bitDTO = gson.fromJson(jsonres, BitcoinDTO::class.java)
                DTOtoDataSet(bitDTO)
            }
        })
    }
    fun DTOtoDataSet(bitdto:BitcoinDTO) {
        coinDatasetList= listOf(

        )
    }
}