package com.narcs.robotcontrol;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private Float vSpeed = new Float(100);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());

        Button ButtonMore = (Button)findViewById(R.id.button);
        Button ButtonLess = (Button)findViewById(R.id.button2);

        final TextView SpeedTextView = (TextView)findViewById(R.id.sample_text);

        SpeedTextView.setText(Float.toString(vSpeed));
        // Action Button
        ButtonMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                vSpeed = vSpeed +1;
                SpeedTextView.setText(Float.toString(vSpeed));
                CharSequence text = "Hello toast / " + SpeedTextView.getText();
            }
        });
        ButtonLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                vSpeed = vSpeed -1;
                SpeedTextView.setText(Float.toString(vSpeed));
                CharSequence text = "Hello toast / " + SpeedTextView.getText();
            }
        });
    // Getters




 //   public void onClick(View v) {
 //       switch (v.getId()) {
  //          case  R.id.button: {
 //               // do something for button 1 click
 //               break;
 //           }

 //           case R.id.button2: {
 //               // do something for button 2 click
 //               break;
 //           }
//
//            //.... etc
 //       }
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
