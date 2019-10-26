package com.example.forecastapplication

import android.app.Application
import com.example.forecastapplication.data.ApixuWeatherApiService
import com.example.forecastapplication.data.db.ForecastDatabase
import com.example.forecastapplication.data.network.ConnectiviryInterceptorImplementer
import com.example.forecastapplication.data.network.ConnectivityInterceptor
import com.example.forecastapplication.data.network.WeatherNetworkDataSource
import com.example.forecastapplication.data.network.response.WeatherNetworkDataSourceImplementator
import com.example.forecastapplication.data.repository.ForecastRepository
import com.example.forecastapplication.data.repository.ForecastRepositoryImplementer
import com.example.forecastapplication.ui.weather.current.CurrentWeatherViewModelFactory
import com.jakewharton.threetenabp.AndroidThreeTen
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind<ConnectivityInterceptor>() with singleton { ConnectiviryInterceptorImplementer(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImplementator(instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImplementer(instance(), instance()) }
        bind() from  provider { CurrentWeatherViewModelFactory(instance()) }
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
    }
}