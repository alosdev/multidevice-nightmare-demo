package de.alosdev.demo.multidevicenightmare;

import android.annotation.SuppressLint;
import android.content.Context;
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
        if (getResources().getBoolean(R.bool.is_phone_other) || getResources().getBoolean(R.bool.is_phone_small)) {
            setOrientation(VERTICAL);
        } else {
            setOrientation(HORIZONTAL);
        }
        LayoutParams lp = new LayoutParams(MATCH_PARENT, WRAP_CONTENT, 1f);

        lp.setMargins(margin, margin, margin, margin);
        addView(createTextView(context, "label", margin), lp);
        addView(createTextView(context, "desc", margin), lp);
        setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.custom_view_bg1)));
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
