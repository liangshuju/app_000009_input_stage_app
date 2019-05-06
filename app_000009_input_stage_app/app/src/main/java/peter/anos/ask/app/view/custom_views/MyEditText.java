package peter.anos.ask.app.view.custom_views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

@SuppressLint("AppCompatCustomView")
public class MyEditText extends EditText {

    private static final String TAG = "input_stage";

    public MyEditText(Context context) {
        super(context);
    }

    public MyEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //public MyEditText(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        //super(context, attrs, defStyleAttr, defStyleRes);
    //}

    private String getKeyStatus(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            return "down";
        } else {
            return "up";
        }
    }

    // 输入a，显示b
    public KeyEvent createAnotherKeyEvent(KeyEvent event) {
        return new KeyEvent(event.getDownTime(), event.getEventTime(), event.getAction(), event.getKeyCode() + 1,
                event.getRepeatCount(), event.getMetaState(), event.getDeviceId(), event.getScanCode());
    }

    @Override
    public boolean onKeyPreIme(int keyCode, KeyEvent event) {
        Log.i(TAG, "MyEditText : onKeyPreIme keycode = " + keyCode + " " + getKeyStatus(event));
        return super.onKeyPreIme(keyCode, event);
        // return true; // 没有任何输入内容，直接返回true了，因为在输入法之前已经处理完了
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.i(TAG, "MyEditText : onKeyDown keycode = " + keyCode + " " + getKeyStatus(event));

        return super.onKeyDown(keyCode, event);
        // return super.onKeyDown(keyCode + 1, createAnotherKeyEvent(event));

        // return  false;

    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.i(TAG, "MyEditText : onKeyUp keycode = " + keyCode + " " + getKeyStatus(event));
        return super.onKeyUp(keyCode, event);
    }

}
