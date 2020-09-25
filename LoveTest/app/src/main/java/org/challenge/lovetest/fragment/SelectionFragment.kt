package org.challenge.lovetest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_selection.*

import org.challenge.lovetest.R

/**
 * A simple [Fragment] subclass.
 */
class SelectionFragment : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        button_back.setOnClickListener(this)
        option1.setOnClickListener(this)
        option2.setOnClickListener(this)
        option3.setOnClickListener(this)
        option4.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.option1 -> {navigateWithIndex(1)}
            R.id.option2 -> {navigateWithIndex(2)}
            R.id.option3 -> {navigateWithIndex(3)}
            R.id.option4 -> {navigateWithIndex(4)}
            R.id.button_back -> {
                navController.popBackStack() // 뒤로 갈때는 스택에 있는 것을 하나 pop 해주면 된다.
            }

        }
    }

    fun navigateWithIndex(index: Int){
        var bundle = bundleOf("index" to index)
        navController.navigate(R.id.action_selectionFragment_to_resultFragment, bundle)
    }

}
