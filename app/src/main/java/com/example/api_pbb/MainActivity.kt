package com.example.api_pbb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.api_pbb.databinding.ActivityMainBinding
import com.example.api_pbb.model.DataItem
import com.example.api_pbb.presenter.CrudView
import com.example.api_pbb.presenter.Presenter

class MainActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this)
        presenter.getData()

        binding.btnTambah.setOnClickListener {
            startActivity(Intent(applicationContext, UpdateAddActivity::class.java))
            finish()
        }

    }

    override fun successAdd(msg: String) {

    }

    override fun onErrorAdd(msg: String) {
    }

    override fun onSuccessGet(data: List<DataItem>?) {
        binding.rvCategory.adapter = DataAdapter(data, object : DataAdapter.onClickItem {
            override fun clicked(item: DataItem?) {
                val bundle = Bundle()
                bundle.putSerializable("dataItem", item)
                val intent = Intent(applicationContext, UpdateAddActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }

            override fun delete(item: DataItem?) {
                presenter.HapusData(item?.staffId)
                startActivity(Intent(applicationContext, MainActivity::class.java))
                finish()
            }
        })
    }

    override fun onFailedGet(msg: String) {
    }

    override fun onSuccessUpdate(msg: String) {
    }

    override fun onErrorUpdate(msg: String) {
    }

    override fun onSuccessDelete(msg: String) {
    }

    override fun onErrorDelete(msg: String) {
    }


}