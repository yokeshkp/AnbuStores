package com.stores.anbu.ui.init

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.stores.anbu.databinding.ActivityInitBinding
import com.stores.anbu.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InitActivity : BaseActivity() {

    lateinit var binding:ActivityInitBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityInitBinding.inflate(getLayoutInflater())
        setContentView(binding.root)



    }
}