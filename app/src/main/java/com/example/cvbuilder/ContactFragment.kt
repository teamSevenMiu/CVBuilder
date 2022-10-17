package com.example.cvbuilder

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.ItemContactBinding
import com.example.cvbuilder.databinding.FragmentContactBinding

class ContactFragment : Fragment() {

    private var _binding: FragmentContactBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentContactBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = ContactAdapter(DataService.default.contact)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class ContactAdapter(var list: ArrayList<Contact>) : RecyclerView.Adapter<ContactAdapter.MyViewHolder>() {

    private lateinit var binding: ItemContactBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.MyViewHolder {
        binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ContactAdapter.MyViewHolder, position: Int) {
        binding.title.text = list[position].value
        binding.subtitle.text = list[position].title
        binding.image.setImageResource(list[position].image)
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}