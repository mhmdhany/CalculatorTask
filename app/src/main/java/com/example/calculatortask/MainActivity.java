package com.example.calculatortask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;


import com.example.calculatortask.R;
import com.example.calculatortask.databinding.ActivityMainBinding;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {

    private String process;
    boolean checkBracket = false;
    //DataBinding
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Call each Method
        setupNumbers();
        setupOperations();
        setupEqual();

    }

    //Setup Operation on Numbers
    void setupOperations() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "+");
            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "-");
            }
        });
        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "x");
            }
        });
        binding.btnDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "÷");
            }
        });
        binding.btnBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkBracket) {
                    process = binding.tvInput.getText().toString();
                    binding.tvInput.setText(process + ")");
                    checkBracket = false;
                } else {
                    process = binding.tvInput.getText().toString();
                    binding.tvInput.setText(process + "(");
                    checkBracket = true;
                }
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.tvInput.setText("");
                binding.tvOutput.setText("");
            }
        });
    }

    //Setup Equal
    void setupEqual() {
        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                process = process.replaceAll("x", "*");
                process = process.replaceAll("÷", "/");

                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                String finalReuslt = "";

                try {
                    Scriptable scriptable = context.initStandardObjects();
                    finalReuslt = context.evaluateString(scriptable, process, "javascript" ,1, null).toString();
                } catch (Exception e) {
                    finalReuslt = "0";
                }
                binding.tvOutput.setText(finalReuslt);
            }

        });
    }


    //Setup Numbers from 0 to 9
    void setupNumbers() {
        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "0");
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "6");
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + "9");
            }
        });
        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = binding.tvInput.getText().toString();
                binding.tvInput.setText(process + ".");
            }
        });
    }

}

