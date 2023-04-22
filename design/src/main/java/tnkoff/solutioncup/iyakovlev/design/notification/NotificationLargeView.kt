package tnkoff.solutioncup.iyakovlev.design.notification

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.core.content.withStyledAttributes
import androidx.core.view.isVisible
import tnkoff.solutioncup.iyakovlev.design.R

class NotificationLargeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private var header: String = ""
    private var subheader: String = ""
    private var buttonText: String = ""
    private var imageRes: Drawable? = null
    private var buttonVisible: Boolean = false

    private var headerView: TextView? = null
    private var subheaderView: TextView? = null
    private var imageView: ImageView? = null
    private var button: Button? = null

    init {
        context.withStyledAttributes(attrs, R.styleable.NotificationLargeView) {
            header = getString(R.styleable.NotificationLargeView_header).orEmpty()
            subheader = getString(R.styleable.NotificationLargeView_subheader).orEmpty()
            buttonText = getString(R.styleable.NotificationLargeView_butttonText).orEmpty()
            imageRes = getDrawable(R.styleable.NotificationLargeView_icon)
            buttonVisible =
                getBoolean(R.styleable.NotificationLargeView_buttonVisible, false)
        }
            LayoutInflater.from(context).inflate(R.layout.layout_notification_large, this, true)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        headerView = findViewById(R.id.header)
        subheaderView = findViewById(R.id.subheader)
        imageView = findViewById(R.id.image)
        button = findViewById(R.id.button)
        button?.isVisible = buttonVisible

        setHeader(header)
        setSubheader(subheader)
        setButtonText(buttonText)
        imageView?.setImageDrawable(imageRes)
    }

    fun setHeader(title: String) {
        headerView?.text = title
    }

    fun setSubheader(description: String) {
        subheaderView?.run {
            isVisible = description.isNotEmpty()
            text = description
        }
    }

    fun setButtonText(text: String) {
        button?.text = text
    }

    fun setOnButtonClickListener(onClick: (View) -> Unit) {
        button?.setOnClickListener(onClick)
    }
}
