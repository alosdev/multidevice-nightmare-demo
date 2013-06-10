package de.alosdev.demo.multidevicenightmare;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onResume() {
        super.onResume();

        final String toastText;
        if (getResources().getBoolean(R.bool.is_phone_other))
            toastText = "phone other";
        else if (getResources().getBoolean(R.bool.is_phone_small))
            toastText = "phone small";
        else if (getResources().getBoolean(R.bool.is_tablet_10))
            toastText = "tabelt 10 inch";
        else if (getResources().getBoolean(R.bool.is_tablet_7))
            toastText = "tablet 7 inch";
        else
            toastText = "undefined";
        Toast.makeText(this, toastText, Toast.LENGTH_SHORT).show();
    }
}
