package com.app.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.demo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_next.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import androidx.lifecycle.Observer

class NextFragment : Fragment() {

    private val userDetailsViewModel: MainViewModel by sharedViewModel()
    private lateinit var mActivity: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_next, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as MainActivity
        userDetailsViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                loadEndPoint.loadUrl(it.next)
            }
        })

        gotoBack.setOnClickListener {
            findNavController().navigate(R.id.action_NextFragment_to_MainFragment)
        }
    }


}