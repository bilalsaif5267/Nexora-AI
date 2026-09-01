package com.nexora.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends Activity {

    int purple = Color.rgb(123, 45, 255);
    int dark = Color.rgb(11, 6, 24);
    int white = Color.WHITE;
    int softWhite = Color.rgb(210, 202, 225);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(dark);
        getWindow().setNavigationBarColor(dark);

        // Main screen
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(dark);

        // ---------- TOP BAR ----------
        LinearLayout topBar = new LinearLayout(this);
        topBar.setOrientation(LinearLayout.HORIZONTAL);
        topBar.setGravity(Gravity.CENTER_VERTICAL);
        topBar.setPadding(24, 24, 24, 18);

        TextView menu = new TextView(this);
        menu.setText("☰");
        menu.setTextColor(white);
        menu.setTextSize(25);

        topBar.addView(menu, new LinearLayout.LayoutParams(
                55, 60
        ));

        TextView logo = new TextView(this);
        logo.setText("NEXORA");
        logo.setTextColor(white);
        logo.setTextSize(21);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        LinearLayout.LayoutParams logoParams =
                new LinearLayout.LayoutParams(0, 60, 1);
        topBar.addView(logo, logoParams);

        TextView newChat = new TextView(this);
        newChat.setText("＋");
        newChat.setTextColor(white);
        newChat.setTextSize(30);
        newChat.setGravity(Gravity.CENTER);

        topBar.addView(newChat, new LinearLayout.LayoutParams(
                55, 60
        ));

        root.addView(topBar);

        // ---------- WELCOME ----------
        LinearLayout welcome = new LinearLayout(this);
        welcome.setOrientation(LinearLayout.VERTICAL);
        welcome.setGravity(Gravity.CENTER);
        welcome.setPadding(28, 40, 28, 20);

        TextView orb = new TextView(this);
        orb.setText("✦");
        orb.setTextColor(white);
        orb.setTextSize(48);
        orb.setGravity(Gravity.CENTER);

        GradientDrawable orbBg = new GradientDrawable();
        orbBg.setShape(GradientDrawable.OVAL);
        orbBg.setColor(purple);
        orbBg.setStroke(2, Color.rgb(179, 136, 255));
        orb.setBackground(orbBg);

        LinearLayout.LayoutParams orbParams =
                new LinearLayout.LayoutParams(105, 105);
        orbParams.gravity = Gravity.CENTER;
        welcome.addView(orb, orbParams);

        TextView title = new TextView(this);
        title.setText("What can I help you create?");
        title.setTextColor(white);
        title.setTextSize(25);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        title.setPadding(0, 25, 0, 8);

        welcome.addView(title);

        TextView subtitle = new TextView(this);
        subtitle.setText("Ask, create, explore — your ideas start here.");
        subtitle.setTextColor(softWhite);
        subtitle.setTextSize(15);
        subtitle.setGravity(Gravity.CENTER);

        welcome.addView(subtitle);

        root.addView(welcome, new LinearLayout.LayoutParams(
                -1, 0, 1
        ));

        // ---------- INPUT AREA ----------
        LinearLayout inputArea = new LinearLayout(this);
        inputArea.setOrientation(LinearLayout.HORIZONTAL);
        inputArea.setGravity(Gravity.CENTER_VERTICAL);
        inputArea.setPadding(18, 10, 18, 20);

        GradientDrawable inputBg = new GradientDrawable();
        inputBg.setColor(Color.rgb(28, 19, 45));
        inputBg.setCornerRadius(45);

        inputArea.setBackground(inputBg);

        TextView attach = new TextView(this);
        attach.setText("＋");
        attach.setTextColor(white);
        attach.setTextSize(27);
        attach.setGravity(Gravity.CENTER);

        inputArea.addView(attach, new LinearLayout.LayoutParams(
                55, 60
        ));

        EditText input = new EditText(this);
        input.setHint("Message Nexora...");
        input.setHintTextColor(Color.rgb(145, 135, 160));
        input.setTextColor(white);
        input.setTextSize(16);
        input.setSingleLine(false);
        input.setBackgroundColor(Color.TRANSPARENT);
        input.setPadding(5, 0, 5, 0);

        inputArea.addView(input, new LinearLayout.LayoutParams(
                0, 65, 1
        ));

        TextView send = new TextView(this);
        send.setText("➤");
        send.setTextColor(white);
        send.setTextSize(22);
        send.setGravity(Gravity.CENTER);

        GradientDrawable sendBg = new GradientDrawable();
        sendBg.setShape(GradientDrawable.OVAL);
        sendBg.setColor(purple);

        send.setBackground(sendBg);

        inputArea.addView(send, new LinearLayout.LayoutParams(
                58, 58
        ));

        root.addView(inputArea);

        setContentView(root);
    }
}
