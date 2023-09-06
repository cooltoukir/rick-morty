package com.example.rickmorty.characterlist

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.rickmorty.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharacterListScreen : Fragment() {

    private val viewModel by viewModels<CharacterViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_character_list_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.list.observe(viewLifecycleOwner) {
            //characterPagingAdapter.submitData(lifecycle, it)
            Log.d("Toukir", "onViewCreated: ${it.toString()}")
        }
    }
}