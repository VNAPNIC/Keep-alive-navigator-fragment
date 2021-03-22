package com.vnapnic.keepalivenavigator

import android.content.Context
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.widget.FrameLayout
import androidx.annotation.LayoutRes
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.Navigation
import androidx.navigation.plusAssign

class KeepAliveNavigationHost @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : FrameLayout(context, attrs, defStyleAttr), NavHost {
    private val navigationController = NavController(context)

    @LayoutRes
    var layoutId: Int = 0

    init {
        context.resources.obtainAttributes(attrs, R.styleable.NavHost).apply {
            layoutId = getResourceId(R.styleable.NavHost_navGraph, 0)
            recycle()
        }

        val themeWrapper: ContextThemeWrapper = getContext() as ContextThemeWrapper

        val navigator = when (themeWrapper.baseContext) {
            is FragmentActivity -> {
                KeepAliveNavigator(
                    context,
                    (themeWrapper.baseContext as FragmentActivity).supportFragmentManager,
                    this@KeepAliveNavigationHost.id
                )
            }
            else -> {
                null
            }
        }

        navigator?.let {
            navController.navigatorProvider += navigator
            navController.setGraph(layoutId)
            Navigation.setViewNavController(this, navController)
        }
    }

    override fun getNavController(): NavController = navigationController

}