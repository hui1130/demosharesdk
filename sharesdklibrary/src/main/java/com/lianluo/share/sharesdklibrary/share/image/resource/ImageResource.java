package com.lianluo.share.sharesdklibrary.share.image.resource;

import android.graphics.Bitmap;

public interface ImageResource {

    String toUri();

    Bitmap toBitmap();

    byte[] toBytes();
}