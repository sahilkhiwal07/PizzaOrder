package com.example.bookmovie.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bookmovie.R
import com.example.bookmovie.ui.Adapters.PizzaAdapter
import com.example.bookmovie.ui.views.PizzaViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private val viewModel: PizzaViewModel by lazy {
        ViewModelProvider(requireActivity()).get(PizzaViewModel::class.java)
    }

    private val adapter: PizzaAdapter by lazy {
        PizzaAdapter(requireContext())
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
        initViewModel()

    }

    private fun setRecyclerView() {
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun initViewModel() {

        viewModel.getPizzaOrder().observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.makeApiCall()

    }

}