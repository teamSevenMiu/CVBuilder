package com.example.cvbuilder

import android.app.ActionBar.LayoutParams
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Space
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.view.marginLeft
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cvbuilder.databinding.FragmentHomeBinding
import com.example.cvbuilder.databinding.ItemHomeBinding
import com.google.android.material.snackbar.Snackbar


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

        binding.recv.layoutManager = LinearLayoutManager(requireContext())
        binding.recv.adapter = SkillAdapter(DataService.default.home.skills)

        binding.floatingButton.setOnClickListener{
            showAddAlert()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun showAddAlert(){

        val alert: AlertDialog.Builder = AlertDialog.Builder(requireContext())
        alert.setTitle("Add Skills")

        val layout = LinearLayout(requireContext())
        layout.orientation = LinearLayout.VERTICAL


        var titleText = EditText(requireContext())
        titleText.hint = "input skill type..."
        titleText.left = 20
        layout.addView(titleText)

        val titleParams = titleText.layoutParams as ViewGroup.MarginLayoutParams
        titleParams.setMargins(50,50,50,50)
        titleText.layoutParams = titleParams

        val subtitleText = EditText(requireContext())
        subtitleText.left = 20
        subtitleText.hint = "input all related skills..."
        layout.addView(subtitleText)

        val subtitleParams = subtitleText.layoutParams as ViewGroup.MarginLayoutParams
        subtitleParams.setMargins(50,50,50,50)
        subtitleText.layoutParams = subtitleParams

        alert.setView(layout)

        alert.setPositiveButton("Save",
            DialogInterface.OnClickListener { dialog, whichButton ->

                DataService.default.home.skills.add(Skills(titleText.text.toString(),subtitleText.text.toString()))
                binding.recv.adapter?.notifyItemInserted(DataService.default.home.skills.size - 1);
                val snack = Snackbar.make(binding.floatingButton,"New Skill Added",Snackbar.LENGTH_LONG)
                snack.show()
            })

        alert.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, whichButton ->
                // what ever you want to do with No option.
            })

        alert.show()
    }
}
class SkillAdapter(var list: ArrayList<Skills>) : RecyclerView.Adapter<SkillAdapter.MyViewHolder>() {

    private lateinit var binding: ItemHomeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillAdapter.MyViewHolder {
        binding = ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: SkillAdapter.MyViewHolder, position: Int) {
        binding.skillTitle.text = list[position].title
        binding.skillDetails.text =  list[position].subtitle
    }

    override fun getItemCount() = list.size

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}