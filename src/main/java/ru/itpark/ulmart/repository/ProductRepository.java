package ru.itpark.ulmart.repository;

import org.springframework.stereotype.Repository;
import ru.itpark.ulmart.domain.CocaCola;
import ru.itpark.ulmart.domain.IPhone;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.domain.TShirt;

@Repository
public class ProductRepository {
  private Product[] items = new Product[10];
  private int nextIndex = 0;


  public Product[] getAll() {
    return items;
  }

  public void add(Product product) {
    items[nextIndex] = product;
    nextIndex++;
  }

  public void removeById(int id){
    for (int i = 0; i < items.length; i++){
      Product product = items[i];
      if (product != null && product.getId() == id){
        items[i] = null;
        return;
      }
    }
  }
  public Product getById(int id) {
    for (Product item : items) {
      if (item != null && item.getId() == id) {
        return item;
      }
    }
    return null;
  }
  public void update(Product product){
    for (int i = 0; i < items.length; i++) {
      Product item = items[i];
      if (item != null && item.getId() == product.getId())
        items[i] = product;
      return;
    }
  }
}
