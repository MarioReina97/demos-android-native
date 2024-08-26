package it.marioreina.demoviews.credits

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import androidx.core.content.ContextCompat.getColor
import com.weredev.binding_ui.convertFromHtml
import com.weredev.binding_ui.viewBinding
import it.marioreina.demoviews.HomeActivity
import it.marioreina.demoviews.R
import it.marioreina.demoviews.base.BaseFragment
import it.marioreina.demoviews.databinding.FragmentCreditsBinding

class CreditsFragment: BaseFragment(R.layout.fragment_credits) {

    private val binding by viewBinding(FragmentCreditsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.txtMessage.movementMethod = LinkMovementMethod.getInstance()
        binding.txtMessage.setLinkTextColor(getColor(requireContext(), R.color.main_500))
        binding.txtMessage.text = getString(R.string.credits_message).convertFromHtml()
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.credits_title))
        (requireActivity() as HomeActivity).showBottomNavBar()
    }
}