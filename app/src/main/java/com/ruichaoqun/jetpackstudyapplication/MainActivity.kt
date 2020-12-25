package com.ruichaoqun.jetpackstudyapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.ruichaoqun.jetpackstudyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.user = User("芮超群", 29)
        val model: MyViewModel by viewModels()
        binding.recyclerView.layoutManager = GridLayoutManager(this,7)
        binding.recyclerView.adapter = TestAdapter()
        binding.recyclerView.setItemViewCacheSize(50)
    }
}