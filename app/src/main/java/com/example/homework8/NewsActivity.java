package com.example.homework8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_articles);
        //parent Layout for adding elements
        LinearLayout linearLayout = findViewById(R.id.linearLayoutArticles);
        addArticle(linearLayout, "First article", "Description of first article");
        addArticle(linearLayout, "Second article", "Description of second article");

    }

    private void addArticle(LinearLayout linearLayout, String title, String description) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        LinearLayout linearLayoutArticle = (LinearLayout) layoutInflater.inflate(R.layout.item_articles, null);
        // set the text for the TextView in the article layout
        TextView textViewTitle = linearLayoutArticle.findViewById(R.id.textViewTitle);
        textViewTitle.setText(title);
        TextView textViewDecription = linearLayoutArticle.findViewById(R.id.textViewDescription);
        textViewDecription.setText(description);
        //add new article layout to list(head LinearLayout)
        linearLayout.addView(linearLayoutArticle);
    }
}