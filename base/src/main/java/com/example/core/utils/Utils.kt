package com.example.core.utils

import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication


private val displayMetrics: DisplayMetrics = Resources.getSystem().displayMetrics
// 1.扩展特性 可以给任何类加上对应的成员属性或成员函数
//2. 顶层函数
fun Float.dp2px(): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics);
}

object Utils {
    // 声明默认值 -> java调用时需要声明JvmOverloads注解
    @JvmOverloads
    fun toast(string: String?, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.application, string, duration).show();
    }
}