package com.example.getsms;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Administrator
 * 短信验证码截取
 * @createTime 2019/8/26 15:39
 */
public class SMSContentObserver extends ContentObserver {
    /**
     * 更新UI线程
     */
    private Handler mHandler;
    /**
     * 上下文
     */
    private Context mContext;
    /**
     * / 验证码
     */
    private String code;

    public SMSContentObserver(Context context, Handler handler) {
        super(handler);
        this.mContext = context;
        this.mHandler = handler;
    }

    /**
     * * 回调函数, 当所监听的Uri发生改变时，就会回调此方法 * * 注意当收到短信的时候会回调两次 * * @param selfChange * 此值意义不大 一般情况下该回调值false
     */
    @Override
    public void onChange(boolean selfChange, Uri uri) {
        Log.e("XXXXXXXXXXXXXXXX", uri.toString());
        // 第一次回调 不是我们想要的 直接返回
        if (uri.toString().equals("content://sms/raw")) {
            return;
        }
        // 第二次回调 查询收件箱里的内容
        Uri inboxUri = Uri.parse("content://sms/inbox");
        // 按时间顺序排序短信数据库
        Cursor c = mContext.getContentResolver().query(inboxUri, null, null, null, "date desc");
        if (c != null) {
            if (c.moveToFirst()) {
                // 获取手机号
                String address = c.getString(c.getColumnIndex("address"));
                // 获取短信内容
                String body = c.getString(c.getColumnIndex("body"));
                // 判断手机号是否为目标号码
                if (!address.equals("你的目标号码")) {
                    return;
                } // 正则表达式截取短信中的6位验证码
                Pattern pattern = Pattern.compile("(\\d{6})");
                Matcher matcher = pattern.matcher(body);
                // 如果找到通过Handler发送给主线程
                if (matcher.find()) {
                    code = matcher.group(0);
                    mHandler.obtainMessage(1, code).sendToTarget();
                }
            }
        }
        c.close();
    }
}


