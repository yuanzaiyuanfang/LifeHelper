package com.yzyfdf.lifehelper.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.blankj.utilcode.utils.ToastUtils;
import com.yzyfdf.lifehelper.app.Constant;
import com.yzyfdf.lifehelper.bean.read.DouBanDetailsBean;
import com.yzyfdf.lifehelper.ui.read.activity.HttpActivity;

import java.util.List;

/**
 * Created by JuQiu
 * on 16/6/24.
 */

public class OWebView extends WebView {


    private Context mContext;

    public OWebView(Context context) {
        super(context);
        init();
    }

    public OWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public OWebView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    public OWebView(Context context, AttributeSet attrs, int defStyleAttr, boolean privateBrowsing) {
        super(context, attrs, defStyleAttr, privateBrowsing);
        init();
    }

    @SuppressLint({"AddJavascriptInterface", "SetJavaScriptEnabled"})
    private void init() {
        setClickable(false);
        setFocusable(false);

        setHorizontalScrollBarEnabled(false);

        WebSettings settings = getSettings();
        settings.setDefaultFontSize(18);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setJavaScriptEnabled(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //这里的监听主要的作用是点击图片,有点击事件
            addJavascriptInterface(new OnWebViewImageListener() {
                @Override
                @JavascriptInterface
                public void showImagePreview(String bigImageUrl) {
                    if (!TextUtils.isEmpty(bigImageUrl)) {
                        //                        OSCPhotosActivity.showImagePreview(getContext(), bigImageUrl);
                        ToastUtils.showShortToast("图片被点击了" + bigImageUrl);

                    }
                }
            }, "mWebViewImageListener");
        }
    }

    public void loadDetailDataAsync(Object content, int type, Runnable finishCallback, OnWebViewTitleListener titleListener) {
        setWebChromeClient(new OWebChromeClient(titleListener));
        setWebViewClient(new OWebClient(finishCallback));
        if (mContext == null)
            mContext = getContext();

        String body = "";
        switch (type) {
            case Constant.TYPE_ZHIHU:
                body = convertZhihuContent(((String) content));
                break;
            case Constant.TYPE_DOUBAN:
                body = convertDoubanContent(((DouBanDetailsBean) content));
                break;
            case Constant.TYPE_GUOKE:
                body = convertGuokrContent(((String) content));
                break;
            default:
                break;
        }

        loadDataWithBaseURL("", body, "text/html", "UTF-8", "");

    }


    @Override
    public void destroy() {
        setWebViewClient(null);

        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(false);

        removeJavascriptInterface("mWebViewImageListener");
        removeAllViewsInLayout();

        removeAllViews();
        clearCache(true);
        System.out.println("浏览器关闭");
        super.destroy();
    }

    //    @Override
    //    public boolean dispatchKeyEvent(KeyEvent event) {
    //        if(event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0){
    //            if(canGoBack()){
    //                goBack();
    //                return true;
    //            }
    //        }
    //        return super.dispatchKeyEvent(event);
    //    }
    //


