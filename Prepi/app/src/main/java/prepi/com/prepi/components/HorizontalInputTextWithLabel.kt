package prepi.com.prepi.components

import android.content.Context
import android.support.annotation.StyleableRes
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.horizontal_input_text_with_label.view.*
import prepi.com.prepi.R

class HorizontalInputTextWithLabel(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    @StyleableRes
    internal var label = 0
    @StyleableRes
    internal var placeholder = 1

    internal var labelTextView: TextView? = null
    internal var inputTextView: EditText? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        View.inflate(context, R.layout.horizontal_input_text_with_label, this)

        Log.i("Prepiappp", attrs.toString())
        val sets = intArrayOf(
            R.attr.label,
            R.attr.placeholder
        )
        val typedArray = context?.obtainStyledAttributes(attrs, sets)
        Log.i("Prepiappp", " valor do type array ")
        val labelText = typedArray?.getText(label)
        val inputView = typedArray?.getText(placeholder)
        typedArray?.recycle()

        initComponents()

        setLabel(labelText)
        setInputTextView(inputView)
    }

    private fun initComponents() {
        labelTextView = findViewById(R.id.input_label) as TextView

        inputTextView = findViewById(R.id.input_text_editor) as EditText
    }

    fun getLabel(): CharSequence {
        return labelTextView!!.text
    }

    fun setLabel(value: CharSequence?) {
        if (value != null) {
            labelTextView?.text = value
        }
    }

    fun getInputTextView(): EditText? {
        return inputTextView
    }

    fun setInputTextView(value: CharSequence?) {
        if (value != null) {
            inputTextView?.hint = value
        }
    }
}