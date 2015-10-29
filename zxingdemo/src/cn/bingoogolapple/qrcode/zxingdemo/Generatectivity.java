package cn.bingoogolapple.qrcode.zxingdemo;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import cn.bingoogolapple.qrcode.core.DisplayUtils;
import cn.bingoogolapple.qrcode.zxing.EncodingHandler;

import com.google.zxing.WriterException;

public class Generatectivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        setQrcode1();
        setQrcode2();
    }


    private void setQrcode1() {
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                try {
                    return EncodingHandler.createQRCode("王浩", (int) DisplayUtils.dp2px(Generatectivity.this, 200));
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    ((ImageView)findViewById(R.id.iv_qrcode1)).setImageBitmap(bitmap);
                }
            }
        }.execute();
    }

    private void setQrcode2() {
        new AsyncTask<Void, Void, Bitmap>() {

            @Override
            protected Bitmap doInBackground(Void... params) {
                try {
                    return EncodingHandler.createQRCode("bingoogolapple", (int) DisplayUtils.dp2px(Generatectivity.this, 200), Color.parseColor("#00ff00"));
                } catch (WriterException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                if (bitmap != null) {
                    ((ImageView)findViewById(R.id.iv_qrcode2)).setImageBitmap(bitmap);
                }
            }
        }.execute();
    }
}