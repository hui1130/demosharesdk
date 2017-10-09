package com.lianluo.share.sharesdklibrary;

import android.support.annotation.NonNull;

import com.lianluo.share.sharesdklibrary.authorize.AuthorizeVia;
import com.lianluo.share.sharesdklibrary.platforms.qq.QQAuth;
import com.lianluo.share.sharesdklibrary.platforms.qq.TXShare;
import com.lianluo.share.sharesdklibrary.platforms.send.SendShare;
import com.lianluo.share.sharesdklibrary.platforms.weibo.WBAuth;
import com.lianluo.share.sharesdklibrary.platforms.weibo.WBShare;
import com.lianluo.share.sharesdklibrary.platforms.weixin.WXAuth;
import com.lianluo.share.sharesdklibrary.platforms.weixin.WXShare;
import com.lianluo.share.sharesdklibrary.sdk.DefaultFactory;
import com.lianluo.share.sharesdklibrary.sdk.Platform;
import com.lianluo.share.sharesdklibrary.share.ShareTo;

/**
 * Created by ezy on 17/3/18.
 */

public class PlatformConfig {

    public static void useWeibo(@NonNull String appId, @NonNull String redirectUrl) {
        Platform platform = new Platform(AuthorizeVia.Weibo, appId).extra("redirectUrl", redirectUrl);
        AuthorizeSDK.register(new DefaultFactory(platform, WBAuth.class));
        ShareSDK.register(new DefaultFactory(platform, WBShare.class));
    }

    public static void useQQ(@NonNull String appId) {
        AuthorizeSDK.register(AuthorizeVia.QQ, appId, QQAuth.class);

        ShareSDK.register(ShareTo.QQ, appId, TXShare.class);
        ShareSDK.register(ShareTo.QZone, appId, TXShare.class);
        ShareSDK.register(ShareTo.ToQQ, "", SendShare.class);
    }

    public static void useWeixin(@NonNull String appId) {
        AuthorizeSDK.register(AuthorizeVia.Weixin, appId, WXAuth.class);

        ShareSDK.register(ShareTo.WXSession, appId, WXShare.class);
        ShareSDK.register(ShareTo.WXTimeline, appId, WXShare.class);
        ShareSDK.register(ShareTo.WXFavorite, appId, WXShare.class);
        ShareSDK.register(ShareTo.ToWXSession, "", SendShare.class);
        ShareSDK.register(ShareTo.ToWXTimeline, "", SendShare.class);
    }

}
