package tinkoff.solutioncup.iyakovlev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tinkoff.solutioncup.iyakovlev.screens.FirstScreen
import com.github.terrakok.cicerone.Router
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.android.ext.android.inject
import tinkoff.solutioncup.iyakovlev.databinding.FragmentBottomSheetBinding

class BottomSheetFragment : BottomSheetDialogFragment(){

    private var _binding: FragmentBottomSheetBinding? = null
    val binding get() = _binding!!
    val router: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding  = FragmentBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonSecond.setOnClickListener {
            router.backTo(FirstScreen)
            dismiss()
        }
    }
}