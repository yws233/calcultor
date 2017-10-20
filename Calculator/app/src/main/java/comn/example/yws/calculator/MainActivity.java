package comn.example.yws.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;


public class MainActivity extends AppCompatActivity implements OnClickListener{

    TextView textView;              //运算过程显示栏
    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8,
            btn_9, btn_0, btn_jia, btn_jian, btn_equals, btn_clear, btn_chu,
            btn_cheng, btn_dian;  //各个按钮
    private EditText et_show;       //EditText显示栏
    public int flag = 0;            //判断是加减乘除
    private String text1 = "0",     //获得输入的第一个数
            text2 = "0";            //获得输入的第二个数

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("计算器");
        initEnc();
        initListener();
    }

    /**
     * 初始化各控件，获取各控件
     */
    public void initEnc(){
        et_show = findViewById(R.id.et_show);
        btn_0 = findViewById(R.id.btn_0);
        btn_1 = findViewById(R.id.btn_1);
        btn_2 = findViewById(R.id.btn_2);
        btn_3 = findViewById(R.id.btn_3);
        btn_4 = findViewById(R.id.btn_4);
        btn_5 = findViewById(R.id.btn_5);
        btn_6 = findViewById(R.id.btn_6);
        btn_7 = findViewById(R.id.btn_7);
        btn_8 = findViewById(R.id.btn_8);
        btn_9 = findViewById(R.id.btn_9);
        btn_jia = findViewById(R.id.btn_jia);
        btn_jian = findViewById(R.id.btn_jian);
        btn_cheng = findViewById(R.id.btn_cheng);
        btn_chu = findViewById(R.id.btn_chu);
        btn_equals = findViewById(R.id.btn_equals);
        btn_clear = findViewById(R.id.btn_clear);
        btn_dian = findViewById(R.id.btn_dian);
        textView = findViewById(R.id.text_show);
    }

    /**
     * 初始化监听器
     */
    public void initListener(){

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
        btn_jia.setOnClickListener(this);
        btn_jian.setOnClickListener(this);
        btn_cheng.setOnClickListener(this);
        btn_chu.setOnClickListener(this);
        btn_dian.setOnClickListener(this);
        btn_equals.setOnClickListener(this);
    }

    /**
     *
     * 点击事件
     */
    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_0:
                et_show.append("0");
                textView.setText("0");
                break;
            case R.id.btn_1:
                et_show.append("1");
                textView.setText("1");
                break;
            case R.id.btn_2:
                et_show.append("2");
                textView.setText("2");
                break;
            case R.id.btn_3:
                et_show.append("3");
                textView.setText("3");
                break;
            case R.id.btn_4:
                et_show.append("4");
                textView.setText("4");
                break;
            case R.id.btn_5:
                et_show.append("5");
                textView.setText("5");
                break;
            case R.id.btn_6:
                et_show.append("6");
                textView.setText("6");
                break;
            case R.id.btn_7:
                et_show.append("7");
                textView.setText("7");
                break;
            case R.id.btn_8:
                et_show.append("8");
                textView.setText("8");
                break;
            case R.id.btn_9:
                et_show.append("9");
                textView.setText("9");
                break;

            case R.id.btn_dian:
                et_show.append(".");
                textView.setText(".");
                break;
            case R.id.btn_jia:
                flag = 1;
                textView.append("+");
                text1 = et_show.getText().toString();
                et_show.setText("");
                break;
            case R.id.btn_jian:
                flag = 2;
                textView.append("-");
                text1 = et_show.getText().toString();
                et_show.setText("");
                break;
            case R.id.btn_cheng:
                flag = 3;
                textView.append("*");
                text1 = et_show.getText().toString();
                et_show.setText("");
                break;
            case R.id.btn_chu:
                flag = 4;
                textView.append("/");
                text1 = et_show.getText().toString();
                et_show.setText("");
                break;

                //对运算结果进行判断
            case R.id.btn_equals:

                //点击“=”按钮，创建数据库
                LitePal.getDatabase();
                //结果表映射类
                Result result = new Result();

                switch (flag) {
                    case 0:
                        et_show.append("0");
                        break;
                    case 1:
                        text2 = et_show.getText().toString();
                        Double res = Double.parseDouble(text1)
                                + Double.parseDouble(text2);
                        CharSequence r = res.toString();
                        et_show.setText(r);
                        textView.setText(text1+"+"+text2+"="+r);
                        result.setResult((String) r);
                        result.save();//强转并储存结果
                        break;
                    case 2:
                        text2 = et_show.getText().toString();
                        textView.append(text2);
                        Double res2 = (Double.parseDouble(text1) - Double
                                .parseDouble(text2));
                        CharSequence r2 = res2.toString();
                        et_show.setText(r2);
                        textView.setText(text1+"-"+text2+"="+r2);
                        result.setResult((String) r2);
                        result.save();
                        break;
                    case 3:

                        text2 = et_show.getText().toString();
                        textView.append(text2);
                        Double res3 = Double.parseDouble(text1)
                                * Double.parseDouble(text2);
                        // et_show.setText("flag=3");
                        CharSequence r3 = res3.toString();
                        et_show.setText(r3);
                        textView.setText(text1+"*"+text2+"="+r3);
                        result.setResult((String) r3);
                        result.save();
                        break;
                    case 4:
                        text2 = et_show.getText().toString();
                        textView.append(text2);
                        Double res4 = Double.parseDouble(text1)
                                / Double.parseDouble(text2);
                        //对输入除数进行判断
                        if (text2.equals("0")){
                            textView.setText("sorry,...");
                            break;
                        }
                        CharSequence r4 = res4.toString();
                        et_show.setText(r4);
                        textView.setText(text1+"/"+text2+"="+r4);
                        result.setResult((String) r4);
                        result.save();
                        break;

                    default:
                        break;
                }
                break;
            case R.id.btn_clear:
                clear();
                break;
            default:
                break;
        }
    }

    /**
     * 运算完成后，对过程工具栏及显示栏进行清空处理
     */
    public void clear(){
        flag = 0;
        text1 = "0";
        text2 = "0";
        et_show.setText("");
        textView.setText("");
    }
}