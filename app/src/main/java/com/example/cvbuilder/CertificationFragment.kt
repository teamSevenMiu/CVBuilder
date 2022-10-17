package com.example.cvbuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.FragmentCertificationBinding
import com.example.cvbuilder.databinding.FragmentEducationBinding
import com.example.cvbuilder.databinding.ItemCertificationBinding
import com.example.cvbuilder.databinding.ItemContactBinding



class CertificationFragment : Fragment() {

    private var _binding: FragmentCertificationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCertificationBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = CertificationAdapter(DataService.default.about.certification)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class CertificationAdapter(var list: ArrayList<Certification>) : RecyclerView.Adapter<CertificationAdapter.MyViewHolder>() {

    private lateinit var binding: ItemCertificationBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CertificationAdapter.MyViewHolder {
        binding = ItemCertificationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: CertificationAdapter.MyViewHolder, position: Int) {
        binding.title.text = list[position].name
        binding.image.setImageResource(list[position].image)
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}