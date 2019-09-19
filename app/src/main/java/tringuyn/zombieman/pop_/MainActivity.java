package tringuyn.zombieman.pop_;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Dialog dialog;
    private Button btnShow;
    private Button btAllow;
    private Button btDeny;
    private TextView txtTitle, txtMessage;
    private String stringTitle, stringMessage, stringButtonLeft, stringButtonRight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.bt_show);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stringTitle = "Turn-off Wifi?";
                stringMessage = "To use Mobile Hotspot, Wi-fi needs to be turned off";
                stringButtonLeft = "Cancel";
                stringButtonRight = "OK";
                showDialog(stringTitle, stringMessage, stringButtonLeft, stringButtonRight);
            }
        });
    }


    public void showDialog(String title,String message, String contentLeft, String contentRight) {

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        // inflate and adjust layout
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.dialog, null);
        dialog = new Dialog(MainActivity.this, R.style.DialogTheme);
        layout.setMinimumWidth((width));
        layout.setMinimumHeight((int)(height * 0.25f));
        dialog.setContentView(layout);
        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        dialog.show();

        btAllow = dialog.findViewById(R.id.bt_allow);
        btDeny = dialog.findViewById(R.id.bt_deny);
        txtTitle = dialog.findViewById(R.id.txt_title);
        txtMessage = dialog.findViewById(R.id.txt_message);
        txtTitle.setText(title);
        txtMessage.setText(message);
        btAllow.setText(contentRight);
        btDeny.setText(contentLeft);
        btAllow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        btDeny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }

}
