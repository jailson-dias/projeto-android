package prepi.com.prepi.components

import android.content.Context
import android.support.annotation.StyleableRes
import android.support.v7.widget.AppCompatSpinner
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.horizontal_select_button.view.*
import prepi.com.prepi.R

class HorizontalSelectButton(context: Context?, attrs: AttributeSet?) :
    LinearLayout(context, attrs) {

    @StyleableRes
    internal var label = 0
    @StyleableRes
    internal var dropdownItens = 1

    internal var labelTextView: TextView? = null
    internal var dropdownView: AppCompatSpinner? = null

    init {
        init(context, attrs)
    }

    private fun init(context: Context?, attrs: AttributeSet?) {
        View.inflate(context, R.layout.horizontal_select_button, this)

//        Log.i("Prepiappp", attrs.toString())
        val sets = intArrayOf(
            R.attr.label,
            R.attr.dropdown_itens
        )
        val typedArray = context?.obtainStyledAttributes(attrs, sets)
//        Log.i("Prepiappp", " valor do type array ")
        val labelText = typedArray?.getText(label)
        val dropdownItems = typedArray?.getResourceId(dropdownItens, R.array.dropdown_tipo_peca)
        typedArray?.recycle()

        initComponents()

        setLabel(labelText)
        setDropdown(dropdownItems)
    }

    private fun initComponents() {
        labelTextView = findViewById(R.id.input_label) as TextView
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

//    fun getDropdown(): EditText? {
//        return inputTextView
//    }

    fun setDropdown(items: Int?) {

        if (items != null) {
            Log.i("Prepiappp", "" + items)
            val adapter = ArrayAdapter.createFromResource(
                context,
                items, android.R.layout.simple_spinner_item
            )
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            dropdown_peca.setAdapter(adapter)
        }
    }
}