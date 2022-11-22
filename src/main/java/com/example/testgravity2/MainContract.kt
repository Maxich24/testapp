package com.example.testgravity2

import androidx.lifecycle.LifecycleOwner

interface MainContract  {
    interface Model {
        fun loadMessage(callback: MyCallback)
    }

    interface View : LifecycleOwner {
        fun showProgress()
        fun hideProgress()
        fun showWebView(url: String)
    }

    interface Presenter {
        fun buttonClicked()
    }

    interface MyCallback {
        fun success(url: String?)
        fun failure(t: Throwable?)
    }
}