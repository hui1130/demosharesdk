package com.lianluo.share.sharesdklibrary.share.image.resource;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

import com.lianluo.share.sharesdklibrary.share.image.ImageTool;

public class DrawableResource implements ImageResource {
    public final Drawable drawable;

    public DrawableResource(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public String toUri() {
        return null;
    }

    @Override
    public Bitmap toBitmap() {
        return ImageTool.toBitmap(drawable);
    }

    @Override
    public byte[] toBytes() {
        return ImageTool.toBytes(ImageTool.toBitmap(drawable), Bitmap.CompressFormat.JPEG);
    }
}