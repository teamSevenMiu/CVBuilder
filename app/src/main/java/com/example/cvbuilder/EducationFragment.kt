package com.example.cvbuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.FragmentEducationBinding
import com.example.cvbuilder.databinding.ItemContactBinding
import com.example.cvbuilder.databinding.ItemEducationBinding


class EducationFragment : Fragment() {

    private var _binding: FragmentEducationBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEducationBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = EducationAdapter(DataService.default.about.education)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class EducationAdapter(var list: ArrayList<Education>) : RecyclerView.Adapter<EducationAdapter.MyViewHolder>() {

    private lateinit var binding: ItemEducationBinding

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EducationAdapter.MyViewHolder {
        binding = ItemEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: EducationAdapter.MyViewHolder, position: Int) {
        binding.title.text = list[position].institue
        binding.subtitle.text = list[position].degree
        binding.image.setImageResource(list[position].image)
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
