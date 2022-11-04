package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.net.toUri
import com.bumptech.glide.Glide
import com.example.android_itis_2022.databinding.FragmentSecondBinding


private const val DESCRIPTION_PARAM = "description_param"


class SecondFragment : Fragment() {
    private var binding: FragmentSecondBinding? = null
    private var param: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param = it.getString(DESCRIPTION_PARAM)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_second, container, false)
        return FragmentSecondBinding.inflate(inflater,container,false).let{
            binding=it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding= FragmentSecondBinding.bind(view)
        binding?.run {
            context?.let { Glide.with(it).load(GameRepository.games[param!!.toInt()].cover.toUri()).into(imageGame) }
            inputName.text = GameRepository.games[param!!.toInt()].name
            inputReleaseDate.text= GameRepository.games[param!!.toInt()].releaseDate
            inputDescription.text= GameRepository.games[param!!.toInt()].descriptionGame
        }
    }
    companion object {
        const val TAG = "SecondFragment_TAG"
        fun getInstance(description: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(DESCRIPTION_PARAM,description)
                }
            }
    }
}