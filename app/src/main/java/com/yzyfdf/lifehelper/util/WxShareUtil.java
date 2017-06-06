package com.yzyfdf.lifehelper.util;

import android.graphics.Bitmap;

import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.yzyfdf.lifehelper.ui.other.activity.SplashActivity;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class WxShareUtil {
    public static void shareWebpage(String url, String title) {
        WXWebpageObject webpageObject = new WXWebpageObject();
        webpageObject.webpageUrl = url;

        WXMediaMessage mediaMessage = new WXMediaMessage(webpageObject);
        mediaMessage.title = title;

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = mediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;

        if (SplashActivity.mWXAPI != null) {
            SplashActivity.mWXAPI.sendReq(req);
        }
    }

    public static void shareImage(Bitmap bitmap) {
        WXImageObject imageObject = new WXImageObject(bitmap);

        WXMediaMessage mediaMessage = new WXMediaMessage();
        mediaMessage.mediaObject = imageObject;

        Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, true);
        bitmap.recycle();
        mediaMessage.thumbData = WxUtil.bmpToByteArray(scaledBitmap, true);

        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = String.valueOf(System.currentTimeMillis());
        req.message = mediaMessage;
        req.scene = SendMessageToWX.Req.WXSceneSession;

        if (SplashActivity.mWXAPI != null) {
            SplashActivity.mWXAPI.sendReq(req);
        }
    }
}
