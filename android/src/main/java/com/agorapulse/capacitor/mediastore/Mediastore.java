package com.agorapulse.capacitor.mediastore;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;

import java.io.FileOutputStream;

public class Mediastore {
    public String saveImage(Context context, String filename, String content) throws Exception {
        return saveToMediaStore(context, filename, "image/*", MediaStore.Images.Media.EXTERNAL_CONTENT_URI, content);
    }

    public String saveDocument(Context context, String filename, String mimeType, String content) throws Exception {
        return saveToMediaStore(context, filename, mimeType, MediaStore.Downloads.EXTERNAL_CONTENT_URI, content);
    }

    private String saveToMediaStore(Context context, String filename, String mimeType, Uri collection, String content) throws Exception {
        byte[] data = content.getBytes();
        ContentResolver resolver = context.getContentResolver();

        ContentValues values = new ContentValues();
        values.put(MediaStore.MediaColumns.DISPLAY_NAME, filename);
        values.put(MediaStore.MediaColumns.MIME_TYPE, mimeType);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.put(MediaStore.MediaColumns.IS_PENDING, 1);
        }

        Uri item = resolver.insert(collection, values);
        try (FileOutputStream out = (FileOutputStream) resolver.openOutputStream(item)) {
            out.write(data);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            values.clear();
            values.put(MediaStore.MediaColumns.IS_PENDING, 0);
            resolver.update(item, values, null, null);
        }

        return item.toString();
    }
} 