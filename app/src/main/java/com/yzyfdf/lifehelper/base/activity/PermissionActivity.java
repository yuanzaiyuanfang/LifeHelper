package com.yzyfdf.lifehelper.base.activity;

import android.Manifest;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;

import com.blankj.utilcode.utils.IntentUtils;
import com.blankj.utilcode.utils.StringUtils;
import com.jaydenxiao.common.base.BaseModel;
import com.jaydenxiao.common.base.BasePresenter;

import java.util.ArrayList;

/**
 * Created by SJJ .
 * 描述 ${TODO}
 */

public abstract class PermissionActivity<T extends BasePresenter, E extends BaseModel> extends BaseAppActivity<T, E> {
    private static final String TAG = "PermissionActivity";
    protected Context mContext;

    // For Android 6.0
    private PermissionsResultListener mListener;
    //申请标记值
    public static final    int               REQUEST_CODE_ASK_PERMISSIONS = 100;
    //手动开启权限requestCode
    public static final    int               SETTINGS_REQUEST_CODE        = 200;
    //拒绝权限后是否关闭界面或APP
    private                boolean           mNeedFinish                  = false;
    //界面传递过来的权限列表,用于二次申请
    private                ArrayList<String> mPermissionsList             = new ArrayList<>();
    //必要全选,如果这几个权限没通过的话,就无法使用APP
    protected static final ArrayList<String> FORCE_REQUIRE_PERMISSIONS    = new ArrayList<String>() {
        {
            add(Manifest.permission.READ_PHONE_STATE);
//            add(Manifest.permission.INTERNET);
//            add(Manifest.permission.ACCESS_NETWORK_STATE);
//            add(Manifest.permission.ACCESS_WIFI_STATE);
//            add(Manifest.permission.READ_LOGS);
            add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
    };

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null) {
            setIntent(intent);
            mContext = this;
        }
    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //没actionbar
////        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
//        //取消横屏
////        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        //输入法弹出的时候不顶起布局
//        //如果我们不设置"adjust..."的属性，对于没有滚动控件的布局来说，采用的是adjustPan方式，
//        // 而对于有滚动控件的布局，则是采用的adjustResize方式。
////        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN |
////                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//        //        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE |
//        //                WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
//        mContext = this;
//    }

