### app启动问题
#### 在onCreate() 方法中执行setContentView()此方法之前会加载默认样式文件  
#### onApplyThemeResource(getTheme(), mThemeId, false); 然后才调用布局文件，这样就显示了系统默认布局（白屏或者黑屏，使用的是哪个样式就展示哪个默认的颜色）
##### <style name="ThemeSplash" parent="Theme.AppCompat.Light">
##### <style name="ThemeSplash" parent="ThemeOverlay.AppCompat.Dark">
     
```final AppCompatDelegate delegate = getDelegate();
delegate.installViewFactory(); 
delegate.onCreate(savedInstanceState); 
if(delegate.applyDayNight() && mThemeId != 0) { 
// If DayNight has been applied, we need to re-apply the theme for the changes to take effect. On API 23+, we should bypass  setTheme(), which will no-op if the theme ID is identical to the  current theme ID. 
if(Build.VERSION.SDK_INT >= 23) { 
    onApplyThemeResource(getTheme(),mThemeId, false); // 设置主题
  } else { 
     setTheme(mThemeId);
      } }
super.onCreate(savedInstanceState);```
      