package com.android.mynetworktest2sample.features.dashboard.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.android.mynetworktest2sample.features.dashboard.viewmodel.DashboardViewModel
import com.android.mynetworktest2sample.R
import com.android.mynetworktest2sample.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var deletingUId:Long = 3
    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fetchDummyData()

        receiveResponse()

        binding.deleteBtn.setOnClickListener {
            lifecycleScope.launch {
                viewModel.deleteRecord(deletingUId)
                deletingUId++
            }
        }
    }

    private fun receiveResponse() {
        viewModel.dashboardData.observe(this){ list ->
            println(list)
            binding.dashboardDataTxt.text = ""
            list.forEach {
                binding.dashboardDataTxt.append("\n\n"+it.toString())
            }
        }

        viewModel.deleteRecordStatus.observe(this){ deleteRecordStatus ->
            if(deleteRecordStatus){
                println(">>> deleted record successfully")
            }else {
                println(">>> deleted failed")
            }
        }
    }

    private fun fetchDummyData() {
        lifecycleScope.launch {
            viewModel.fetchData()
        }
    }
}