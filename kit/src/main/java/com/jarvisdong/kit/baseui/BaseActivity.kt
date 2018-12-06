package com.jarvisdong.kit.baseui

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.jarvisdong.kit.ActBottomType
import com.jarvisdong.kit.R
import kotlinx.android.synthetic.main.component_include_bottom_btns.*
import kotlinx.android.synthetic.main.component_include_bottom_share.*
import kotlinx.android.synthetic.main.component_include_title.*
import kotlinx.android.synthetic.main.component_layout_coor_design_extra.*

/**
 * Created by JarvisDong on 2018/12/6.
 * OverView:
 */
abstract class BaseActivity : AppCompatActivity() {
    private var bottomType: Int? = null
    protected var mContext: Context? = null

    protected var bottomSheetBehavior: BottomSheetBehavior<*>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.component_layout_coor_design_extra)
        mContext = this
        initBottomType(setBottomType())
        var viewStubId = getViewStubId()
        if (viewStubId != 0) {
            content_layout.layoutResource = viewStubId
            content_layout.inflate()
        }

        if (initIntentData()) {
            customOperate(savedInstanceState)
        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onRestart() {
        super.onRestart()
    }

    /**
     * method
     */
    protected fun initTitleLeft(resId: Int) {
        bar_left.setCompoundDrawablesWithIntrinsicBounds(resId, 0, 0, 0)
    }

    protected fun initTitle(titleStr: String) {
        bar_title.setText(titleStr)
    }

    protected fun initTitleRight(resId: Int) {
        bar_right.setCompoundDrawablesWithIntrinsicBounds(0, 0, resId, 0)
    }

    protected fun getLeftView(): View {
        return bar_left
    }

    protected fun getRightView(): View {
        return bar_right
    }

    protected fun getBottomBtnLeft(): TextView? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_BTNS) {
            return add_mater_forward
        }
        return null
    }

    protected fun getBottomBtnMiddle(): TextView? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_BTNS) {
            return add_mater_complete
        }
        return null
    }

    protected fun getBottomBtnRight(): TextView? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_BTNS) {
            return add_mater_next
        }
        return null
    }

    protected fun getBottomShareWX(): View? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_SHARE) {
            return img_share_wx
        }
        return null
    }

    protected fun getBottomShareQQ(): View? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_SHARE) {
            return img_share_qq
        }
        return null
    }

    protected fun getBottomShareCopy(): View? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_SHARE) {
            return img_share_copy
        }
        return null
    }

    protected fun getBottomShareCancel(): View? {
        if (bottomType != null && bottomType === ActBottomType.ACT_BOTTOM_SHARE) {
            return btn_share_cancel
        }
        return null
    }


    private fun initBottomType(bottomType: Int) {
        this.bottomType = bottomType
        if (bottomType > 0) {
            if (bottomType === ActBottomType.ACT_BOTTOM_BTNS) {
                layout_bottom_btns.visibility = View.VISIBLE
            } else if (bottomType === ActBottomType.ACT_BOTTOM_SHARE) {
                layout_bottom_share.visibility = View.VISIBLE
                bottomSheetBehavior = BottomSheetBehavior.from(layout_bottom_share)
            }
        } else {
            layout_bottom_share.visibility = View.GONE
            layout_bottom_btns.visibility = View.GONE
        }
    }

    open fun setBottomType(): Int {
        return ActBottomType.ACT_BOTTOM_NONE
    }

    protected fun getBottomType():Int?{
        return this.bottomType
    }

    /**
     * abstract class;
     */
    protected abstract fun getViewStubId(): Int

    protected abstract fun initIntentData(): Boolean

    protected abstract fun customOperate(savedInstanceState: Bundle?)

}