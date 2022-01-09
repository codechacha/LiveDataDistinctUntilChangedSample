package com.example.distinctuntilchanged

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.distinctuntilchanged.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        binding.button.setOnClickListener {
            val input = binding.editText.text.toString().toInt()
            Log.d("MainActivity", "Button clicked, input value: $input")
            viewModel.setValue(input)
        }

        viewModel.value.observe(this) {
            Log.d("MainActivity", "LiveData updated: $it")
        }
    }
}