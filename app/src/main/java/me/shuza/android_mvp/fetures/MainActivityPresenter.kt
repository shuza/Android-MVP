package me.shuza.android_mvp.fetures

import com.orhanobut.logger.Logger
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import me.shuza.android_mvp.base.BasePresenter
import me.shuza.android_mvp.models.StudentModel
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
        mvpView?.showLoadingDialog()
        apiService.getDataList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<List<StudentModel>> {
                    override fun onComplete() {}

                    override fun onSubscribe(d: Disposable) {}

                    override fun onNext(t: List<StudentModel>) {
                        mvpView?.dismissLoadingDialog()
                        mvpView?.showData(t)
                    }

                    override fun onError(e: Throwable) {
                        Logger.e("Error:  ${e.message}")
                        mvpView?.dismissLoadingDialog()
                        mvpView?.showErrorMessage("Failed")
                    }
                })
    }
}