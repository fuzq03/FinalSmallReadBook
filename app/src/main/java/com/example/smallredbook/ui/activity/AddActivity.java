package com.example.smallredbook.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ImageView;

import com.example.smallredbook.R;

public class AddActivity extends AppCompatActivity {

    public static final int CHOOSE_PHOTO = 1;
    public static int ALBUM_RESULT_CODE = 0x999;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        //overridePendingTransition(0, 0);

        if(ActivityCompat.checkSelfPermission(AddActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(AddActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        }
        imageView = (ImageView)findViewById(R.id.add_picture);
        openSysAlbum();
        Log.d("Here", "add activity");
    }


    private void openSysAlbum() {
        Intent albumIntent = new Intent(Intent.ACTION_PICK);
        albumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(albumIntent, ALBUM_RESULT_CODE);
    }

    private void handleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if(DocumentsContract.isDocumentUri(this, uri)) {
            //如果是document类型的uri,则通过document id处理
            String docId = DocumentsContract.getDocumentId(uri);
            if("com.android.providers.media.documents".equals(uri.getAuthority())) {
                String id = docId.split(":")[1];
                //解析出数字格式的id
                String selection = MediaStore.Images.Media._ID + "=" + id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, selection);
            } else if("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(docId));
                imagePath = getImagePath(contentUri, null);
            }

        } else if("content".equalsIgnoreCase(uri.getScheme())) {
            //如果是content类型的Uri，则使用普通方式处理
            imagePath = getImagePath(uri, null);
        } else if("file".equalsIgnoreCase(uri.getScheme())) {
            //如果是file类型的Uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        //根据图片路径显示图片
        displayImage(imagePath);
        System.out.println(imagePath);
    }

    @SuppressLint("Range")
    private String getImagePath(Uri uri, String selection ) {
         String path = null;
         Cursor cursor = getContentResolver().query(uri, null, selection, null, null);
         if(cursor != null) {
             if(cursor.moveToFirst()) {
                 path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
             }
             cursor.close();
         }
         return path;
    }

    //展示圖片
    private void displayImage(String imagePath) {
        Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
        imageView.setImageBitmap(bitmap);
    }
}