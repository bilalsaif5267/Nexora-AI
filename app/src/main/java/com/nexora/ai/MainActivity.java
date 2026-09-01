package com.nexora.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    int purple = Color.rgb(123,45,255);
    int dark = Color.rgb(11,6,24);
    int panel = Color.rgb(28,19,45);
    int white = Color.WHITE;
    int soft = Color.rgb(195,185,210);

    LinearLayout chatContainer;
    EditText input;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(dark);

        // Top bar
        LinearLayout top = new LinearLayout(this);
        top.setGravity(Gravity.CENTER_VERTICAL);
        top.setPadding(20,20,20,20);

        TextView logo = new TextView(this);
        logo.setText("💜 NEXORA");
        logo.setTextColor(white);
        logo.setTextSize(22);
        logo.setTypeface(Typeface.DEFAULT_BOLD);

        top.addView(logo);
        root.addView(top);

        // Chat area
        scrollView = new ScrollView(this);
        chatContainer = new LinearLayout(this);
        chatContainer.setOrientation(LinearLayout.VERTICAL);
        chatContainer.setPadding(16,16,16,16);
        scrollView.addView(chatContainer);

        root.addView(scrollView,
                new LinearLayout.LayoutParams(-1,0,1));

        addBotMessage("👋 Hello! I'm Nexora AI.\nAsk me anything.");

        // Input row
        LinearLayout inputRow = new LinearLayout(this);
        inputRow.setOrientation(LinearLayout.HORIZONTAL);
        inputRow.setPadding(16,16,16,16);
        inputRow.setBackgroundColor(panel);

        input = new EditText(this);
        input.setHint("Message Nexora...");
        input.setHintTextColor(Color.GRAY);
        input.setTextColor(white);
        input.setBackgroundColor(Color.TRANSPARENT);

        inputRow.addView(input,
                new LinearLayout.LayoutParams(0,-2,1));

        TextView send = new TextView(this);
        send.setText("➤");
        send.setTextColor(white);
        send.setTextSize(24);
        send.setPadding(20,10,20,10);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(purple);
        bg.setCornerRadius(100);
        send.setBackground(bg);

        inputRow.addView(send);

        root.addView(inputRow);

        send.setOnClickListener(v -> {
            String msg = input.getText().toString().trim();
            if(msg.isEmpty()) return;

            addUserMessage(msg);
            input.setText("");

            addBotMessage("✨ I received: " + msg);

            scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
        });

        setContentView(root);
    }

    void addUserMessage(String msg){
        TextView tv = bubble(msg, purple, white);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.END;
        lp.setMargins(80,10,0,10);

        chatContainer.addView(tv, lp);
    }

    void addBotMessage(String msg){
        TextView tv = bubble(msg, panel, soft);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.START;
        lp.setMargins(0,10,80,10);

        chatContainer.addView(tv, lp);
    }

    TextView bubble(String text,int bgColor,int txtColor){
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextColor(txtColor);
        tv.setTextSize(16);
        tv.setPadding(24,16,24,16);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(bgColor);
        bg.setCornerRadius(28);
        tv.setBackground(bg);

        return tv;
    }
}
