package com.app.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.navigation.fragment.findNavController
import com.app.demo.adapter.ListAdapter
import com.app.demo.component.ItemOffsetDecoration
import com.app.demo.data.ResponseList
import com.app.demo.data.Value
import com.app.demo.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_main.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class MainFragment : Fragment() {

    private val userDetailsViewModel: MainViewModel by sharedViewModel()
    private lateinit var mActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as MainActivity
        fetchData()
    }

    private fun fetchData() {
        userDetailsViewModel.response.observe(viewLifecycleOwner, Observer {
            it?.let {
                val adapter = ListAdapter(mActivity,it.values)
                val itemDecoration = ItemOffsetDecoration(mActivity, R.dimen.item_offset)
                rvList.addItemDecoration(itemDecoration)
                rvList.apply {
                    layoutManager = LinearLayoutManager(mActivity)
                }
                rvList.adapter = adapter

                adapter.setOnItemClickListener(object : ListAdapter.OnItemClickListener {
                    override fun onClick(view: View, data: Value)
                    {
                        userDetailsViewModel.updateItemData(data)
                        findNavController().navigate(R.id.action_MainFragment_to_DetailsFragment)
                    }
                })
            }
        })

        gotoEndpoint.setOnClickListener {
            findNavController().navigate(R.id.action_MainFragment_to_NextFragment)
        }
    }





}


