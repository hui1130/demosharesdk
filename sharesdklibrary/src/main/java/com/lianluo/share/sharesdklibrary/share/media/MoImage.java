package com.lianluo.share.sharesdklibrary.share.media;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.lianluo.share.sharesdklibrary.share.image.resource.BitmapResource;
import com.lianluo.share.sharesdklibrary.share.image.resource.BytesResource;
import com.lianluo.share.sharesdklibrary.share.image.resource.FileResource;
import com.lianluo.share.sharesdklibrary.share.image.resource.ImageResource;
import com.lianluo.share.sharesdklibrary.share.image.resource.UrlResource;

import java.io.File;

public class MoImage implements IMediaObject {

    public ImageResource resource;

    public MoImage(@NonNull ImageResource resource) {
        this.resource = resource;
    }

    public MoImage(String url) {
        resource = new UrlResource(url);
    }

    public MoImage(File file) {
        resource = new FileResource(file);
    }

    public MoImage(byte[] bytes) {
        resource = new BytesResource(bytes);
    }

    public MoImage(Bitmap bitmap) {
        resource = new BitmapResource(bitmap);
    }


    @Override
    public int type() {
        return TYPE_IMAGE;
    }

    public String toUri() {
        return resource.toUri();
    }

    public byte[] toBytes() {
        return resource.toBytes();
    }
}