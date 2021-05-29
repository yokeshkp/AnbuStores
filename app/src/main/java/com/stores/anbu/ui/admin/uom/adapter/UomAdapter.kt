package com.stores.anbu.ui.admin.uom.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.stores.anbu.data.model.Uom
import com.stores.anbu.databinding.UomItemBinding

class UomAdapter(val context: Context?,val databaseRef:DatabaseReference?) : RecyclerView.Adapter<UomAdapter.UomViewHolder>() {

    var list:ArrayList<Uom> = ArrayList<Uom>();

    fun setData(uomList: ArrayList<Uom>){
        list.clear()
        list.addAll(uomList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UomViewHolder {
        val view = UomItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return UomViewHolder(view)
    }

    override fun onBindViewHolder(holder: UomViewHolder, position: Int) {
        holder.bind(list.get(position))
        holder.binding.remove.setOnClickListener(View.OnClickListener {

            databaseRef?.child(list.get(position).id)?.setValue(null)

        })
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class UomViewHolder(itemView:  UomItemBinding) : RecyclerView.ViewHolder(itemView.root){
        val binding = UomItemBinding.bind(itemView.root)

        fun bind(data: Uom?) {
            with(binding) {
                item.text = data?.uom
            }
        }
    }

}