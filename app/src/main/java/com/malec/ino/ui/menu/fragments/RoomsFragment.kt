package com.malec.ino.ui.menu.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.malec.ino.R
import com.malec.ino.di.Injectable
import com.malec.ino.ui.menu.MenuViewModel
import kotlinx.android.synthetic.main.fragment_rooms.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Inject

@ExperimentalCoroutinesApi
class RoomsFragment: Fragment(), Injectable {
	@Inject
	lateinit var viewModelFactory: ViewModelProvider.Factory

	private val viewModel: MenuViewModel by activityViewModels {
		viewModelFactory
	}

	private val adapter = RoomAdapter()

	override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
		return inflater.inflate(R.layout.fragment_rooms, container, false)
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)

		roomRecycler.adapter = adapter
		roomRecycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

		viewModel.rooms.observe(viewLifecycleOwner, Observer {
			adapter.submitList(it.toList())
		})
	}
}