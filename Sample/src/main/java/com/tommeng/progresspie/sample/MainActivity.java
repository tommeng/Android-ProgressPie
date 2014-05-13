package com.tommeng.progresspie.sample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.tommeng.progresspie.ProgressPie;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity
{
  private final static PieColor WHITE = new PieColor("White", R.color.white);
  private final static PieColor BLACK = new PieColor("Black", R.color.black);
  private final static PieColor RED = new PieColor("Red", R.color.android_color_red_light);
  private final static PieColor BLUE = new PieColor("Blue", R.color.android_color_blue_light);
  private final static PieColor GREEN = new PieColor("Green", R.color.android_color_green_light);
  private final static PieColor ORANGE = new PieColor("Orange", R.color.android_color_orange_light);
  private final static PieColor PURPLE = new PieColor("Purple", R.color.android_color_purple_light);
  private final static List<PieColor> pieColorList = new ArrayList<PieColor>();


  static
  {
    pieColorList.add(WHITE);
    pieColorList.add(BLACK);
    pieColorList.add(RED);
    pieColorList.add(BLUE);
    pieColorList.add(GREEN);
    pieColorList.add(ORANGE);
    pieColorList.add(PURPLE);
  }


  private ProgressPie _progressPie;
  private Spinner _foregroundColorSpinner;
  private Spinner _backgroundColorSpinner;
  private Spinner _interpolatorSpinner;
  private EditText _percentageView;
  private Button _animateButton;
  private Interpolator _interpolator;
  private ArrayAdapter<PieColor> _colorAdapter;


  @Override
  protected void onCreate(Bundle savedInstanceState)
  {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    _progressPie = (ProgressPie) findViewById(R.id.progress_pie);
    _foregroundColorSpinner = (Spinner) findViewById(R.id.foreground_color_spinner);
    _backgroundColorSpinner = (Spinner) findViewById(R.id.background_color_spinner);
    _interpolatorSpinner = (Spinner) findViewById(R.id.interpolator_spinner);
    _percentageView = (EditText) findViewById(R.id.percentage);
    _animateButton = (Button) findViewById(R.id.animate);

    _colorAdapter = new ArrayAdapter<PieColor>(this, R.layout.listitem_item, pieColorList);
    _foregroundColorSpinner.setAdapter(_colorAdapter);
    _backgroundColorSpinner.setAdapter(_colorAdapter);

    _interpolatorSpinner.setAdapter(ArrayAdapter.createFromResource(this, R.array.interpolator_array, R.layout.listitem_item));

    _foregroundColorSpinner.setOnItemSelectedListener(new ForegroundColorListener());
    _backgroundColorSpinner.setOnItemSelectedListener(new BackgroundColorListener());

    _interpolatorSpinner.setOnItemSelectedListener(new InterpolatorListener());

    _animateButton.setOnClickListener(new AnimateClickListener());

    _interpolator = new LinearInterpolator();
  }


  private class AnimateClickListener implements View.OnClickListener
  {
    @Override
    public void onClick(View view)
    {
      String percentageStr = _percentageView.getText().toString();
      Integer percent = percentageStr.isEmpty() ? 0 : Integer.valueOf(percentageStr);
      ProgressBarAnimation animation = new ProgressBarAnimation(_progressPie,
                                                                0,
                                                                percent > 100
                                                                ? 100
                                                                : percent);
      animation.setDuration(2000);
      animation.setInterpolator(_interpolator);
      _progressPie.startAnimation(animation);
    }
  }


  private class ForegroundColorListener implements android.widget.AdapterView.OnItemSelectedListener
  {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
      PieColor pieColor = _colorAdapter.getItem(i);
      _progressPie.setForegroundColor(getResources().getColor(pieColor.getColorRes()));
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
  }


  private class BackgroundColorListener implements AdapterView.OnItemSelectedListener
  {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
      PieColor pieColor = _colorAdapter.getItem(i);
      _progressPie.setBackgroundColor(getResources().getColor(pieColor.getColorRes()));
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
  }


  private class InterpolatorListener implements AdapterView.OnItemSelectedListener
  {
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
    {
      switch (i)
      {
        case 0:
          _interpolator = new LinearInterpolator();
          break;
        case 1:
          _interpolator = new AccelerateInterpolator();
          break;
        case 2:
          _interpolator = new DecelerateInterpolator();
          break;
        case 3:
          _interpolator = new AccelerateDecelerateInterpolator();
          break;
        case 4:
          _interpolator = new AnticipateInterpolator();
          break;
        case 5:
          _interpolator = new OvershootInterpolator();
          break;
        case 6:
          _interpolator = new AnticipateOvershootInterpolator();
          break;
      }
    }


    @Override
    public void onNothingSelected(AdapterView<?> adapterView)
    {

    }
  }
}
