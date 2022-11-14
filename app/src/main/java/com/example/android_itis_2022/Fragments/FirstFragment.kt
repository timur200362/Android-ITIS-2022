package com.example.android_itis_2022.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.android_itis_2022.Adapter.GameListAdapter
import com.example.android_itis_2022.Model.Game
import com.example.android_itis_2022.Model.GameRepository
import com.example.android_itis_2022.Model.MainItem
import com.example.android_itis_2022.R
import com.example.android_itis_2022.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var binding: FragmentFirstBinding? = null
    private var adapter: GameListAdapter? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        inflater.inflate(R.layout.fragment_first,container,false)
//        binding=FragmentFirstBinding.inflate(inflater,container,false)
//        return binding?.root

        return FragmentFirstBinding.inflate(inflater, container, false).let {
            binding = it
            it.root
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //val gameAdapter:GameAdapter= GameAdapter(GameRepository.games) {}
        binding = FragmentFirstBinding.bind(view)
        binding?.run {
            adapter = GameListAdapter(
                actionDelete = {
                    GameRepository.games.remove(it)
                    adapter?.submitList(GameRepository.games)
                    adapter?.notifyDataSetChanged()
                },
                glide = Glide.with(this@FirstFragment),
                action = {
                    requireActivity().supportFragmentManager.beginTransaction()
                        .replace(
                            R.id.container,
                            SecondFragment.getInstance(it.id),
                            SecondFragment.TAG
                        )
                        .addToBackStack(FirstFragment_TAG)
                        .commit()
                })
            adapter?.submitList(GameRepository.games)
            team.adapter = adapter

            buttonAction.setOnClickListener {
                val dialog = AddToListDialogFragment()
                dialog.show(requireActivity().supportFragmentManager, "Dialog")
                dialog.add = { position, game ->
                    GameRepository.games.add(position, game)
                    adapter?.submitList(GameRepository.games)
                }
            }
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