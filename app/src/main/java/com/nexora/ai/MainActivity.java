package com.nexora.ai;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    int purple = Color.parseColor("#7B2DFF");
    int dark = Color.parseColor("#0B0618");
    int panel = Color.parseColor("#1C132D");
    int white = Color.WHITE;
    int soft = Color.parseColor("#D4C7F5");

    LinearLayout root, chatContainer, toolsContainer;
    ScrollView scrollView;
    EditText input;
    boolean toolsVisible = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setBackgroundColor(dark);

        createTopBar();
        createTools();
        createChatArea();
        createInputBar();

        setContentView(root);

        addBotMessage("👋 Welcome to Nexora AI.\nYour creative AI studio is getting ready.");
    }

    void createTopBar() {
        LinearLayout top = new LinearLayout(this);
        top.setOrientation(LinearLayout.HORIZONTAL);
        top.setGravity(Gravity.CENTER_VERTICAL);
        top.setPadding(22,20,22,18);

        TextView menu = text("☰",26,white);

        TextView logo = text("💜 NEXORA",20,white);
        logo.setTypeface(Typeface.DEFAULT_BOLD);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(0,-2,1);

        TextView newChat = text("＋",28,white);

        newChat.setOnClickListener(v -> {
            chatContainer.removeAllViews();
            addBotMessage("✨ New chat started.");
        });

        top.addView(menu);
        top.addView(logo,lp);
        top.addView(newChat);

        root.addView(top);
    }

    void createTools() {
        toolsContainer = new LinearLayout(this);
        toolsContainer.setOrientation(LinearLayout.VERTICAL);
        toolsContainer.setPadding(18,0,18,12);

        TextView title = text("⚡ AI Studio",16,soft);
        toolsContainer.addView(title);

        LinearLayout row1 = new LinearLayout(this);
        row1.setOrientation(LinearLayout.HORIZONTAL);

        row1.addView(toolCard("🎬","Video"));
        row1.addView(toolCard("🖼️","Image"));

        LinearLayout row2 = new LinearLayout(this);
        row2.setOrientation(LinearLayout.HORIZONTAL);

        row2.addView(toolCard("🎤","Voice"));
        row2.addView(toolCard("🎨","Thumbnail"));

        toolsContainer.addView(row1);
        toolsContainer.addView(row2);

        root.addView(toolsContainer);
    }

    TextView toolCard(String emoji,String name){
        TextView card = new TextView(this);
        card.setText(emoji+"\n"+name);
        card.setGravity(Gravity.CENTER);
        card.setTextColor(white);
        card.setPadding(20,24,20,24);

        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(28);
        bg.setColor(panel);

        card.setBackground(bg);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(0,-2,1);
        lp.setMargins(6,8,6,8);

        card.setLayoutParams(lp);

        card.setOnClickListener(v ->
            Toast.makeText(this,name+" coming soon 🚀",Toast.LENGTH_SHORT).show()
        );

        return card;
    }

    void createChatArea(){
        scrollView = new ScrollView(this);

        chatContainer = new LinearLayout(this);
        chatContainer.setOrientation(LinearLayout.VERTICAL);
        chatContainer.setPadding(16,18,16,18);

        scrollView.addView(chatContainer);

        root.addView(scrollView,
                new LinearLayout.LayoutParams(-1,0,1));
    }
        void createInputBar() {

        LinearLayout inputBar = new LinearLayout(this);
        inputBar.setOrientation(LinearLayout.HORIZONTAL);
        inputBar.setGravity(Gravity.CENTER_VERTICAL);
        inputBar.setPadding(16,14,16,18);

        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(40);
        bg.setColor(panel);
        inputBar.setBackground(bg);

        TextView plus = text("＋",26,white);

        input = new EditText(this);
        input.setHint("Message Nexora...");
        input.setHintTextColor(Color.GRAY);
        input.setTextColor(white);
        input.setBackgroundColor(Color.TRANSPARENT);

        LinearLayout.LayoutParams inputLp =
                new LinearLayout.LayoutParams(0,-2,1);

        TextView send = text("➤",24,white);
        send.setGravity(Gravity.CENTER);

        GradientDrawable sendBg = new GradientDrawable();
        sendBg.setShape(GradientDrawable.OVAL);
        sendBg.setColor(purple);
        send.setBackground(sendBg);
        send.setPadding(20,18,20,18);

        send.setOnClickListener(v -> {

            String msg = input.getText().toString().trim();

            if(msg.isEmpty()) return;

            addUserMessage(msg);
            input.setText("");

            addBotMessage("✨ Thinking...\n\nI received: " + msg);

            scrollView.post(() ->
                scrollView.fullScroll(View.FOCUS_DOWN)
            );
        });

        inputBar.addView(plus);
        inputBar.addView(input,inputLp);
        inputBar.addView(send);

        root.addView(inputBar);
    }

    void addUserMessage(String msg){

        TextView tv = bubble(msg,purple,white);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.END;
        lp.setMargins(70,10,0,10);

        chatContainer.addView(tv,lp);
    }

    void addBotMessage(String msg){

        TextView tv = bubble(msg,panel,soft);

        LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(-2,-2);
        lp.gravity = Gravity.START;
        lp.setMargins(0,10,70,10);

        chatContainer.addView(tv,lp);
    }

    TextView bubble(String text,int bgColor,int txtColor){

        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextColor(txtColor);
        tv.setTextSize(16);
        tv.setPadding(24,16,24,16);

        GradientDrawable bg = new GradientDrawable();
        bg.setCornerRadius(28);
        bg.setColor(bgColor);

        tv.setBackground(bg);

        return tv;
    }

    TextView text(String value,float size,int color){

        TextView t = new TextView(this);
        t.setText(value);
        t.setTextSize(size);
        t.setTextColor(color);

        return t;
    }
}
    
