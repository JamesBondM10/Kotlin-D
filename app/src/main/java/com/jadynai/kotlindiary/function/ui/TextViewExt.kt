package com.jadynai.kotlindiary.function.ui

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.annotation.DrawableRes
import android.text.TextUtils
import android.widget.TextView

/**
 *@version:
 *@FileDescription:TextView扩展函数
 *@Author:jing
 *@Since:2018/7/4
 *@ChangeList:
 */
fun TextView.drawable(textDrawable: TextDrawable.() -> Unit) {
    val d = TextDrawable()
    d.textDrawable()
    this.setCompoundDrawablesWithIntrinsicBounds(d.dl, d.dt, d.dr, d.db)
}

class TextDrawable(var dl: Drawable? = null, var dt: Drawable? = null, var dr: Drawable? = null, var db: Drawable? = null) {

    fun drawLeft(@DrawableRes normalRes: Int, @DrawableRes selectRes: Int = -1) {
        dl = getPressDrawable(normalRes, selectRes)
    }

    fun drawTop(@DrawableRes normalRes: Int, @DrawableRes selectRes: Int = -1) {
        dt = getPressDrawable(normalRes, selectRes)
    }

    fun drawRight(@DrawableRes normalRes: Int, @DrawableRes selectRes: Int = -1) {
        dr = getPressDrawable(normalRes, selectRes)
    }

    fun drawBottom(@DrawableRes normalRes: Int, @DrawableRes selectRes: Int = -1) {
        db = getPressDrawable(normalRes, selectRes)
    }
}

fun TextView.pressTextColor(normalColor: Int, pressColor: Int) {
    val list = ColorStateList(arrayOf(intArrayOf(R.attr.state_pressed),
            intArrayOf()), intArrayOf(pressColor, normalColor))
    this.setTextColor(list)
}

fun TextView.selectTextColor(normalColor: Int, pressColor: Int) {
    val list = ColorStateList(arrayOf(intArrayOf(R.attr.state_selected),
            intArrayOf()), intArrayOf(pressColor, normalColor))
    this.setTextColor(list)
}

fun TextView.checkedTextColor(normalColor: Int, pressColor: Int) {
    val list = ColorStateList(arrayOf(intArrayOf(R.attr.state_checked),
            intArrayOf()), intArrayOf(pressColor, normalColor))
    this.setTextColor(list)
}

fun TextView.generateHexColor(): String {
    val a = Integer.toHexString(Color.alpha(currentTextColor))
    val r = Integer.toHexString(Color.red(currentTextColor))
    val g = Integer.toHexString(Color.green(currentTextColor))
    val b = Integer.toHexString(Color.blue(currentTextColor))
    return TextUtils.concat("#", a, r, g, b).toString()
}
