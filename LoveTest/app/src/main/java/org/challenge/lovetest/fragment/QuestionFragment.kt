package org.challenge.lovetest.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentController
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_question.*

import org.challenge.lovetest.R

/**
 * A simple [Fragment] subclass.
 */
class QuestionFragment : Fragment(), View.OnClickListener {  // interface를 구현하는 방법으로 하면, 여러가지 버튼 클릭에 대하여 편하기 처리할 수 있다.

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        button_next2.setOnClickListener(this) // 구현해 놓은것을 쓰겠다.
    }

    override fun onClick(v: View?) { // interface 구현.
        when(v?.id){ // 버튼의 id에 따라 처리.
            R.id.button_next2 -> {
                navController.navigate(R.id.action_questionFragment_to_selectionFragment)
            }
        }
    }
}
