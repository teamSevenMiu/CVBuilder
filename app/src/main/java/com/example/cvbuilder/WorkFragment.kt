package com.example.cvbuilder

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.FragmentWorkBinding
import com.example.cvbuilder.databinding.ItemWorkBinding


class WorkFragment : Fragment() {

    private var _binding: FragmentWorkBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = WorkAdapter(DataService.default.workExperience,requireContext())
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

class WorkAdapter(var list: ArrayList<WorkExperience>,var context: Context) : RecyclerView.Adapter<WorkAdapter.MyViewHolder>() {

    private lateinit var binding: ItemWorkBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkAdapter.MyViewHolder {
        binding = ItemWorkBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: WorkAdapter.MyViewHolder, position: Int) {
        binding.title.text = list[position].position
        binding.subtitle.text = list[position].name
        binding.body.text = "${list[position].start} - ${list[position].end}"
        binding.subbody.text = list[position].location
        binding.footer.text = list[position].responsibilty
        binding.image.setImageResource(list[position].image)

        holder.itemView.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(list[position].url))
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}