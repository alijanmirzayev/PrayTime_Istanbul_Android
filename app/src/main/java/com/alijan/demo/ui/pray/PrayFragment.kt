package com.alijan.demo.ui.pray

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.alijan.demo.databinding.FragmentPrayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrayFragment : Fragment() {
    private var _binding: FragmentPrayBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<PrayViewModel>()
    private val args: PrayFragmentArgs by navArgs()
    private val prayAdapter = PrayAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPrayBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestApi()
        observeData()
        setAdapter()
    }

    private fun requestApi() {
        viewModel.getPrayDate(args.city)
    }

    private fun setAdapter() {
        binding.rvPray.adapter = prayAdapter
    }

    private fun observeData() {
        viewModel.pray.observe(viewLifecycleOwner) {
            prayAdapter.updateList(it)
        }
        viewModel.loading.observe(viewLifecycleOwner) {

        }
        viewModel.error.observe(viewLifecycleOwner) {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}