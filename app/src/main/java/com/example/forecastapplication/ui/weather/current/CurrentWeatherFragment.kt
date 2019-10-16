package com.example.forecastapplication.ui.weather.current

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.forecastapplication.R
import com.example.forecastapplication.data.ApixuWeatherApiService
import com.example.forecastapplication.data.network.ConnectiviryInterceptorImplementator
import com.example.forecastapplication.data.network.response.WeatherNetworkDataSourceImplementator
import kotlinx.android.synthetic.main.current_weather_fragment.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CurrentWeatherFragment : Fragment() {

    companion object {
        fun newInstance() =
            CurrentWeatherFragment()
    }

    private lateinit var viewModel: CurrentWeatherViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.current_weather_fragment, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CurrentWeatherViewModel::class.java)
        // TODO: Use the ViewModel

        val apiService = ApixuWeatherApiService(ConnectiviryInterceptorImplementator(this.context!!))
        val weatherNetworkDataSource = WeatherNetworkDataSourceImplementator(apiService)

        weatherNetworkDataSource.downloadedCurrentWeather.observe(this, Observer {
            current_weather_text.text = it.toString()
        })


        GlobalScope.launch(Dispatchers.Main){
           weatherNetworkDataSource.fetchCurrentWeather("London", "en")
        }
    }

}
