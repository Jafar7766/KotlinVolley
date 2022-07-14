package com.example.kotlinvolley

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        put()
    }

    var poster = Poster(2, "Steve Job", "10000", 15, 0)

    fun get() {
        VolleyHttp.get(
            VolleyHttp.API_LIST_POST,
            VolleyHttp.paramsEmpty(),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@onResponse ", response!!);
                }
                override fun onError(error: String?) {
                    Log.d("@@@onErrorResponse ", error!!);
                }
            })
    }

    private fun post() {
        VolleyHttp.post(
            VolleyHttp.API_CREATE_POST,
            VolleyHttp.paramsCreate(poster),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@onResponse ", response!!);
                }
                override fun onError(error: String?) {
                    Log.d("@@@onErrorResponse ", error!!);
                }
            })
    }

    private fun put() {
        VolleyHttp.put(
            VolleyHttp.API_UPDATE_POST + poster.id,
            VolleyHttp.paramsUpdate(poster),
            object : VolleyHandler {
                override fun onSuccess(response: String?) {
                    Log.d("@@@onResponse ", response!!);
                }
                override fun onError(error: String?) {
                    Log.d("@@@onErrorResponse ", error!!);
                }
            })
    }
    private fun delete() {
        VolleyHttp.del(VolleyHttp.API_DELETE_POST + poster.id, object : VolleyHandler {
            override fun onSuccess(response: String?) {
                Log.d("@@@onResponse ", response!!);
            }
            override fun onError(error: String?) {
                Log.d("@@@onErrorResponse ", error!!);
            }
        })
    }
}