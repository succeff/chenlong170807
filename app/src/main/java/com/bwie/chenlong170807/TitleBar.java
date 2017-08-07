package com.bwie.chenlong170807;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * 类的描述：
 * 时间：  2017/8/7.9:04
 * 姓名：chenlong
 */

public class TitleBar extends RelativeLayout {
    private Button title;
    private Button black;
    private Button more;
    public BarClickListener listener;

    public void setListener(BarClickListener listener) {
        this.listener = listener;
    }
    public TitleBar(Context context) {
        super(context);
        initView(null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs);
    }

    private void initView(AttributeSet attrs) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.bar_title, this);
        title = (Button) view.findViewById(R.id.bar_title);
        black = (Button) view.findViewById(R.id.bar_back);
        more = (Button) view.findViewById(R.id.more);
        title.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了标题",Toast.LENGTH_SHORT).show();
            }
        });
        black.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了返回",Toast.LENGTH_SHORT).show();
            }
        });
        more.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"点击了更多",Toast.LENGTH_SHORT).show();
            }
        });
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TitleBar);

            String str = a.getString(R.styleable.TitleBar_BarTitle);

            if (TextUtils.isEmpty(str)) {
                title.setText(getResources().getString(R.string.app_name));
            } else {
                title.setText(str);
            }

            a.recycle();
        }


    }
    public interface BarClickListener{
        public void backListener(View view);
        public void titleListener(View view);
    }
}
