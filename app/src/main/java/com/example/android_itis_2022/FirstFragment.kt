package com.example.android_itis_2022

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_itis_2022.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
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
        val gameAdapter:GameAdapter= GameAdapter(GameRepository.games) {}
        binding=FragmentFirstBinding.bind(view)
        binding?.run {
            team.adapter=gameAdapter
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