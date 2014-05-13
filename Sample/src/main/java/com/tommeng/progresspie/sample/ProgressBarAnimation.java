package com.tommeng.progresspie.sample;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProgressBarAnimation extends Animation
{
  private ProgressBar _progressBar;
  private float _from;
  private float _to;


  public ProgressBarAnimation(ProgressBar progressBar, float from, float to)
  {
    super();
    _progressBar = progressBar;
    _from = from;
    _to = to;
  }


  @Override
  protected void applyTransformation(float interpolatedTime, Transformation t)
  {
    super.applyTransformation(interpolatedTime, t);
    float value = _from + (_to - _from) * interpolatedTime;
    _progressBar.setProgress((int) value);
  }

}