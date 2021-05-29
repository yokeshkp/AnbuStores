package com.stores.anbu.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.stores.anbu.R
import com.stores.anbu.databinding.FragmentLoginBinding
import com.stores.anbu.ui.base.BaseFragment

class LoginFragment:BaseFragment<FragmentLoginBinding>(),View.OnClickListener {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setOnClickListeners()

    }

    private fun setOnClickListeners() {
        binding.login.setOnClickListener(this::onClick)
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    )= FragmentLoginBinding.inflate(inflater,container,false)


    override fun onClick(view: View?) {

        when(view?.id){

            R.id.login -> findNavController().navigate(R.id.action_loginFragment_to_uomFragment)

        }

    }
}