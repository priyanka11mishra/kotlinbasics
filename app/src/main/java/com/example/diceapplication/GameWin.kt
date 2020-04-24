package com.example.diceapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.diceapplication.databinding.FragmentGameWinBinding

/**
 * A simple [Fragment] subclass.
 */
class GameWin : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_game_win, container, false)
        val binding:FragmentGameWinBinding=DataBindingUtil.inflate(inflater,R.layout.fragment_game_win,container,false)

        binding.nextMatchButton.setOnClickListener { view:View->
            view.findNavController().navigate(R.id.action_gameWin_to_gamePFragment)
        }
        return binding.root
    }

}
