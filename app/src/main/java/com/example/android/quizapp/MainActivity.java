package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitQuiz(View view) {
        EditText editQuestion1Text = (EditText) findViewById(R.id.question_1_edit_text);
        Editable editQuestion1Editable = editQuestion1Text.getText();
        String editQuestion1Value = editQuestion1Editable.toString();

        EditText editQuestion2Text = (EditText) findViewById(R.id.question_2_edit_text);
        Editable editQuestion2Editable = editQuestion2Text.getText();
        String editQuestion2Value = editQuestion2Editable.toString();

        EditText editQuestion3Text = (EditText) findViewById(R.id.question_3_edit_text);
        Editable editQuestion3Editable = editQuestion3Text.getText();
        String editQuestion3Value = editQuestion3Editable.toString();

        int textPoint = calculateTextPoint(editQuestion1Value, editQuestion2Value, editQuestion3Value);

        RadioButton radioQuestion4Checked = (RadioButton) findViewById(R.id.question_4_radio_2);
        boolean radioQuestion4IsChecked = radioQuestion4Checked.isChecked();

        RadioButton radioQuestion5Checked = (RadioButton) findViewById(R.id.question_5_radio_2);
        boolean radioQuestion5IsChecked = radioQuestion5Checked.isChecked();

        RadioButton radioQuestion6Checked = (RadioButton) findViewById(R.id.question_6_radio_1);
        boolean radioQuestion6IsChecked = radioQuestion6Checked.isChecked();

        RadioButton radioQuestion7Checked = (RadioButton) findViewById(R.id.question_7_radio_1);
        boolean radioQuestion7IsChecked = radioQuestion7Checked.isChecked();

        RadioButton radioQuestion8Checked = (RadioButton) findViewById(R.id.question_8_radio_2);
        boolean radioQuestion8IsChecked = radioQuestion8Checked.isChecked();

        CheckBox checkQuestion9Checked = (CheckBox) findViewById(R.id.question_9_checkbox_2);
        boolean checkQuestion9IsChecked = checkQuestion9Checked.isChecked();

        CheckBox checkQuestion9CheckedAgain = (CheckBox) findViewById(R.id.question_9_checkbox_3);
        boolean checkQuestion9IsCheckedAgain = checkQuestion9CheckedAgain.isChecked();

        CheckBox checkQuestion10Checked = (CheckBox) findViewById(R.id.question_10_checkbox_2);
        boolean checkQuestion10IsChecked = checkQuestion10Checked.isChecked();

        CheckBox checkQuestion10CheckedAgain = (CheckBox) findViewById(R.id.question_10_checkbox_3);
        boolean checkQuestion10IsCheckedAgain = checkQuestion10CheckedAgain.isChecked();

        int buttonPoint = calculatePoint(radioQuestion4IsChecked, radioQuestion5IsChecked, radioQuestion6IsChecked, radioQuestion7IsChecked, radioQuestion8IsChecked, checkQuestion9IsChecked, checkQuestion9IsCheckedAgain, checkQuestion10IsChecked, checkQuestion10IsCheckedAgain);

        quizSummaryDisplay(textPoint, buttonPoint);

        int totalPointForToast = textPoint + buttonPoint;
        Toast.makeText(this, "Your total score is " + totalPointForToast, Toast.LENGTH_SHORT).show();
    }

    private int calculatePoint(boolean rQ4, boolean rQ5, boolean rQ6, boolean rQ7, boolean rQ8, boolean cQ9, boolean cQ9a, boolean cQ10, boolean cQ10a) {
        int basePoint = 0;

        if (rQ4) {
            basePoint = basePoint + 1;
        }
        if (rQ5) {
            basePoint = basePoint + 1;
        }
        if (rQ6) {
            basePoint = basePoint + 1;
        }
        if (rQ7) {
            basePoint = basePoint + 1;
        }
        if (rQ8) {
            basePoint = basePoint + 1;
        }
        if (cQ9) {
            basePoint = basePoint + 1;
        }
        if (cQ9a) {
            basePoint = basePoint + 1;
        }
        if (cQ10) {
            basePoint = basePoint + 1;
        }
        if (cQ10a) {
            basePoint = basePoint + 1;
        }
        return basePoint;

    }

    private int calculateTextPoint(String eQ1, String eQ2, String eQ3) {
        int baseTextPoint = 0;

        if ("มกราคม".equals(eQ1)) {
            baseTextPoint = baseTextPoint + 1;
        }
        if ("กุมภาพันธ์".equals(eQ2)) {
            baseTextPoint = baseTextPoint + 1;
        }
        if ("มีนาคม".equals(eQ3)) {
            baseTextPoint = baseTextPoint + 1;
        }
        return baseTextPoint;

    }

    private void quizSummaryDisplay(int textPoint, int buttonPoint) {
        TextView totalPointToText = (TextView) findViewById(R.id.total_point_text);
        totalPointToText.setText(String.valueOf(textPoint + buttonPoint));
    }
}