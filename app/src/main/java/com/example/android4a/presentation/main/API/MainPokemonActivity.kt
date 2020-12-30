package com.example.android4a.presentation.main.API

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log.d
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android4a.R
import com.example.android4a.data.remote.PokeApi
import com.example.android4a.domain.entity.Pokemon
import com.example.android4a.domain.entity.RestPokemonResponse
import com.google.gson.Gson
import kotlinx.android.synthetic.main.recycler_layout.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainPokemonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recycler_layout)
        val BASE_URL: String = "https://raw.githubusercontent.com/Taymard/Android4A/master/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PokeApi::class.java)

        api.getPokemonResponse().enqueue(object : Callback<RestPokemonResponse> {
            override fun onResponse(
                call: Call<RestPokemonResponse>,
                response: Response<RestPokemonResponse>
            ) {
                if (response.isSuccessful && response.body() != null)
                    {
                        recycler_view.apply{
                            layoutManager = LinearLayoutManager(this@MainPokemonActivity)
                            adapter = ListAdapter(response.body()!!.results,this@MainPokemonActivity)
                        }
                    }
                else
                    Toast.makeText(this@MainPokemonActivity,"Response Null",Toast.LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<RestPokemonResponse>, t: Throwable) {
                Toast.makeText(this@MainPokemonActivity, "API Error", Toast.LENGTH_SHORT).show()
            }

        })
    }

}


