package it.marioreina.demoviews.deal

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.weredev.binding_ui.viewBinding
import com.weredev.usecase.observeWithResource
import it.marioreina.demoviews.HomeActivity
import it.marioreina.demoviews.R
import it.marioreina.demoviews.base.BaseFragment
import it.marioreina.demoviews.databinding.FragmentDealBinding
import it.marioreina.demoviews.firstaccess.FirstAccessDialog
import it.marioreina.demoviews.utils.DealConst
import org.koin.androidx.viewmodel.ext.android.viewModel

class DealFragment : BaseFragment(R.layout.fragment_deal) {

    private val binding by viewBinding(FragmentDealBinding::bind)

    private val dealViewModel: DealViewModel by viewModel()

    private val dealAdapter: DealAdapter by lazy {
        DealAdapter {
            val bundle = Bundle()
            bundle.putString(DealConst.ARGS_DEAL_ID, it.dealID)
            findNavController().navigate(R.id.nav_deal_detail, bundle)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
        dealViewModel.isFirstAccess()
        dealViewModel.getDeals()
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.deals))
        (requireActivity() as HomeActivity).showBottomNavBar()
    }

    private fun initView() {
        binding.rvDeals.adapter = dealAdapter
    }

    private fun initObserver() {
        dealViewModel.dealEntityListLiveData.observeWithResource(this) {
            if(it != null) {
                dealAdapter.submitList(it)
            }
        }
        dealViewModel.isFirstAccessLiveData.observeWithResource(this) {
            if(it != null) {
                if(!it) {
                    FirstAccessDialog().show(this.parentFragmentManager, null)
                }
            }
        }
    }

    override fun onLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading
    }

    override fun onPause() {
        super.onPause()
        dealViewModel.dealEntityListLiveData.value = null
        dealViewModel.isFirstAccessLiveData.value = null
    }
}