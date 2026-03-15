package br.com.denisecastro.taskapp.navigation

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.denisecastro.taskapp.R

fun Fragment.navigateWithAction(actionId: Int) {
    findNavController().navigate(actionId)
}

fun Fragment.navToLogin() {
    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
}

fun Fragment.navToRegister() {
    findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
}

fun Fragment.navToRecover() {
    findNavController().navigate(R.id.action_loginFragment_to_recoverAccountFragment)
}