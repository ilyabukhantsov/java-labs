package org.example.Task2;

import java.io.Serializable;

public abstract class Shape implements Serializable {
  private static final long serialVersionUID = 1L;

  protected String color;

  public Shape(String color) {
    this.color = color;
  }

  public String getColor() { return color; }

  public abstract double getArea();

  @Override
  public String toString() {
    return String.format("%s [колір=%s, площа=%.2f]",
            getClass().getSimpleName(), color, getArea());
  }
}