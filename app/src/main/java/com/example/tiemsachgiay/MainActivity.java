package com.example.tiemsachgiay;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    private LinearLayout bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookList = findViewById(R.id.bookList);
        showBooks();
    }

    private void showBooks() {
        addBook("Đắc Nhân Tâm", "Dale Carnegie", "85.000đ", "Kỹ năng sống");
        addBook("Nhà Giả Kim", "Paulo Coelho", "79.000đ", "Tiểu thuyết");
        addBook("Tuổi Trẻ Đáng Giá Bao Nhiêu", "Rosie Nguyễn", "70.000đ", "Phát triển bản thân");
        addBook("Dế Mèn Phiêu Lưu Ký", "Tô Hoài", "45.000đ", "Văn học");
        addBook("Cho Tôi Xin Một Vé Đi Tuổi Thơ", "Nguyễn Nhật Ánh", "68.000đ", "Văn học");
        addBook("Tư Duy Nhanh Và Chậm", "Daniel Kahneman", "150.000đ", "Tâm lý học");
    }

    private void addBook(String title, String author, String price, String category) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.WHITE);
        background.setCornerRadius(dp(12));
        background.setStroke(dp(1), Color.rgb(230, 230, 230));
        card.setBackground(background);

        TextView titleView = new TextView(this);
        titleView.setText(title);
        titleView.setTextColor(Color.rgb(40, 40, 40));
        titleView.setTextSize(18);
        titleView.setTypeface(null, Typeface.BOLD);

        TextView authorView = new TextView(this);
        authorView.setText("Tác giả: " + author);
        authorView.setTextColor(Color.DKGRAY);
        authorView.setTextSize(14);
        authorView.setPadding(0, dp(6), 0, 0);

        TextView categoryView = new TextView(this);
        categoryView.setText("Thể loại: " + category);
        categoryView.setTextColor(Color.GRAY);
        categoryView.setTextSize(14);
        categoryView.setPadding(0, dp(4), 0, 0);

        TextView priceView = new TextView(this);
        priceView.setText("Giá: " + price);
        priceView.setTextColor(Color.rgb(180, 45, 45));
        priceView.setTextSize(16);
        priceView.setTypeface(null, Typeface.BOLD);
        priceView.setPadding(0, dp(8), 0, 0);

        card.addView(titleView);
        card.addView(authorView);
        card.addView(categoryView);
        card.addView(priceView);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 0, 0, dp(12));
        bookList.addView(card, params);
    }

    private int dp(int value) {
        return (int) (value * getResources().getDisplayMetrics().density + 0.5f);
    }
}
