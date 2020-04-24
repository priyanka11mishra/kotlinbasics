package com.example.diceapplication

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
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
            val args=GameWinArgs.fromBundle(arguments!!)
            Toast.makeText(context,"NumCorrectAnswers:${args.numCorrect},NumQuestions:${args.numQuestion}",Toast.LENGTH_LONG).show()
            view.findNavController().navigate(GameWinDirections.actionGameWinToGamePFragment())


        }

        setHasOptionsMenu(true)
        return binding.root
    }
    private fun getshareIntent():Intent{
        val args=GameWinArgs.fromBundle(arguments!!)
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestion))
        return shareIntent
    }

    private fun sharesuccess(){
        startActivity(getshareIntent())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.win_menu,menu)
        if (null == getshareIntent().resolveActivity(activity!!.packageManager)) {
            // hide the menu item if it doesn't resolve
            menu?.findItem(R.id.share)?.setVisible(false)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item!!.itemId)
        {
            R.id.share->sharesuccess()

        }
        return super.onOptionsItemSelected(item)
    }
}
