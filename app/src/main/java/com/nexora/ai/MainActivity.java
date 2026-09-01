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

    int purple = Color.rgb(123, 45, 255);
    int dark = Color.rgb(11, 6, 24);
    int panel = Color.rgb(28, 19, 45);
    int white = Color.WHITE;
    int soft = Color.rgb(195, 185, 210);

    LinearLayout chatContainer;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(dark);
        getWindow().setNavigationBarColor(dark);

        // ROOT
        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(dark);

        // ================= TOP BAR =================

        LinearLayout top = new LinearLayout(this);
        top.setGravity(Gravity.CENTER_VERTICAL);
        top.setPadding(20, 15, 20, 10);

        TextView menu = text("☰", 26, white);
        top.addView(menu, new LinearLayout.LayoutParams(55, 60));

        TextView logo = text("NEXORA", 20, white);
        logo.setTypeface(Typeface.DEFAULT, Typeface.BOLD);

        LinearLayout.LayoutParams logoParams =
                new LinearLayout.LayoutParams(0, 60, 1);

        top.addView(logo, logoParams);

        TextView newChat = text("＋", 30, white);
        newChat.setGravity(Gravity.CENTER);

        top.addView(newChat, new LinearLayout.LayoutParams(55, 60));

        root.addView(top);

        // ================= CHAT AREA =================

        ScrollView scroll = new ScrollView(this);

        chatContainer = new LinearLayout(this);
        chatContainer.setOrientation(LinearLayout.VERTICAL);
        chatContainer.setPadding(18, 20, 18, 20);

        scroll.addView(chatContainer);

        root.addView(
                scroll,
                new LinearLayout.LayoutParams(1, 0, 1)
        );

        // Welcome message
        addBotMessage(
                "Hello! 👋\n\nI'm Nexora AI.\n\nAsk me anything or tell me what you'd like to create."
        );

        // ================= INPUT =================

        LinearLayout inputRow = new LinearLayout(this);
        inputRow.setGravity(Gravity.CENTER_VERTICAL);
        inputRow.setPadding(15, 8, 15, 15);

        GradientDrawable inputBg = new GradientDrawable();
        inputBg.setColor(panel);
        inputBg.setCornerRadius(45);

        inputRow.setBackground(inputBg);

        TextView attach = text("＋", 27, white);
        attach.setGravity(Gravity.CENTER);

        inputRow.addView(
                attach,
                new LinearLayout.LayoutParams(55, 60)
        );

        input = new EditText(this);
        input.setHint("Message Nexora...");
        input.setHintTextColor(Color.rgb(140, 130, 155));
        input.setTextColor(white);
        input.setTextSize(16);
        input.setSingleLine(false);
        input.setBackgroundColor(Color.TRANSPARENT);

        inputRow.addView(
                input,
                new LinearLayout.LayoutParams(0, 65, 1)
        );

        TextView send = text("➤", 22, white);
        send.setGravity(Gravity.CENTER);

        GradientDrawable sendBg = new GradientDrawable();
        sendBg.setShape(GradientDrawable.OVAL);
        sendBg.setColor(purple);

        send.setBackground(sendBg);

        inputRow.addView(
                send,
                new LinearLayout.LayoutParams(58, 58)
        );

        root.addView(inputRow);

        // ================= SEND =================

        send.setOnClickListener(v -> {

            String message = input.getText().toString().trim();

            if (message.isEmpty()) {
                return;
            }

            addUserMessage(message);

            input.setText("");

            // Temporary local response.
            // Real AI API will be connected later.
            addBotMessage(
                    "I received your message:\n\n\"" +
                    message +
                    "\"\n\n✨ AI connection will be added in the next stage."
            );
        });

        setContentView(root);
    }

    // ================= TEXT HELPER =================

    TextView text(String value, float size, int color) {

        TextView t = new TextView(this);

        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);

        return t;
    }

    // ================= USER MESSAGE =================

    void addUserMessage(String message) {

        TextView bubble = text(message, 16, white);

        bubble.setPadding(22, 15, 22, 15);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(purple);
        bg.setCornerRadius(28);

        bubble.setBackground(bg);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.RIGHT;
        params.setMargins(45, 8, 0, 8);

        chatContainer.addView(bubble, params);
    }

    // ================= BOT MESSAGE =================

    void addBotMessage(String message) {

        TextView bubble = text(message, 16, soft);

        bubble.setPadding(22, 15, 22, 15);

        GradientDrawable bg = new GradientDrawable();
        bg.setColor(panel);
        bg.setCornerRadius(28);

        bubble.setBackground(bg);

        LinearLayout.LayoutParams params =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

        params.gravity = Gravity.LEFT;
        params.setMargins(0, 8, 45, 8);

        chatContainer.addView(bubble, params);
    }
}
