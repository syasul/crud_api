package com.example.api_pbb.presenter

import android.util.Log
import com.example.api_pbb.MainActivity
import com.example.api_pbb.model.ResultStaff
import com.example.api_pbb.model.ResultStatus
import com.example.api_pbb.network.NetworkConfig
import retrofit2.Call
import retrofit2.Response

class Presenter(val crudView: MainActivity) {
    fun getData() {
        NetworkConfig.getService().getData()
            .enqueue(object : retrofit2.Callback<ResultStaff>{
                override fun onFailure(call: Call<ResultStaff>, t: Throwable) {
                    crudView.onFailedGet(t.localizedMessage)
                    Log.d("Error", "Error Data")
                }

                override fun onResponse(call: Call<ResultStaff>, response: Response<ResultStaff>) {
                    if (response.isSuccessful) {
                        val status = response.body()?.status
                        if (status == 200) {
                            val data = response.body()?.staff
                            crudView.onSuccessGet(data)
                        } else {
                            crudView.onFailedGet(" Error: $status")
                        }
                    }
                }
            })
    }

    fun HapusData(id: String?) {
        NetworkConfig.getService()
            .deleteStaff(id)
            .enqueue(object : retrofit2.Callback<ResultStatus> {
                override fun onFailure(call: Call<ResultStatus>, t: Throwable) {
                    crudView.onErrorDelete(t.localizedMessage)
                }

                override fun onResponse(
                    call: Call<ResultStatus>,
                    response: Response<ResultStatus>
                ) {
                    if (response.isSuccessful && response.body()?.status == 200){
                        crudView.onSuccessDelete(response.body()?.pesan ?: "")
                    } else {
                        crudView.onErrorDelete(response.body()?.pesan ?: "")
                    }

                }
            })

    }
}