package com.example.cvbuilder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.cvbuilder.databinding.FragmentAboutBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AboutFragment : Fragment() {

    private var _binding: FragmentAboutBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAboutBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        binding.pager.adapter = AboutPagerAdapter(requireActivity())
        binding.tab.tabGravity = TabLayout.GRAVITY_FILL

        TabLayoutMediator(binding.tab, binding.pager){tab,position->
            when(position){
                0->{
                    tab.text="Introduction"
                }
                1->{
                    tab.text="Education"
                }
                2->{
                    tab.text="Certification"
                }
            }
        }.attach()
    }
}



class AboutPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int  = 3

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0->IntroFragment()
            1->EducationFragment()
            2->CertificationFragment()
            else-> Fragment()
        }
    }
}
