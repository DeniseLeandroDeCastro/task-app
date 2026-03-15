package br.com.denisecastro.taskapp.ui.auth

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import br.com.denisecastro.taskapp.R
import br.com.denisecastro.taskapp.databinding.FragmentLoginBinding
import br.com.denisecastro.taskapp.navigation.navToRecover
import br.com.denisecastro.taskapp.navigation.navToRegister
import br.com.denisecastro.taskapp.ui.viewmodel.LoginViewModel

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClicks()
        setupPasswordVisibility()
    }
    private fun initClicks() {
        binding.buttonLogin.setOnClickListener {
            binding.editTextEmail.text.toString()
            binding.editTextPassword.text.toString()
        }
        binding.textCreateAccount.setOnClickListener {
            navToRegister()
        }
        binding.textRecoverAccount.setOnClickListener {
            navToRecover()
        }
    }
    @SuppressLint("ClickableViewAccessibility")
    private fun setupPasswordVisibility() {
        binding.editTextPassword.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_UP) {
                val drawableRight = 2
                val iconWidth = binding.editTextPassword.compoundDrawables[drawableRight].bounds.width()
                if (event.rawX >= (binding.editTextPassword.right - iconWidth - 50)) {
                    val selection = binding.editTextPassword.selectionEnd
                    val isPasswordVisible = binding.editTextPassword.transformationMethod == null

                    if (isPasswordVisible) {
                        binding.editTextPassword.transformationMethod = PasswordTransformationMethod()
                        binding.editTextPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_eye, 0)
                    } else {
                        binding.editTextPassword.transformationMethod = null
                        binding.editTextPassword.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_eye_off, 0)
                    }
                    binding.editTextPassword.setSelection(selection)
                    return@setOnTouchListener true
                }
            }
            false
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}