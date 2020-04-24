package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.dp2px
import java.util.*

class CodeView @JvmOverloads constructor(context: Context?, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {



    // apply ：作用域函数
    /**
     * 1. 返回自身 -> 从 apply 和 also 中选
    - 作用域中使用 this 作为参数 ----> 选择 apply
    - 作用域中使用 it 作为参数 ----> 选择 also

    2. 不需要返回自身 -> 从 run 和 let 中选择
    - 作用域中使用 this 作为参数 ----> 选择 run
    - 作用域中使用 it 作为参数 ----> 选择 let
     * */
    private val paint = Paint().apply {
        isAntiAlias = true
        style = Paint.Style.STROKE
        color = getContext().getColor(R.color.colorAccent)
        strokeWidth = 6f.dp2px()
    }


    // intArrayOf -> 基本数据类型
    private val inrArray = intArrayOf(1, 2, 3, 4)
    //arrayOf -> 会自动装箱
    private val IntegerList = arrayOf(1, 2, 3, 4)

    private val codeList = arrayOf(
            "kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip"
    )

    fun updateCode() {
        val random: Int = Random().nextInt(codeList.size)
        val code: String = codeList[random]
        text = code
    }
    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)
        updateCode()
    }

    override fun onDraw(canvas: Canvas?) {
        canvas!!.drawLine(0f, height.toFloat(), width.toFloat(), 0f, paint)
        super.onDraw(canvas)

    }
}