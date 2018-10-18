package com.architecture.clean.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.architecture.clean.R
import com.architecture.clean.presentation.di.component.DaggerLoginComponent
import com.architecture.clean.presentation.view.interfaces.LoginView
import com.architecture.clean.presentation.presenter.LoginPresenter
import com.architecture.clean.presentation.view.util.AndroidUtil
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Login fragment.
 */
class LoginFragment : BaseFragment(), LoginView {
    @Inject
    lateinit var loginPresenter: LoginPresenter
    @Inject
    lateinit var androidUtil: AndroidUtil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true

        DaggerLoginComponent.builder()
                .schedulerModule(getModuleProvider().schedulerModule)
                .androidUtilModule(getModuleProvider().androidUtilModule)
                .build()
                .inject(this)

        // observe fragment lifecycle
        lifecycle.addObserver(loginPresenter.viewLifecycleObserver)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // the first method where it is safe to access the view lifecycle is onCreateView()
        loginPresenter.bindView(this, viewLifecycleOwner)
        // observe the fragment layout lifecycle
        viewLifecycleOwner.lifecycle.addObserver(loginPresenter.viewLayoutLifecycleObserver)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        password_field.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                loginPresenter.clickLoginButton(login_field.text.toString(), password_field.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }
        sign_button.setOnClickListener { loginPresenter.clickLoginButton(login_field.text.toString(), password_field.text.toString()) }
    }


    override fun showLoading() {
        login_progress.visibility = View.VISIBLE
        login_form.visibility = View.GONE
    }

    override fun hideLoading() {
        login_progress.visibility = View.GONE
        login_form.visibility = View.VISIBLE
    }

    override fun showLoginError() {
        Toast.makeText(context, "Login failed!", Toast.LENGTH_LONG).show()
    }

    override fun showMain() {
        //show main
    }

    override fun hideKeyboard() {
        androidUtil.hideKeyboard(context, view)
    }
}