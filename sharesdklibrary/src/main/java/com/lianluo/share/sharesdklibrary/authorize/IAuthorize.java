package com.lianluo.share.sharesdklibrary.authorize;


import com.lianluo.share.sharesdklibrary.sdk.IResult;
import com.lianluo.share.sharesdklibrary.sdk.OnCallback;

/**
 * Created by ezy on 17/3/18.
 */

public interface IAuthorize extends IResult {
    void authorize(OnCallback<String> callback);
}
