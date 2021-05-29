package com.stores.anbu.ui.admin.uom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.database.*
import com.stores.anbu.R
import com.stores.anbu.data.model.Uom
import com.stores.anbu.data.model.UomData
import com.stores.anbu.databinding.FragmentUomBinding
import com.stores.anbu.ui.admin.uom.adapter.UomAdapter
import com.stores.anbu.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UomFragment:BaseFragment<FragmentUomBinding>(),View.OnClickListener {

    @Inject
    lateinit var databaseref: FirebaseDatabase

    lateinit var myRef : DatabaseReference

    lateinit var uomList: ArrayList<Uom>
    lateinit var uomAdapter:UomAdapter

    lateinit var uomData:Uom
    lateinit var uomItem:String
    lateinit var itemList: ArrayList<String>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myRef = databaseref.getReference("UOM")

        uomList = ArrayList<Uom>()
        itemList = ArrayList<String>()

        uomAdapter = UomAdapter(context,myRef)

        binding.uomList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = uomAdapter
        }

        setOnClickListener()

        val dataListener = object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()){
                    uomList.clear()
                    itemList.clear()
                    for (data in snapshot.children){
                        val uom:String?= data.getValue(String::class.java)
                        uom?.let {
                            uomList.add(Uom(data.key.toString(),uom))
                            itemList.add(uom)
                        }
                    }

                    uomAdapter.setData(uomList)

                }
            }

            override fun onCancelled(error: DatabaseError) {

            }

        }

        myRef.addValueEventListener(dataListener)

    }

    private fun setOnClickListener() {
        binding.submit.setOnClickListener(this::onClick)
    }

    override fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?) = FragmentUomBinding.inflate(inflater,container,false)

    override fun onClick(view: View?) {

        when(view?.id){

            R.id.submit-> addUom()

        }

    }

    fun addUom(){

        uomItem = binding.uomText.text.toString()

        if(!itemList.contains(uomItem)){
            myRef.push().setValue(uomItem).addOnSuccessListener {
                Toast.makeText(context,"Success",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(context,"Item already exist!",Toast.LENGTH_LONG).show()
        }
    }



}