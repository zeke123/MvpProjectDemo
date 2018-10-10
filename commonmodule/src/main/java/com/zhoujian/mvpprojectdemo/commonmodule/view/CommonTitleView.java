package com.zhoujian.mvpprojectdemo.commonmodule.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.zhoujian.mvpprojectdemo.commonmodule.R;

public class CommonTitleView extends RelativeLayout {
    private LinearLayout layout_left, layout_right;
    private TextView tv_left, tv_title, tv_right;
    private ImageView iv_left, iv_right;
    private onViewClick mClick;

    public CommonTitleView(Context context) {
        this(context, null);
    }

    public CommonTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CommonTitleView(final Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.common_title_layout, this);
        initView();
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CommonTitleView, defStyleAttr, 0);
        int count = array.getIndexCount();
        for (int i = 0; i < count; i++) {
            int attr = array.getIndex(i);
            if (attr == R.styleable.CommonTitleView_leftTextColor) {
                tv_left.setTextColor(array.getColor(attr, Color.BLACK));

            } else if (attr == R.styleable.CommonTitleView_leftDrawble) {
                iv_left.setImageResource(array.getResourceId(attr, 0));

            } else if (attr == R.styleable.CommonTitleView_leftText) {
                tv_left.setText(array.getString(attr));

            } else if (attr == R.styleable.CommonTitleView_centerTextColor) {
                tv_title.setTextColor(array.getColor(attr, Color.BLACK));

            } else if (attr == R.styleable.CommonTitleView_centerTitle) {
                tv_title.setText(array.getString(attr));

            } else if (attr == R.styleable.CommonTitleView_rightDrawable) {
                iv_right.setImageResource(array.getResourceId(attr, 0));

            } else if (attr == R.styleable.CommonTitleView_rightText) {
                tv_right.setText(array.getString(attr));

            } else if (attr == R.styleable.CommonTitleView_rightTextColor) {
                tv_right.setTextColor(array.getColor(attr, Color.BLACK));

            }
        }
        array.recycle();
        layout_left.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClick.leftClick();
            }
        });
        layout_right.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mClick.rightClick();
            }
        });
    }

    private void initView() {
        tv_left = findViewById(R.id.tv_left);
        tv_title = findViewById(R.id.tv_title);
        tv_right = findViewById(R.id.tv_right);
        iv_left = findViewById(R.id.iv_left);
        iv_right = findViewById(R.id.iv_right);
        layout_left = findViewById(R.id.layout_left);
        layout_right = findViewById(R.id.layout_right);
    }

    public void setOnViewClick(onViewClick click) {
        this.mClick = click;
    }

    //设置标题
    public void setTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_title.setText(title);
        }
    }

    //设置左标题
    public void setLeftText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_left.setText(title);
        }
    }

    //设置右标题
    public void setRightText(String title) {
        if (!TextUtils.isEmpty(title)) {
            tv_right.setText(title);
        }
    }

    //设置标题大小
    public void setTitleSize(int size) {
        if (tv_title != null) {
            tv_title.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左标题大小
    public void setLeftTextSize(int size) {
        if (tv_left != null) {
            tv_left.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置右标题大小
    public void setRightTextSize(int size) {
        if (tv_right != null) {
            tv_right.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
        }
    }

    //设置左图标
    public void setLeftDrawable(int res) {
        if (iv_left != null) {
            iv_left.setImageResource(res);
        }
    }

    //设置右图标
    public void setRightDrawable(int res) {
        if (iv_right != null) {
            iv_right.setImageResource(res);
        }
    }

    public interface onViewClick {
        void leftClick();

        void rightClick();
    }

}

