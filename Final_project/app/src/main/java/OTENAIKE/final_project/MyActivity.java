package OTENAIKE.final_project;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MyActivity extends Activity {
private EditText scr;
    private float NumberBf;
    private String Operation;
    private ButtonClickListener btnClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        scr = (EditText) findViewById(R.id.editText);
        scr.setEnabled(false);

        int idList[] = {R.id.button0,R.id.button,R.id.button2,
                R.id.button3,R.id.button4,R.id.button5,R.id.buttonC,R.id.button7,
                R.id.button8,R.id.button9,R.id.buttonDot,R.id.buttonDiv,R.id.buttonAdd,R.id.buttonSub,
                R.id.buttonMul,R.id.buttonEq,R.id.buttonC};

        for (int id:idList){
            View v = (View) findViewById(id);
            v.setOnClickListener(btnClick);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }


    public void mMath(String str){
        NumberBf = Float.parseFloat(scr.getText().toString());
        Operation = str;
        scr.setText("0");
    }

    public void getKeyboard(String str){
        String scrCurrent =scr.getText().toString();
        if (scrCurrent.equals("0"))
            scrCurrent = "";
        scrCurrent +=str;
        scr.setText(scrCurrent);
    }

    public void mResult(){
        float NumAf =Float.parseFloat(scr.getText().toString());
        float result = 0;
        if (Operation.equals("+")){
            result = NumAf + NumberBf;
        }
        if (Operation.equals("-")){
            result = NumAf - NumberBf;
        }
        if (Operation.equals("*")){
            result = NumAf * NumberBf;
        }
        if (Operation.equals("/")){
            result = NumAf / NumberBf;
        }
        scr.setText(String.valueOf(result));
    }





    private class ButtonClickListener implements View.OnClickListener {
        public void onClick(View v){
            switch (v.getId()){
                case R.id.buttonC:
                    scr.setText("0");
                    NumberBf=0;
                    Operation="";
                    break;
                case R.id.buttonAdd:
                    mMath("+");
                    break;
                case R.id.buttonSub:
                    mMath("-");
                    break;
                case R.id.buttonMul:
                    mMath("*");
                    break;
                case R.id.buttonDiv:
                    mMath("/");
                    break;
                case R.id.buttonEq:
                    mResult();
                    break;
                default:
                    String numb = ((Button)v).getText().toString();
                    getKeyboard(numb);
                    break;




            }
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
