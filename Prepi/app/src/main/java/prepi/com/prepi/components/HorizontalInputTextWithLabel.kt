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
    @StyleableRes
    internal var dropdown = 2
    @StyleableRes
    internal var dropdownItens = 3

    internal var labelTextView: TextView? = null
    internal var inputTextView: EditText? = null
    internal var dropdownView: AppCompatSpinner? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        View.inflate(context, R.layout.horizontal_input_text_with_label, this)

        Log.i("Prepiappp", attrs.toString())
        val sets = intArrayOf(
            R.attr.label,
            R.attr.placeholder,
            R.attr.dropdown_value,
            R.attr.dropdown_itens
        )
        val typedArray = context?.obtainStyledAttributes(attrs, sets)
        Log.i("Prepiappp", " valor do type array ")
        val labelText = typedArray?.getText(label)
        val inputView = typedArray?.getText(placeholder)
        val dropdownValor = typedArray?.getBoolean(dropdown, false)
        val dropdownItems = typedArray?.getResourceId(dropdownItens, R.array.dropdown_tipo_peca)
        typedArray?.recycle()

        initComponents()

        setLabel(labelText)
        setInputTextView(inputView)
        setDropdown(dropdownValor, dropdownItems)
    }

    private fun initComponents() {
        labelTextView = findViewById(R.id.input_label) as TextView

        inputTextView = findViewById(R.id.input_text_editor) as EditText

        dropdownView = findViewById(R.id.dropdown_peca) as AppCompatSpinner
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

//    fun getDropdown(): EditText? {
//        return inputTextView
//    }

    fun setDropdown(isDropdown: Boolean?, items: Int?) {
        Log.i("Prepiappp", " dropDown" + isDropdown)
        if (isDropdown != null && items != null && isDropdown) {
            dropdownView?.visibility = View.VISIBLE
            inputTextView?.visibility = View.GONE

            val adapter = ArrayAdapter.createFromResource(
                context,
                items, android.R.layout.simple_spinner_item
            )
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dropdown_peca.setAdapter(adapter)

        } else {
            dropdownView?.visibility = View.GONE
            inputTextView?.visibility = View.VISIBLE
        }
    }
}