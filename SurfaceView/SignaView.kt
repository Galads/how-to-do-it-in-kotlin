package com.nico.signa

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.view.SurfaceHolder
import android.view.SurfaceView

class SignaView: SurfaceView, SurfaceHolder.Callback {

    private  lateinit var drawThread:DrawThread

    constructor(context: Context) : super(context) {
        getHolder().addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {
        drawThread = DrawThread(getHolder())
        drawThread.setRunning(true)
        drawThread.start()
    }

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) { }

    override fun surfaceDestroyed(holder: SurfaceHolder) {
        var retry: Boolean = true
        drawThread.setRunning(false)
        while (retry) {
            try {
                drawThread.join()
                retry = false
            } catch (e: InterruptedException) { }
        }
    }

    class DrawThread: Thread {
        private var running: Boolean = false
        private var surfaceHolder: SurfaceHolder

        constructor(surfaceHolder: SurfaceHolder) {
            this.surfaceHolder = surfaceHolder
        }

        fun setRunning(running: Boolean) {
            this.running = running
        }

        override fun run() {
            var canvas: Canvas?
            while (running) {
                canvas = null
                try {
                    canvas = surfaceHolder.lockCanvas(null)
                    if (canvas == null)
                        continue
                    canvas.drawColor(Color.GREEN)
                } finally {
                    surfaceHolder.unlockCanvasAndPost(canvas)
                }
            }
        }
    }
}