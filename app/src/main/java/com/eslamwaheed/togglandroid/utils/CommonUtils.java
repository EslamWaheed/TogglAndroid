package com.eslamwaheed.togglandroid.utils;

import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AlertDialog;

import com.eslamwaheed.togglandroid.R;
import com.github.ybq.android.spinkit.style.DoubleBounce;

import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;


public final class CommonUtils {

    private static final String TAG = "CommonUtils";

    private CommonUtils() {
        // This utility class is not publicly instantiable
    }

    public static String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }

    public static boolean isContainDigits(String name) {
        return name.matches(".*\\d+.*");
    }

    public static String getDeviceLanguage() {
        if (Locale.getDefault().getDisplayLanguage().equalsIgnoreCase("العربية")) {
            return "ar";
        }
        return "en";
    }

//    public static AlertDialog showFullLoadingDialog(Context context) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(context);
//        AlertDialog dialog = builder.create();
//        if (dialog.getWindow() != null) {
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        }
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View progress_layout = inflater.inflate(R.layout.progress_layout, null);
//        ProgressBar progressBar = progress_layout.findViewById(R.id.progress);
//        DoubleBounce doubleBounce = new DoubleBounce();
//        doubleBounce.setBounds(0, 0, 0, 0);
//        doubleBounce.setColor(AppConstants.LOADING_BOUNCE_COLOR);
//        progressBar.setIndeterminateDrawable(doubleBounce);
//        dialog.setView(progress_layout);
//        dialog.setCancelable(false);
//        dialog.setCanceledOnTouchOutside(false);
//        dialog.show();
//        return dialog;
//    }

    public static ProgressDialog showLoadingProgressDialog(Context context, String message) {
        ProgressDialog dialog = new ProgressDialog(context); // this = YourActivity
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage(message);
        dialog.setIndeterminate(true);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        return dialog;
    }

    public static String getPath(Uri uri, Context context) {
        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = context.getContentResolver().query(uri, projection, null, null, null);
        assert cursor != null;
        cursor.moveToFirst();
        int columnIndex = cursor.getColumnIndex(projection[0]);
        String filePath = cursor.getString(columnIndex);
        cursor.close();
        return filePath;
    }
}
