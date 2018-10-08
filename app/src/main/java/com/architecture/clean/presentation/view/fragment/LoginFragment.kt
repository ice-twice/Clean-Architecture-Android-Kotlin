package com.architecture.clean.presentation.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import com.architecture.clean.R
import com.architecture.clean.presentation.di.component.DaggerLoginComponent
import com.architecture.clean.presentation.view.fragment.interfaces.LoginView
import com.architecture.clean.presentation.view.presenter.LoginPresenter
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

/**
 * Login fragment.
 */
class LoginFragment : BaseFragment(), LoginView {
    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        DaggerLoginComponent.create().inject(this)
        lifecycle.addObserver(loginPresenter.viewLifecycleObserver)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loginPresenter.bindView(this, viewLifecycleOwner)
        viewLifecycleOwner.lifecycle.addObserver(loginPresenter.viewLayoutLifecycleObserver)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        password.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                loginPresenter.clickLoginButton(email.text.toString(), password.text.toString())
                return@setOnEditorActionListener true
            }
            false
        }
        email_sign_in_button.setOnClickListener { loginPresenter.clickLoginButton(email.text.toString(), password.text.toString()) }
    }


    override fun showLoading() {

        println("qwerty showLoading()")

        login_progress.visibility = View.VISIBLE
        login_form.visibility = View.GONE
    }

    override fun hideLoading() {
        println("qwerty hideLoading()")


        login_progress.visibility = View.GONE
        login_form.visibility = View.VISIBLE
    }

    override fun showLoginError() {
        println("qwerty showLoginError()")

        Toast.makeText(context, "Login failed!", Toast.LENGTH_LONG).show()
    }

    override fun showMain() {
        println("qwerty showMain()")

        //show main
    }
}