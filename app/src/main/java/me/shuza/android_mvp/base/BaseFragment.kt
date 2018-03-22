package me.shuza.android_mvp.base

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import dmax.dialog.SpotsDialog
import me.shuza.android_mvp.R
import me.shuza.android_mvp.injection.components.DaggerFragmentComponent
import me.shuza.android_mvp.injection.components.FragmentComponent
import me.shuza.android_mvp.injection.modules.FragmentModule
import me.shuza.android_mvp.injection.modules.NetworkModule
import org.jetbrains.anko.support.v4.toast
import kotlin.properties.Delegates

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/22/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
open class BaseFragment : Fragment(), BaseMvpView {

    var dialog: AlertDialog by Delegates.notNull()
    val fragmentComponent: FragmentComponent by lazy {
        DaggerFragmentComponent.builder()
                .fragmentModule(FragmentModule(this))
                .networkModule(NetworkModule())
                .activityComponent((activity as BaseActivity).activityComponent)
                .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dialog = SpotsDialog(activity, R.style.LoadingDialog)
        dialog.setCancelable(false)
    }

    override fun isNetworkAvailable(): Boolean {
        val connectivityManager = activity!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return (networkInfo != null && networkInfo.isConnectedOrConnecting)
    }

    override fun showLoadingDialog() {
        if (!dialog.isShowing) {
            dialog.show()
        }
    }

    override fun dismissLoadingDialog() {
        if (dialog.isShowing) {
            dialog.dismiss()
        }
    }

    override fun showSuccessMessage(message: String) {
        toast(message)
    }

    override fun showErrorMessage(message: String) {
        toast(message)
    }

    override fun getResourceText(id: Int): String {
        return activity.resources.getString(id)
    }
}