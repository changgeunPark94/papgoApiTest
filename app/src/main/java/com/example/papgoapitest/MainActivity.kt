package com.example.papgoapitest

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.papgoapitest.adapter.FragmentAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import com.google.gson.JsonParser
import okhttp3.*
import org.json.JSONObject
import java.io.IOException
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    lateinit var CoindataToFragment:CoinDataSet

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when(p0.itemId) {
/*            R.id.navigation_coinBTC -> {
                var fragmentview = BTCViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }
            *//*R.id.navigation_coinBCH -> {
                var fragmentview = BCHViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }*//*
            R.id.navigation_coinETH -> {
                var fragmentview = ETHViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }
            *//*R.id.navigation_coinLTC -> {
                var fragmentview = LTCViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }*//*
            R.id.navigation_coinXRP -> {
                var fragmentview = XRPViewFragment()
                supportFragmentManager.beginTransaction().replace(R.id.main_content, fragmentview).commit()
                return true
            }*/
        }
        return false
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println("onCreate")
        setTitle("Bithumb 투자 API")

        bottom_nav_bar.setOnNavigationItemSelectedListener(this)

        val rv = findViewById(R.id.main_recycleView) as RecyclerView
        val llm = LinearLayoutManager(this@MainActivity)
        rv.setHasFixedSize(true)
        rv.layoutManager = llm
        // var adapter = FragmentAdapter(arrayOf("Example One", "Example Two", "Example Three", "Example Four", "Example Five", "Example Six", "Example Seven"))
        // rv.adapter = adapter

        var arraylist = arrayListOf<CoinDataSet>(5)

        val mAdapter = FragmentAdapter(arraylist)
        rv.adapter = mAdapter
        /*var progressBar : ProgressBar? = null
        progressBar = findViewById<ProgressBar>(R.id.progress_circular1)

        progressBar!!.visibility = View.VISIBLE*/

        // set_Dialog(true)
        var gson = Gson()

        var jsonres:String
        val JSON = MediaType.parse("application/json; charset=utf-8")
        val client = OkHttpClient()
        var url = "https://api.bithumb.com/public/ticker/btc"
        var json = JSONObject()
        val body = RequestBody.create(JSON, json.toString())
        val request = Request.Builder()
            .url(url)
            .post(body)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
            }

            override fun onResponse(call: Call, response: Response) {
                jsonres = response!!.body()!!.string()
                val parser = JsonParser()
                val dataclass = parser.parse(jsonres).asJsonObject.get("data")

                val statueChk = gson.fromJson(jsonres, BithumbStatue::class.java)
                val dataDTO: BitcoinDTO = gson.fromJson(dataclass, BitcoinDTO::class.java)
                println(dataDTO.max_price)
                dataDTO.name = "비트코인"
            }
        })

    }
    fun set_Dialog(boolean: Boolean) {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setMessage("Loading Data ...")
            .setCancelable(false)
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id-> dialog.cancel()  })

        val alert = dialogBuilder.create()
        alert.setTitle("Data Loading . . . .")
        if (boolean) {
            alert.show()
        } else {
            alert.cancel()
        }

    }

    override fun onStart() {
        super.onStart()

    }
}