package de.alosdev.demo.multidevicenightmare;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import static android.widget.LinearLayout.LayoutParams.MATCH_PARENT;
import static android.widget.LinearLayout.LayoutParams.WRAP_CONTENT;

/**
 * Created by hhosgel on 10.06.13.
 */
public class CustomView extends LinearLayout {
    private static final int[] ORIENTATION = new int[]{HORIZONTAL, VERTICAL};

    public CustomView(Context context) {
        super(context);
        init(context, null, 0);
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    @SuppressLint("NewApi")
    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context, AttributeSet attrs, int defStyle) {
        int margin = (int) getResources().getDimension(R.dimen.custom_view_margin);
        setPadding(margin, margin, margin, margin);

        LayoutParams lp = new LayoutParams(MATCH_PARENT, WRAP_CONTENT, 1f);
        lp.setMargins(margin, margin, margin, margin);
        if (null == attrs){
            initWithoutAttribute(context, lp, margin);
        } else
        initWithAttributes(context, attrs, lp, margin);

        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.custom_view_bg1)));
    }

    private void initWithAttributes(Context context, AttributeSet attrs, LayoutParams lp, int margin) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomView);
        try {
            setOrientation(ORIENTATION[a.getInt(R.styleable.CustomView_orientation, 0)]);
            addView(createTextView(context, a.getString(R.styleable.CustomView_label), margin), lp);
            addView(createTextView(context, a.getString(R.styleable.CustomView_value), margin), lp);
        } finally {
            a.recycle();
        }
    }

    private void initWithoutAttribute(Context context, LayoutParams lp, int margin) {
        if (getResources().getBoolean(R.bool.is_phone_other) || getResources().getBoolean(R.bool.is_phone_small)) {
            setOrientation(VERTICAL);
        } else {
            setOrientation(HORIZONTAL);
        }
        addView(createTextView(context, "label", margin), lp);
        addView(createTextView(context, "desc", margin), lp);
    }

    private View createTextView(Context context, String label, int padding) {
        TextView textView = new TextView(context);
        textView.setText(label);
        textView.setTextColor(getResources().getColor(R.color.white));
        textView.setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.custom_view_bg2)));
        textView.setPadding(padding, padding, padding, padding);
        textView.setTextSize(getResources().getDimension(R.dimen.textSize));
        return textView;
    }
}
