package com.nico.signa

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import java.lang.StringBuilder

class DrawView2 : View {
    lateinit var paint: Paint
    lateinit var rect: Rect
    lateinit var sb: StringBuilder

    private var activity: MainActivity? = null

    constructor(context: Context) : super(context) {
        paint = Paint()
        rect = Rect(100, 200, 200, 300)
        sb = StringBuilder()
    }
    constructor(context: Context, attrs: AttributeSet) :
            super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStile: Int) :
            super(context, attrs, defStile)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // заливка канвы цветом
        canvas.drawARGB(80, 102, 255, 178)

        paint.color = Color.BLACK
        paint.strokeWidth = 10f
        paint.textSize = 30f

        // создаем строку с значениями ширины и высоты канвы
        sb.setLength(0)
        sb.append("width = ").append(width)
                .append(", height = ").append(height)
        canvas.drawText(sb.toString(), 100f, 100f, paint)

        // перенастраивам кисть на заливку
        paint.style = Paint.Style.FILL
        canvas.drawRect(rect, paint)

        // перенастраивам кисть на контуры
        paint.style = Paint.Style.STROKE
        rect.offset(150, 0)
        canvas.drawRect(rect, paint)

        // перенастраивам кисть на заливку + контуры
        paint.style = Paint.Style.FILL_AND_STROKE
        rect.offset(150, 0)
        canvas.drawRect(rect, paint)
    }
}