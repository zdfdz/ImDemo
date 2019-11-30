package study.zdf.imdemo.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import org.jetbrains.anko.sp

/**
 * @author ZhengDeFeng
 * @description:
 * @date :2019/11/30 15:30
 */
class SlideBar : View {

    private var selectionHeight = 0f
    private var paint = Paint()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    companion object {
        private val SECTIONS = arrayOf(
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
            "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        )
    }

    init {
        paint.apply {
            color = Color.BLUE
            textSize = sp(12).toFloat()
            textAlign = Paint.Align.CENTER
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //计算每个字符分配的高度
        selectionHeight = h * 1.0f / SECTIONS.size
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        var x = width * 1.0f / 2
        var y = selectionHeight
        // 遍历sections
        SECTIONS.forEach {
            canvas?.drawText(it, x, y, paint)
            // 更新y
            y += selectionHeight
        }
    }
}