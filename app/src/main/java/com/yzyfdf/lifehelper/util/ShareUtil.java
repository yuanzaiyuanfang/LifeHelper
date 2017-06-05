package com.yzyfdf.lifehelper.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Environment;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.blankj.utilcode.utils.ScreenUtils;
import com.jaydenxiao.common.commonutils.LogUtils;
import com.yzyfdf.lifehelper.app.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public class ShareUtil {
    /**
     * 截取scrollview的屏幕
     **/
    public static Bitmap getScrollViewBitmap(ScrollView scrollView) {
        int h = 0;
        Bitmap bitmap;
        for (int i = 0; i < scrollView.getChildCount(); i++) {
            h += scrollView.getChildAt(i).getHeight();
        }
        // 创建对应大小的bitmap

        bitmap = Bitmap.createBitmap(ScreenUtils.getScreenWidth(), h,
                Bitmap.Config.ARGB_4444);
        final Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.parseColor("#f2f7fa"));
        scrollView.draw(canvas);
        return bitmap;
    }

    /**
     * 生成某个view的图片
     *
     * @author gengqiquan
     * @date 2017/3/20 上午10:34
     */
    public static Bitmap getViewDrawingCacheBitmap(View view) {
        view = view.getRootView();
        if (!view.isDrawingCacheEnabled()) {
            view.setDrawingCacheEnabled(true);
        }
        view.destroyDrawingCache();
        view.buildDrawingCache();
        Bitmap bm = view.getDrawingCache();
        view.setDrawingCacheEnabled(false);
        return bm;
    }

    /**
     * 生成某个LinearLayout的图片
     *
     * @author gengqiquan
     * @date 2017/3/20 上午10:34
     */
    public static Bitmap getLinearLayoutBitmap(LinearLayout linearLayout) {
        int h = 0;
        // 获取LinearLayout实际高度
        for (int i = 0; i < linearLayout.getChildCount(); i++) {
            View childAt = linearLayout.getChildAt(i);
            childAt.measure(0, 0);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            h += childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        linearLayout.measure(0, 0);

        // 创建对应大小的bitmap
        int measuredWidth = linearLayout.getMeasuredWidth();
        int measuredHeight = linearLayout.getMeasuredHeight();
        Bitmap bitmap = null;
        try {
            bitmap = Bitmap.createBitmap(measuredWidth * measuredHeight / h, h,
                    Bitmap.Config.RGB_565);
        } catch (OutOfMemoryError error) {
            LogUtils.logv(error.toString());
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                bitmap = null;
            }
            return null;
        }

        Canvas canvas = new Canvas(bitmap);
        canvas.drawColor(Color.WHITE);
        linearLayout.draw(canvas);

        Bitmap mFreeBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
        canvas.setBitmap(mFreeBitmap);

        return bitmap;
    }

    public static boolean saveMyBitmap(Bitmap bitmap, String path, String name) {

        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File f = new File(dir, name);
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

        bitmap.compress(Bitmap.CompressFormat.JPEG, 10, fOut);
        try {
            fOut.flush();
            fOut.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


    /*
     * 获取文件路径
	 */
    public static String getFileDir(String fileTypeDir) {

        File fileDir;
        if (existSDCard()) {
            fileDir = new File(Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + File.separator
                    + Constant.PACKAGE_NAME + File.separator
                    + fileTypeDir);
        } else {
            fileDir = new File(Environment.getDownloadCacheDirectory()
                    .getAbsolutePath() + File.separator
                    + Constant.PACKAGE_NAME + File.separator
                    + fileTypeDir);
        }
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir.getAbsolutePath();
    }

    private static boolean existSDCard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else
            return false;
    }


}
