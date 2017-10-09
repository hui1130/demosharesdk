package com.lianluo.share.sharesdklibrary;

import android.app.Activity;
import android.content.Intent;

import com.lianluo.share.sharesdklibrary.authorize.IAuthorize;
import com.lianluo.share.sharesdklibrary.sdk.DefaultCallback;
import com.lianluo.share.sharesdklibrary.sdk.IFactory;
import com.lianluo.share.sharesdklibrary.sdk.OnCallback;
import com.lianluo.share.sharesdklibrary.sdk.OnSucceed;
import com.lianluo.share.sharesdklibrary.sdk.ResultCode;
import com.lianluo.share.sharesdklibrary.sdk.Sdk;

public class AuthorizeSDK {
    static Sdk<IAuthorize> sdk = new Sdk<>();

    public static void setDefaultCallback(OnCallback callback) {
        sdk.setDefaultCallback(callback);
    }

    public static <T extends IAuthorize> void register(String name, String appId, Class<T> clazz) {
        sdk.register(name, appId, clazz);
    }

    public static <T extends IAuthorize> void register(IFactory<T> factory) {
        sdk.register(factory);
    }

    public static void authorize(Activity activity, String platform, OnSucceed<String> listener) {
        authorize(activity, platform, new DefaultCallback(sdk.getDefaultCallback(), listener));
    }

    public static void authorize(Activity activity, String platform, OnCallback<String> callback) {
        if (!sdk.isSupport(platform)) {
            callback.onFailed(activity, ResultCode.RESULT_FAILED, "不支持的平台[" + platform + "]");
            return;
        }
        IAuthorize api = sdk.get(activity, platform);
        if (api == null) {
            return;
        }
        api.authorize(callback);
    }


    public static void onHandleResult(Activity activity, int requestCode, int resultCode, Intent data) {
        sdk.onHandleResult(activity, requestCode, resultCode, data);
    }
}