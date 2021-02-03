package com.nico.signa

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View


class DrawView : View {
    lateinit var paint: Paint
//    lateinit var rect: Rect
    lateinit var rectF: RectF
    lateinit var points: FloatArray
    lateinit var points1: FloatArray

    private var activity: MainActivity? = null

    constructor(context: Context) : super(context) {
        paint = Paint()
//        rect = Rect()
        rectF = RectF(700f,100f,800f,150f)
        points = floatArrayOf(100f, 50f, 150f, 100f, 150f, 200f, 50f, 200f, 50f, 100f)
        points1 = floatArrayOf(300f, 200f, 600f, 200f, 300f, 300f, 600f, 300f,
                                 400f, 100f, 400f, 400f, 500f, 100f, 500f, 400f)
    }
    constructor(context: Context, attrs: AttributeSet) :
            super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStile: Int) :
            super(context, attrs, defStile)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        // заливка канвы цветом
        canvas.drawARGB(80, 102, 204, 255)
        // настройка кисти
        // красный цвет
        paint.color = Color.RED
        // толщина линии = 10
        paint.strokeWidth = 10F

        // рисуем точку (50,50)
//        canvas.drawPoint(50F, 50F, paint)
        // рисуем линию от (100,100) до (500,50)
//        canvas.drawLine(0F,0F,500F,50F, paint)
        // рисуем круг с центром в (100,200), радиус = 50
//        canvas.drawCircle(500F, 500F, 50F, paint)
        // рисуем прямоугольник
        // левая верхняя точка (200,150), нижняя правая (400,200)
//        canvas.drawRect(200F, 150F, 400F, 200F, paint)

        // настройка объекта Rect
        // левая верхняя точка (250,300), нижняя правая (350,500)
//        rect.set(250, 300, 350, 500)
        // рисуем прямоугольник из объекта rect
//        canvas.drawRect(rect, paint)

        // рисуем точки их массива points
        canvas.drawPoints(points, paint)
        // рисуем линии по точкам из массива points1
        canvas.drawLines(points1,paint)
        // перенастраиваем кисть на зеленый цвет
        paint.color = Color.GREEN
        // рисуем закругленный прямоугольник по координатам из rectf
        // радиусы закругления = 20
        canvas.drawRoundRect(rectF, 20f, 20f, paint)
        // смещаем коорднаты rectf на 150 вниз
        rectF.offset(0f, 150f)
        // рисуем овал внутри прямоугольника rectf
        canvas.drawOval(rectF, paint)

        // смещаем rectf в (900,100) (левая верхняя точка)
        rectF.offsetTo(900f, 100f)
        // увеличиваем rectf по вертикали на 25 вниз и вверх
        rectF.inset(0f, -25f)
        // рисуем дугу внутри прямоугольника rectf
        // с началом в 90, и длиной 270
        // соединение крайних точек через центр
        canvas.drawArc(rectF, 90f, 270f, true, paint)
        // смещаем коорднаты rectf на 150 вниз
        rectF.offset(0f, 150f)
        // рисуем дугу внутри прямоугольника rectf
        // с началом в 90, и длиной 270
        // соединение крайних точек напрямую
        canvas.drawArc(rectF, 90f, 270f, false, paint)

        // перенастраиваем кисть на толщину линии = 3
        paint.strokeWidth = 3f
        // рисуем линию (150,450) - (150,600)
        canvas.drawLine(150f, 450f, 150f, 600f, paint)

        // перенастраиваем кисть на синий цвет
        paint.color = Color.BLUE
        // настраиваем размер текста = 30
        paint.textSize = 30f
        // рисуем текст в точке (150,500)
        canvas.drawText("text left", 150f, 500f, paint)
        // настраиваем выравнивание текста на центр
        paint.textAlign = Paint.Align.CENTER
        // рисуем текст в точке (150,525)
        canvas.drawText("text center", 150f, 525f, paint)

        // настраиваем выравнивание текста на левое
        paint.textAlign = Paint.Align.RIGHT;
        // рисуем текст в точке (150,550)
        canvas.drawText("text right", 150f, 550f, paint);
    }

    fun setActivity(activity: MainActivity) {
        this.activity = activity
    }
}