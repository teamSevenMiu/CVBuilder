package com.example.cvbuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.FragmentHomeBinding
import com.example.cvbuilder.databinding.ItemHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.imageView.setImageResource(DataService.default.home.image)
        binding.skillTitle.text = DataService.default.home.name
        binding.role.text = DataService.default.home.role
        binding.recv.adapter = SkillAdapter(DataService.default.home.skills)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
class SkillAdapter(var list: HashMap<String,String>) : RecyclerView.Adapter<SkillAdapter.MyViewHolder>() {

    private lateinit var binding: ItemHomeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillAdapter.MyViewHolder {
        binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SkillAdapter.MyViewHolder, position: Int) {
        val title=list.keys.toTypedArray()[position]
        binding.skillTitle.text = title
        binding.skillDetails.text = list[title]
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}