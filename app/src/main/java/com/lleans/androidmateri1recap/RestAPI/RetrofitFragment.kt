package com.lleans.androidmateri1recap.RestAPI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lleans.androidmateri1recap.R
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray


class RetrofitFragment : Fragment() {
    private val url = "https://www.breakingbadapi.com/api/characters?limit=10"
    private val listData = ArrayList<JsonData>()
    lateinit var item_recycler: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        item_recycler = view.findViewById(R.id.item_recycler)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val client = AsyncHttpClient()
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>,
                responseBody: ByteArray
            ) {
                val response = String(responseBody)
                val arrayData = JSONArray(response)
                for (i in 0 until arrayData.length()) {
                    val objectData = arrayData.getJSONObject(i)
                    val title = objectData.getString("name")
                    val urlThumbnail = objectData.getString("img")
                    val status = objectData.getString("status")
                    val allData = JsonData(title, urlThumbnail, status)
                    listData.add(allData)
                }
                item_recycler.layoutManager = GridLayoutManager(context, 1)
                val adapter = AdapterRecycler(listData)
                item_recycler.adapter = adapter
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                Toast.makeText(activity, headers.toString(), Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_retrofit, container, false)
    }

}