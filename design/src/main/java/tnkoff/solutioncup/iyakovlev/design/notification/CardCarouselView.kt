package tnkoff.solutioncup.iyakovlev.design.notification

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import tnkoff.solutioncup.iyakovlev.design.R

class CardCarouselView<T : RecyclerView.ViewHolder> @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var header: String = ""
    private var buttonText: String = ""
    private var cornerButtonText: String = ""
    private var buttonVisible: Boolean = false

    private var headerView: TextView? = null
    private var button: Button? = null
    private var cornerButton: TextView? = null
    private var recyclerView: RecyclerView? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.CardCarouselView) {
            header = getString(R.styleable.CardCarouselView_containerHeader).orEmpty()
            cornerButtonText = getString(R.styleable.CardCarouselView_cornerButtonText).orEmpty()
            buttonText = getString(R.styleable.CardCarouselView_mainButtonText).orEmpty()
            buttonVisible =
                getBoolean(R.styleable.CardCarouselView_mainButtonVisible, false)
        }

        LayoutInflater.from(ContextThemeWrapper(context, R.style.SolutionTheme_Light))
            .inflate(R.layout.layout_card_carousel, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        headerView = findViewById(R.id.header)
        button = findViewById(R.id.button)
        cornerButton = findViewById(R.id.action)
        recyclerView = findViewById(R.id.carouselRecyclerView)
        button?.isVisible = buttonVisible

        setHeader(header)
        setButtonText(buttonText)
        setCornerButtonText(cornerButtonText)
    }

    fun setHeader(title: String) {
        headerView?.text = title
    }

    fun setButtonText(text: String) {
        button?.text = text
    }

    fun setCornerButtonText(text: String) {
        cornerButton?.text = text
    }

    fun setOnButtonClickListener(onClick: (View) -> Unit) {
        button?.setOnClickListener(onClick)
    }

    fun setOnCornerButtonClickListener(onClick: (View) -> Unit) {
        cornerButton?.setOnClickListener(onClick)
    }

    fun setAdapter(adapter: RecyclerView.Adapter<T>) {
        recyclerView?.adapter = adapter
    }
}
