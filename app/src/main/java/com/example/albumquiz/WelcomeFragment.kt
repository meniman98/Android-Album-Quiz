package com.example.albumquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.albumquiz.databinding.FragmentWelcomeBinding


class WelcomeFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val binding: FragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome, container, false
        )

        binding.btnPlay.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToGameFragment())
        }



        return binding.root


    }


}
