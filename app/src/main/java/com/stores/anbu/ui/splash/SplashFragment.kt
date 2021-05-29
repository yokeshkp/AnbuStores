package com.stores.anbu.ui.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stores.anbu.R
import com.stores.anbu.databinding.FragmentSplashBinding
import com.stores.anbu.ui.base.BaseFragment

class SplashFragment:BaseFragment<FragmentSplashBinding>() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed(Runnable {
              findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        },3000)

    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentSplashBinding.inflate(inflater,container,false)
}