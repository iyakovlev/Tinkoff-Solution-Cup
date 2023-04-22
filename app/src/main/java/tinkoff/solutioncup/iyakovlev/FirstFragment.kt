package tinkoff.solutioncup.iyakovlev

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import tinkoff.solutioncup.iyakovlev.screens.SecondScreen
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.android.inject
import tinkoff.solutioncup.iyakovlev.databinding.FragmentFirstBinding
import tinkoff.solutioncup.iyakovlev.rv.DummyAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val router: Router by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            toTheDark.setOnClickListener {
                router.navigateTo(SecondScreen)
            }
            binding.notificationTwo.setOnCloseButtonClickListener {
                Toast.makeText(requireContext(), "Тыц", Toast.LENGTH_SHORT).show()
            }
            binding.notificationLargeOne.setOnButtonClickListener {
                Toast.makeText(requireContext(), "Тыц", Toast.LENGTH_SHORT).show()
            }

            binding.cardOne.setAdapter(DummyAdapter(5))
            binding.cardOne.setOnButtonClickListener {
                Toast.makeText(requireContext(), "Карточка Нижняя кнопка тыц", Toast.LENGTH_SHORT).show()
            }
            binding.cardOne.setOnCornerButtonClickListener {
                Toast.makeText(requireContext(), "Карточка угловая кнопка тыц", Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}