    /**
     * 权限允许或拒绝对话框
     *
     * @param permissions 需要申请的权限
     * @param needFinish  如果必须的权限没有允许的话，是否需要finish当前 Activity
     * @param callback    回调对象
     */
    protected void requestPermission(final ArrayList<String> permissions, final boolean needFinish,
                                     final PermissionsResultListener callback) {
        if (permissions == null || permissions.size() == 0) {
            return;
        }
        mNeedFinish = needFinish;
        mListener = callback;
        mPermissionsList = permissions;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //获取未通过的权限列表
            ArrayList<String> newPermissions = checkEachSelfPermission(permissions);
            if (newPermissions.size() > 0) {// 是否有未通过的权限
                requestEachPermissions(newPermissions.toArray(new String[newPermissions.size()]));
            } else {// 权限已经都申请通过了
                if (mListener != null) {
                    mListener.onPermissionGranted();
                }
            }
        } else {
            if (mListener != null) {
                mListener.onPermissionGranted();
            }
        }
    }

    /**
     * 申请权限前判断是否需要声明
     *
     * @param permissions
     */
    private void requestEachPermissions(String[] permissions) {
        if (shouldShowRequestPermissionRationale(permissions)) {// 需要再次声明
            showRationaleDialog(permissions);
        } else {
            ActivityCompat.requestPermissions(PermissionActivity.this, permissions,
                    REQUEST_CODE_ASK_PERMISSIONS);
        }
    }

    /**
     * 弹出声明的 Dialog
     *
     * @param permissions
     */
    private void showRationaleDialog(final String[] permissions) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("为了应用可以正常使用，请您点击确认申请权限。")
                .setPositiveButton("确认",
                        (dialog2, which) -> ActivityCompat.requestPermissions(PermissionActivity.this, permissions,
                                REQUEST_CODE_ASK_PERMISSIONS))
                .setNegativeButton("取消", (dialog, which) -> {
                            dialog.dismiss();
                            if (mNeedFinish) finish();
                        })
                .setCancelable(false)
                .show();
    }

    /**
     * 检察每个权限是否申请
     *
     * @param permissions
     * @return newPermissions.size > 0 表示有权限需要申请
     */
    private ArrayList<String> checkEachSelfPermission(ArrayList<String> permissions) {
        ArrayList<String> newPermissions = new ArrayList<String>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                newPermissions.add(permission);
            }
        }
        return newPermissions;
    }

    /**
     * 再次申请权限时，是否需要声明
     *
     * @param permissions
     * @return
     */
    private boolean shouldShowRequestPermissionRationale(String[] permissions) {
        for (String permission : permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 申请权限结果的回调
     *
     * @param requestCode
     * @param permissions
     * @param grantResults
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_ASK_PERMISSIONS && permissions != null) {
            // 获取被拒绝的权限列表
            ArrayList<String> deniedPermissions = new ArrayList<>();
            for (String permission : permissions) {
                if (ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                    deniedPermissions.add(permission);
                }
            }
            // 判断被拒绝的权限中是否有包含必须具备的权限
            ArrayList<String> forceRequirePermissionsDenied =
                    checkForceRequirePermissionDenied(FORCE_REQUIRE_PERMISSIONS, deniedPermissions);
            if (forceRequirePermissionsDenied != null && forceRequirePermissionsDenied.size() > 0) {
                // 必备的权限被拒绝，
                if (mNeedFinish) {
                    showPermissionSettingDialog();
                } else {
                    if (mListener != null) {
                        mListener.onPermissionDenied();
                    }
                }
            } else {
                // 不存在必备的权限被拒绝，可以进首页
                if (mListener != null) {
                    mListener.onPermissionGranted();
                }
            }
        }
    }

    /**
     * 检查回调结果
     *
     * @param grantResults
     * @return
     */
    private boolean checkEachPermissionsGranted(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> checkForceRequirePermissionDenied(
            ArrayList<String> forceRequirePermissions, ArrayList<String> deniedPermissions) {
        ArrayList<String> forceRequirePermissionsDenied = new ArrayList<>();
        if (forceRequirePermissions != null && forceRequirePermissions.size() > 0
                && deniedPermissions != null && deniedPermissions.size() > 0) {
            for (String forceRequire : forceRequirePermissions) {
                if (deniedPermissions.contains(forceRequire)) {
                    forceRequirePermissionsDenied.add(forceRequire);
                }
            }
        }
        return forceRequirePermissionsDenied;
    }

    /**
     * 手动开启权限弹窗
     */
    private void showPermissionSettingDialog() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示")
                .setMessage("必要的权限被拒绝")
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getAppDetailsSettings(PermissionActivity.this, SETTINGS_REQUEST_CODE);
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        if (mNeedFinish) restart(PermissionActivity.this);
                    }
                })
                .setCancelable(false)
                .show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //如果需要跳转系统设置页后返回自动再次检查和执行业务 如果不需要则不需要重写onActivityResult
        if (requestCode == SETTINGS_REQUEST_CODE) {
            requestPermission(mPermissionsList, mNeedFinish, mListener);
        }
    }

    /**
     * Created by caihan on 2017/1/1.
     * 权限申请接口
     */

    public interface PermissionsResultListener {
        void onPermissionGranted();

        void onPermissionDenied();
    }

    /**
     * 获取App具体设置
     *
     * @param context 上下文
     */
    public static void getAppDetailsSettings(Context context, int requestCode) {
        getAppDetailsSettings(context, context.getPackageName(), requestCode);
    }

    /**
     * 获取App具体设置
     *
     * @param context     上下文
     * @param packageName 包名
     */
    public static void getAppDetailsSettings(Context context, String packageName, int requestCode) {
        if (StringUtils.isSpace(packageName)) return;
        ((AppCompatActivity) context).startActivityForResult(
                IntentUtils.getAppDetailsSettingsIntent(packageName), requestCode);
    }

    /**
     * 获取App具体设置的意图
     *
     * @param packageName 包名
     * @return intent
     */
    public static Intent getAppDetailsSettingsIntent(String packageName) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + packageName));
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }

    /**
     * 通过任务管理器杀死进程
     * 需添加权限 {@code <uses-permission android:name="android.permission.RESTART_PACKAGES"/>}</p>
     *
     * @param context
     */
    public static void restart(Context context) {
        int currentVersion = android.os.Build.VERSION.SDK_INT;
        if (currentVersion > android.os.Build.VERSION_CODES.ECLAIR_MR1) {
            Intent startMain = new Intent(Intent.ACTION_MAIN);
            startMain.addCategory(Intent.CATEGORY_HOME);
            startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(startMain);
            System.exit(0);
        } else {// android2.1
            ActivityManager am = (ActivityManager) context.getSystemService(ACTIVITY_SERVICE);
            am.restartPackage(context.getPackageName());
        }
    }
}
