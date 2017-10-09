package com.lianluo.share.sharesdklibrary.share;

import com.lianluo.share.sharesdklibrary.sdk.IResult;
import com.lianluo.share.sharesdklibrary.sdk.OnCallback;

/**
 * Created by ezy on 17/3/18.
 */

public interface IShareable extends IResult {
    void share(ShareData data, OnCallback<String> callback);
}
