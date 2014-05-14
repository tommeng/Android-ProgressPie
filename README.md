Android-ProgressPie
===========

A progress bar extension for Android.

<div>
<img src="http://tommeng.com/static/progresspie_sample.gif"/>
<img src="http://tommeng.com/static/progresspie_sample2.png" height="400" width="200"/>
</div>


ProgressPie
-----------
void setForegroundColor(int color)
Used to set the foreground color of the pie.

example:
```java
setForegroundColor(getResource.getColor(R.color.red));
```


void setBackgroundColor(int color)
Used to set the background color of the pie.

example:
```java
setBackgroundColor(getResource.getColor(R.color.blue));
```


-----------
To use in XML layout:
The only custom attributes so far are:
PIE_foreground_color,
PIE_background_color

example:
```xml
<com.tommeng.progresspie.ProgressPie
        android:id="@+id/progress_pie"
        android:layout_width="150dip"
        android:layout_height="150dip"
        android:layout_gravity="center"
        app:PIE_foreground_color="@color/android_color_orange_dark"
        app:PIE_background_color="@color/android_color_blue_light"/>
```
