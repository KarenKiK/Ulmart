package ru.itpark.ulmart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class IPhone extends Product{
  private String model;
  private String color;
  private int memorySize;
  private String os;

  public IPhone(int id, String name, int price, String os, String model, String color, int memorySize){
    super(id, name, price);
    this.model = model;
    this.color = color;
    this.memorySize = memorySize;
    this.os = os;
  }
}
