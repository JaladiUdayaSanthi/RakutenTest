package com.app.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.app.demo.viewmodel.MainViewModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_details.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class DetailsFragment : Fragment() {

    private val userDetailsViewModel: MainViewModel by sharedViewModel()
    private lateinit var mActivity: MainActivity

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mActivity = activity as MainActivity
        val data  = userDetailsViewModel.getItemData()

        data.let {
            Glide.with(mActivity)
                    .load(it.owner.links.avatar)
                    .placeholder(R.drawable.default_image)
                    .error(R.drawable.image_not_found)
                    .into(ivImage)
            tvName.text = "Name: "+it.name
            tvType.text = "Type: "+it.type
            tvDate.text = "Date: "+ getFormattedDate(it.createdOn)
        }

        gotoBack.setOnClickListener {
            findNavController().navigate(R.id.action_DetailsFragment_to_MainFragment)
        }
    }

    private fun getFormattedDate(dateStr: String): String {
        val str = dateStr.split("T")
        return str[0]
    }


}