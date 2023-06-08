package com.naumenko.weatherapp.presentation.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.naumenko.weatherapp.databinding.FragmentWeatherBinding
import com.naumenko.weatherapp.domain.model.WeatherData
import com.naumenko.weatherapp.presentation.LoadEvent
import com.naumenko.weatherapp.presentation.SaveEvent
import com.naumenko.weatherapp.presentation.viewmodel.WeatherViewModel

class WeatherFragment : Fragment(), MavericksView {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!

    private val viewModel: WeatherViewModel by fragmentViewModel()

    override fun invalidate() {
        withState(viewModel) {
            binding.weatherFragmentProgress.isVisible = it.result is Loading
            when (it.result) {
                is Success -> {
                    renderStateText(it.result.invoke())
                    renderStateIcon(it.result.invoke().conditionIcon,binding.weatherFragmentImageView)
                    renderStateIconRes(it.result.invoke().windIcon,binding.weatherFragmentImageViewWind)
                    renderStateIconRes(it.result.invoke().dropIcon,binding.weatherFragmentImageViewDrop)
                    renderStateIcon(it.result.invoke().conditionIconToday,binding.weatherFragmentImageViewToday)
                    renderStateIcon(it.result.invoke().conditionIconTomorrow,binding.weatherFragmentImageViewTomorrow)
                    renderStateIcon(it.result.invoke().conditionIconAfterTomorrow,binding.weatherFragmentImageViewAfterTomorrow)
                }
                is Fail -> {
                    Toast.makeText(
                        requireContext(),
                        "Try Again",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {}
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.send(LoadEvent())
        setupListeners()
    }

    private fun setupListeners() {
        binding.weatherFragmentEditText.setOnEditorActionListener{ _,action,_->
            if (action == EditorInfo.IME_ACTION_SEARCH && binding.weatherFragmentEditText.text.toString().isNotBlank()){
                viewModel.send(SaveEvent(cityName = binding.weatherFragmentEditText.text.toString()))
                hideKeyboard()
                binding.weatherFragmentEditText.clearFocus()
                return@setOnEditorActionListener true
            }
            hideKeyboard()
            binding.weatherFragmentEditText.clearFocus()
            return@setOnEditorActionListener false
        }
    }

    private fun hideKeyboard(){
        val inputMethodManager = requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(binding.weatherFragmentEditText.windowToken, 0)
    }

    private fun renderStateText(state: WeatherData){
        with(binding){
            weatherFragmentTextViewTime.text = state.time
            weatherFragmentTextViewDate.text = state.data
            weatherFragmentTextViewCity.text = state.cityName
            weatherFragmentTextViewTemp.text = state.temperature
            weatherFragmentTextViewCondition.text = state.condition
            weatherFragmentTextViewWind.text = state.wind
            weatherFragmentTextViewDrop.text = state.drop
            weatherFragmentTempToday.text = state.tempToday
            weatherFragmentTextToday.text = state.today
            weatherFragmentTempTomorrow.text = state.tempTomorrow
            weatherFragmentTextTomorrow.text = state.tomorrow
            weatherFragmentTempAfterTomorrow.text = state.tempAfterTomorrow
            weatherFragmentTextAfterTomorrow.text = state.afterTomorrow
        }
    }

    private fun renderStateIconRes(path:Int,view: ImageView){
        view.setImageResource(path)
    }

    private fun renderStateIcon(path:String?,view: ImageView){
        Glide.with(requireContext())
            .load(path)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.NONE)
            .skipMemoryCache(true)
            .into(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}