package com.example.cvbuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cvbuilder.databinding.FragmentIntroBinding


class IntroFragment : Fragment() {

    private var _binding: FragmentIntroBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentIntroBinding.inflate(inflater, container, false)
        binding.subtitle.text = DataService.default.about.intro
        return binding.root
    }


}