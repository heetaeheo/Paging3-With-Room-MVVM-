package com.example.paging3withroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.paging3withroom.databinding.ActivityMainBinding
import com.example.paging3withroom.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    lateinit var recyclerViewAdapter: RecyclerAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initViewModel()
    }



    private fun initRecyclerView() {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerAdapter()
            adapter =recyclerViewAdapter
        }
    }

    private fun initViewModel() {
        val viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            viewmodel.getAllRecords().collectLatest {
                recyclerViewAdapter.submitData(it)
            }
        }
        viewmodel.insertDummyRecords()
    }
}