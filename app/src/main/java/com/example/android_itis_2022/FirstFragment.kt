package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android_itis_2022.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    private var adapter:GameAdapter?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentFirstBinding.inflate(inflater,container,false).let{
            binding=it
            it.root
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val gameAdapter:GameAdapter= GameAdapter(GameRepository.games) {}
        binding=FragmentFirstBinding.bind(view)
        binding?.run {
            adapter=GameAdapter(GameRepository.games,
            glide = Glide.with(this@FirstFragment)){
                root.showSnackbar(it.name)
            }
            team.adapter=adapter
            }
        }
    companion object {
        const val FirstFragment_TAG = "FirstFragment_TAG"
        fun getInstance(bundle: Bundle?): FirstFragment {
            val firstFragment = FirstFragment()
            firstFragment.arguments = bundle
            return firstFragment
        }
    }
}