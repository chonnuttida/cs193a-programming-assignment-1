// Chonnuttida Koracharkornradt <kchonnut@stanford.edu>
// TipApplication - This app let the user input total cost and hit enter,
// then the user can choose how much he/she want to tip and/or
// how many people he/she want to split the cost,
// then display in pink text at the center of the screen
// The user can input new total cost and hit enter again.
// Note: I use Nexus_5 as an emulator.

package com.example.chonnuttida.tipapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // Instance variables
    private double total;
    private double newTotal;
    private double tip;
    private int split;
    private EditText newTotalText;
    private TextView displayTipText;
    private TextView displaySplitText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tip = 0;
        split = 1;
        newTotalText = (EditText) findViewById(R.id.displayNewTotal);
        displayTipText = (TextView) findViewById(R.id.displayTip);
        displaySplitText = (TextView) findViewById(R.id.displaySplit);
    }

    public void enterClick(View view) {
        TextView displayTotalText = (TextView) findViewById(R.id.displayTotal);
        String inputTotal = newTotalText.getText().toString();
        total = Double.valueOf(inputTotal);
        displayTotalText.setText("Total Cost: " + inputTotal);
        // In case the user input new total cost and hit enter again (not the first time),
        // clear the old display
        displayTipText.setText("");
        displaySplitText.setText("");
    }

    public void fifteenTipClick(View view) {
        tip = 15;
        calculateNewTotal();
    }

    public void twentyTipClick(View view) {
        tip = 20;
        calculateNewTotal();
    }

    public void plusFiveTipClick(View view) {
        tip += 5;
        calculateNewTotal();
    }

    public void minusFiveTipClick(View view) {
        if (tip >= 5) {
            tip -= 5;
            calculateNewTotal();
        }
    }

    // Calculate new total cost with selected amount of tips and people to split,
    // then display the new total cost, tip text, and split text
    private void calculateNewTotal() {
        newTotal = (total + (total * (tip / 100))) / split;
        newTotalText.setText(String.valueOf(newTotal));
        displayTipText.setText("+" + String.valueOf(tip) + "% tips");
        displaySplitText.setText("/" + String.valueOf(split) +" people");
    }

    public void twoSplitClick(View view) {
        split = 2;
        calculateNewTotal();
    }

    public void fourSplitClick(View view) {
        split = 4;
        calculateNewTotal();
    }

    public void plusOneSplitClick(View view) {
        split += 1;
        calculateNewTotal();
    }

    public void minusOneSplitClick(View view) {
        if (split > 1) {
            split -= 1;
            calculateNewTotal();
        }
    }
}
