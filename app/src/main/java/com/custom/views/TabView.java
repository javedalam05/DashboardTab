package com.custom.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tabviewsample.R;

public class TabView extends LinearLayout {

    View rootView;
    float devidedHeight = 4;

    TextView txt_view_1;
    TextView txt_view_2;
    ImageView img_view_1;
    ImageView img_view_2;


    int tag = 1;

    String text1 = "";
    String text2 = "";

    int drawableId1 = R.mipmap.ic_launcher;
    int drawableId2 = R.mipmap.ic_launcher;

    Drawable drawable1;
    Drawable drawable2;


    public void setButtonClickLisner(ButtonClickLisner buttonClickLisner) {
        this.buttonClickLisner = buttonClickLisner;
    }

    ButtonClickLisner buttonClickLisner;

    public interface ButtonClickLisner {
        public void firstButtonClick(int tag);

        public void secondButtonClick(int tag);
    }


    public TabView(Context context) {
        super(context);
        init(context);
    }

    public TabView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TabView);
        this.devidedHeight = a.getFloat(R.styleable.TabView_tab_height, 4);
        this.tag = a.getInt(R.styleable.TabView_tag, 1);
        this.text1 = a.getString(R.styleable.TabView_text_1);
        this.text2 = a.getString(R.styleable.TabView_text_2);
        drawable1 = a.getDrawable(R.styleable.TabView_drawable_one);
        drawable2 = a.getDrawable(R.styleable.TabView_drawable_two);
        init(context);

    }


    private void init(Context context) {
        rootView = inflate(context, R.layout.dashboard_tab_view, this);

        txt_view_1 = (TextView) rootView.findViewById(R.id.txt_view_1);
        txt_view_2 = (TextView) rootView.findViewById(R.id.txt_view_2);
        img_view_1 = (ImageView) rootView.findViewById(R.id.img_view_1);
        img_view_2 = (ImageView) rootView.findViewById(R.id.img_view_2);


        setText1(text1);
        setText2(text2);

        setDrawableId1(drawableId1);
        setDrawableId2(drawableId2);

        if (drawable1 != null) {
            img_view_1.setImageDrawable(drawable1);
        }
        if (drawable2 != null) {
            img_view_2.setImageDrawable(drawable2);
        }

        int tabWidth = (int) getPrecentWidth(context, 44);
        int remainingWidth = ((int) getDeviceWidth(context)) - (2 * tabWidth);
        int margin = remainingWidth / 3;


        int remainingHeight = getDeviceHeight(context) -
                (getStatusBarHeight(context)
                        + (getToolBarHeight(context)) + (5 * margin));

        float tabHeight = remainingHeight / devidedHeight;

        setLayout(rootView, tabWidth, tabHeight, margin, margin, 0);


    }


    void setLayout(final View row, int tabWidth, float tabHeight,
                   int margin, int topMargin,
                   int bottomMargin) {


        RelativeLayout btn_check_in = (RelativeLayout) row.findViewById(R.id.btn_1);
        RelativeLayout btn_2 = (RelativeLayout) row.findViewById(R.id.btn_2);


        int halfMargin = margin / 2;


        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(margin, topMargin, halfMargin, bottomMargin);
            layoutParams.width = tabWidth;
            layoutParams.height = (int) tabHeight;

            btn_check_in.setLayoutParams(layoutParams);

        }

        {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
                    RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

            layoutParams.setMargins(halfMargin, topMargin, margin, bottomMargin);
            layoutParams.width = tabWidth;
            layoutParams.height = (int) tabHeight;

            btn_2.setLayoutParams(layoutParams);

        }

        btn_check_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (buttonClickLisner != null)
                    buttonClickLisner.firstButtonClick(tag);

            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (buttonClickLisner != null)
                    buttonClickLisner.secondButtonClick(tag);

            }
        });

    }

    public void setText1(String text1) {
        this.text1 = text1;
        txt_view_1.setText(text1);
    }

    public void setText2(String text2) {
        this.text2 = text2;
        txt_view_2.setText(text2);
    }

    public void setDrawableId1(int drawableId1) {
        this.drawableId1 = drawableId1;
        img_view_1.setImageResource(drawableId1);
    }

    public void setDrawableId2(int drawableId2) {
        this.drawableId2 = drawableId2;
        img_view_2.setImageResource(drawableId2);
    }


    public void setTag(int tag) {
        this.tag = tag;
    }

    public static float getPrecentWidth(Context activity, float layoutX) {
        return ((layoutX * getDeviceWidth(activity)) / 100);
    }

    public static int getDeviceWidth(Context activity) {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        int width = metrics.widthPixels;

        return width;
    }

    public static int getDeviceHeight(Context activity) {
        DisplayMetrics metrics = activity.getResources().getDisplayMetrics();
        int height = metrics.heightPixels;

        return height;
    }

    public static int getStatusBarHeight(Context activity) {
        int result = 0;
        int resourceId = activity.getResources().getIdentifier(
                "status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = activity.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }


    public static int getToolBarHeight(Context activity) {
        int[] attrs = new int[]{R.attr.actionBarSize};
        TypedArray ta = activity.obtainStyledAttributes(attrs);
        int toolBarHeight = ta.getDimensionPixelSize(0, -1);
        ta.recycle();
        return toolBarHeight;
    }
}
