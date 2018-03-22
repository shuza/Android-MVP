package me.shuza.android_mvp.fetures

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.shuza.android_mvp.base.BasePresenter
import me.shuza.android_mvp.networkIO.ApiService
import javax.inject.Inject

/**
 *
 * :=  created by:  Shuza
 * :=  create date:  3/23/2018
 * :=  (C) CopyRight Shuza
 * :=  www.shuza.me
 * :=  shuza.sa@gmail.com
 * :=  Fun  :  Coffee  :  Code
 *
 **/
class MainActivityPresenter<V : MainActivityMvpView> @Inject constructor(var apiService: ApiService)
    : BasePresenter<V>(), MainActivityMvpPresenter<V> {

    override fun fetchDataFromNetwork() {
        mvpView?.get()?.showLoadingDialog()
        apiService.getDataList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    mvpView?.get()?.dismissLoadingDialog()
                    mvpView?.get()?.showData(it)
                }, {
                    mvpView?.get()?.dismissLoadingDialog()
                    mvpView?.get()?.showErrorMessage("Failed")
                })
    }
}