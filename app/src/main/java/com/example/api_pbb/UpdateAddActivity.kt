package com.example.api_pbb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.api_pbb.databinding.ActivityUpdateAddBinding
import com.example.api_pbb.model.DataItem
import com.example.api_pbb.presenter.CrudView
import com.example.api_pbb.presenter.Presenter2

@Suppress("SENSELESS_COMPARISON")
class UpdateAddActivity : AppCompatActivity(), CrudView {
    private lateinit var presenter: Presenter2
    private lateinit var binding: ActivityUpdateAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter2(this)
        val itemDataItem = intent.getSerializableExtra("dataItem")

        if (itemDataItem == null) {
            binding.btnAction.text = "Tambah"
            binding.btnAction.setOnClickListener {
                presenter.addData(
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString()
                )
            }
        } else if (itemDataItem != null) {
            binding.btnAction.text = "Update"
            val item = itemDataItem as DataItem?
            binding.etName.setText(item?.staffName.toString())
            binding.etPhone.setText(item?.staffHp.toString())
            binding.etAddress.setText(item?.staffAlamat.toString())
            binding.btnAction.setOnClickListener {
                presenter.updateData(
                    item?.staffId ?: "",
                    binding.etName.text.toString(),
                    binding.etPhone.text.toString(),
                    binding.etAddress.text.toString()
                )
                finish()
            }
        }
    }

    override fun successAdd(msg: String) {
    }

    override fun onErrorAdd(msg: String) {
    }

    override fun onSuccessGet(data: List<DataItem>?) {
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