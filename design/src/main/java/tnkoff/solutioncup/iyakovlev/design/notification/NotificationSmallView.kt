package tnkoff.solutioncup.iyakovlev.design.notification

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import tnkoff.solutioncup.iyakovlev.design.R

class NotificationSmallView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var title: String = ""
    private var description: String = ""
    private var imageRes: Drawable? = null
    private var closeButtonVisible: Boolean = false

    private var titleView: TextView? = null
    private var descriptionView: TextView? = null
    private var imageView: ImageView? = null
    private var closeButton: ImageView? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.NotificationSmallView) {
            title = getString(R.styleable.NotificationSmallView_title).orEmpty()
            description = getString(R.styleable.NotificationSmallView_description).orEmpty()
            imageRes = getDrawable(R.styleable.NotificationSmallView_icon)
            closeButtonVisible =
                getBoolean(R.styleable.NotificationSmallView_closeButtonVisible, false)
        }



        if (closeButtonVisible) {
            LayoutInflater.from(ContextThemeWrapper(context, R.style.SolutionTheme_Light))
        } else {
            LayoutInflater.from(context)
        }.inflate(R.layout.layout_notification_small, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        titleView = findViewById(R.id.title)
        descriptionView = findViewById(R.id.subtitle)
        imageView = findViewById(R.id.image)
        closeButton = findViewById(R.id.close_button)
        closeButton?.isVisible = closeButtonVisible

        setTitle(title)
        setDescription(description)
        imageView?.setImageDrawable(imageRes)
    }

    fun setTitle(title: String) {
        titleView?.text = title
    }

    fun setDescription(description: String) {
        descriptionView?.text = description
    }

    fun setImage(@DrawableRes drawableRes: Int) {
        imageView?.setImageResource(drawableRes)
    }

    fun setOnCloseButtonClickListener(onClick: (View) -> Unit) {
        closeButton?.setOnClickListener(onClick)
    }
}