    private String convertZhihuContent(String preResult) {

        preResult = preResult.replace("<div class=\"img-place-holder\">", "");
        preResult = preResult.replace("<div class=\"headline\">", "");

        // 添加点击图片放大支持
        //        preResult = preResult.replaceAll("(<img[^>]+src=\")(\\S+)\"",
        //                    "$1$2\" onClick=\"javascript:mWebViewImageListener.showImagePreview('$2')\"");

        // 在api中，css的地址是以一个数组的形式给出，这里需要设置
        // in fact,in api,css addresses are given as an array
        // api中还有js的部分，这里不再解析js
        // javascript is included,but here I don't use it
        // 不再选择加载网络css，而是加载本地assets文件夹中的css
        // use the css file from local assets folder,not from network
        String css = "<link rel=\"stylesheet\" href=\"file:///android_asset/zhihu_daily.css\" type=\"text/css\">";


        // 根据主题的不同确定不同的加载内容
        // load content judging by different theme
        String theme = "<body className=\"\" onload=\"onLoaded()\">";
        if ((mContext.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES) {
            theme = "<body className=\"\" onload=\"onLoaded()\" class=\"night\">";
        }

        return new StringBuilder()
                .append("<!DOCTYPE html>\n")
                .append("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\">\n")
                .append("<head>\n")
                .append("\t<meta charset=\"utf-8\" />")
                .append(css)
                .append("\n</head>\n")
                .append(theme)
                .append(preResult)
                .append("</body></html>").toString();
    }

    private String convertDoubanContent(DouBanDetailsBean bean) {

        if (TextUtils.isEmpty(bean.getContent())) {
            return null;
        }
        String css;
        if ((mContext.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES) {
            css = "<link rel=\"stylesheet\" href=\"file:///android_asset/douban_dark.css\" type=\"text/css\">";
        } else {
            css = "<link rel=\"stylesheet\" href=\"file:///android_asset/douban_light.css\" type=\"text/css\">";
        }
        String content = bean.getContent();
        List<DouBanDetailsBean.PhotosBean> photosBeanList = bean.getPhotos();
        for (int i = 0; i < photosBeanList.size(); i++) {
            String old = "<img id=\"" + photosBeanList.get(i).getTag_name() + "\" />";
            String newStr = "<img id=\"" + photosBeanList.get(i).getTag_name() + "\" "
                    + "src=\"" + photosBeanList.get(i).getMedium().getUrl() + "\"/>";
            content = content.replace(old, newStr);
        }
        StringBuilder builder = new StringBuilder();
        builder.append("<!DOCTYPE html>\n");
        builder.append("<html lang=\"ZH-CN\" xmlns=\"http://www.w3.org/1999/xhtml\">\n");
        builder.append("<head>\n<meta charset=\"utf-8\" />\n");
        builder.append(css);
        builder.append("\n</head>\n<body>\n");
        builder.append("<div class=\"container bs-docs-container\">\n");
        builder.append("<div class=\"post-container\">\n");
        builder.append(content);
        builder.append("</div>\n</div>\n</body>\n</html>");

        return builder.toString();
    }

    private String convertGuokrContent(String content) {
        // 简单粗暴的去掉下载的div部分
        content = content.replace("<div class=\"down\" id=\"down-footer\">\n" +
                "        <img src=\"http://static.guokr.com/apps/handpick/images/c324536d.jingxuan-logo.png\" class=\"jingxuan-img\">\n" +
                "        <p class=\"jingxuan-txt\">\n" +
                "            <span class=\"jingxuan-title\">果壳精选</span>\n" +
                "            <span class=\"jingxuan-label\">早晚给你好看</span>\n" +
                "        </p>\n" +
                "        <a href=\"\" class=\"app-down\" id=\"app-down-footer\">下载</a>\n" +
                "    </div>\n" +
                "\n" +
                "    <div class=\"down-pc\" id=\"down-pc\">\n" +
                "        <img src=\"http://static.guokr.com/apps/handpick/images/c324536d.jingxuan-logo.png\" class=\"jingxuan-img\">\n" +
                "        <p class=\"jingxuan-txt\">\n" +
                "            <span class=\"jingxuan-title\">果壳精选</span>\n" +
                "            <span class=\"jingxuan-label\">早晚给你好看</span>\n" +
                "        </p>\n" +
                "        <a href=\"http://www.guokr.com/mobile/\" class=\"app-down\">下载</a>\n" +
                "    </div>", "");

        // 替换css文件为本地文件
        content = content.replace("<link rel=\"stylesheet\" href=\"http://static.guokr.com/apps/handpick/styles/d48b771f.article.css\" />",
                "<link rel=\"stylesheet\" href=\"file:///android_asset/guokr.article.css\" />");

        // 替换js文件为本地文件
        content = content.replace("<script src=\"http://static.guokr.com/apps/handpick/scripts/9c661fc7.base.js\"></script>",
                "<script src=\"file:///android_asset/guokr.base.js\"></script>");
        if ((mContext.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK)
                == Configuration.UI_MODE_NIGHT_YES) {
            content = content.replace("<div class=\"article\" id=\"contentMain\">",
                    "<div class=\"article \" id=\"contentMain\" style=\"background-color:#212b30; color:#878787\">");
        }
        return content;
    }

    private static class OWebChromeClient extends WebChromeClient {
        private OnWebViewTitleListener mTitleListener;

        public OWebChromeClient(OnWebViewTitleListener titleListener) {
            mTitleListener = titleListener;
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            if (!TextUtils.equals("about:blank", title)) {
                mTitleListener.showTitle(title);
            }
        }
    }


    private static class OWebClient extends WebViewClient implements Runnable {
        private Runnable               mFinishCallback;
        private boolean mDone = false;

        OWebClient(Runnable finishCallback) {
            super();
            mFinishCallback = finishCallback;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            mDone = false;
            // 当webview加载2秒后强制回馈完成
            //            view.postDelayed(this, 2800);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            run();
        }

        @Override
        public synchronized void run() {
            if (!mDone) {
                mDone = true;
                if (mFinishCallback != null)
                    mFinishCallback.run();
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
//            view.loadUrl(url);
            HttpActivity.startSelf(view.getContext(),url);
            return true;
        }


        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            // TODO
            handler.cancel();
        }
    }

    public interface OnWebViewImageListener {

        /**
         * 点击webview上的图片，传入该缩略图的大图Url
         *
         * @param bigImageUrl
         */
        void showImagePreview(String bigImageUrl);

    }

    public interface OnWebViewTitleListener {

        /**
         * 标题
         *
         * @param title
         */
        void showTitle(String title);

    }

}
