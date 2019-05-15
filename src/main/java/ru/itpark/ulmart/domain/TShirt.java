package ru.itpark.ulmart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TShirt extends Product {
  private int size;
  private String color;

  public TShirt(int id, String name, int price, int size, String color){
    super(id, name, price);
    this.size = size;
    this.color = color;
  }

}
