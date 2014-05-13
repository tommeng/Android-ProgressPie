package com.tommeng.progresspie.sample;

public class PieColor
{
  private String _name;
  private int _colorRes;


  public PieColor(String name, int colorRes)
  {
    _name = name;
    _colorRes = colorRes;
  }


  public int getColorRes()
  {
    return _colorRes;
  }


  public void setColorRes(int colorRes)
  {
    _colorRes = colorRes;
  }


  public String getName()
  {
    return _name;
  }


  public void setName(String name)
  {
    _name = name;
  }


  @Override
  public String toString()
  {
    return _name;
  }
}
