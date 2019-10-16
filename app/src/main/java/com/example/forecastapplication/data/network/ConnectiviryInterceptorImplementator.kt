package com.example.forecastapplication.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import okhttp3.Interceptor
import okhttp3.Response

class ConnectiviryInterceptorImplementator(
    context: Context
) : ConnectivityInterceptor {

    private val appContext = context.applicationContext


    override fun intercept(chain: Interceptor.Chain): Response {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun isOnline(): Boolean {
        val connectivityManager = appContext.getSystemService(Context.CONNECTIVITY_SERVICE)
                as ConnectivityManager

        if (connectivityManager != null) {
            if (Build.VERSION.SDK_INT < 23) {
                val networkInfo = connectivityManager.activeNetworkInfo

                networkInfo?.let {
                    return it.isConnected
                }

            } else {
                val networkActive = connectivityManager.activeNetwork
                networkActive.let {
                    val networkCapabilities = connectivityManager.getNetworkCapabilities(it)
                    return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)
                            || networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
                }

            }


        }
        return false
    }
}
