package com.ruichaoqun.jetpackstudyapplication

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.ruichaoqun.jetpackstudyapplication.databinding.ActivityMainBinding
import com.ruichaoqun.lifecycler.MyLocationListener

class MainActivity : AppCompatActivity() {
    private lateinit var locationListener: MyLocationListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.user = User("芮超群", 29)
        val model: MyViewModel by viewModels()
        model.getUser().observe(this, Observer<List<User>> { users ->
            //updateUi
            binding.text = users.size.toString()
        })
    }

    override fun onStart() {
        super.onStart()
        locationListener.start()
    }

    override fun onStop() {
        super.onStop()
        locationListener.stop()
    }
}