package ru.itpark.ulmart.service;

import org.springframework.stereotype.Service;
import ru.itpark.ulmart.domain.CocaCola;
import ru.itpark.ulmart.domain.IPhone;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.domain.TShirt;
import ru.itpark.ulmart.repository.ProductRepository;

@Service
public class ProductService {
  private ProductRepository repository;
  private Product products = new Product();
  private int nextId = 1;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
  }

  public void addPhone(String name, int price, String os, String model, String color, int memorySize){
    IPhone iPhone = new IPhone(nextId, name, price, os, model, color, memorySize);
    repository.add(iPhone);
    nextId++;
  }

  public void addTSirt(String name, int price, int size, String color){
    TShirt tShirt = new TShirt(nextId, name, price, size, color);
    repository.add(tShirt);
    nextId++;
  }
  public void addCocaCola(String name, int price, int shelflife, String volume, String taste) {
    CocaCola cocaCola = new CocaCola(nextId, name, price, shelflife, volume, taste);
    repository.add(cocaCola);
    nextId++;
  }

  public Product[] getAll() {
    return repository.getAll();
  }

  public Product getById(int id) {
    return repository.getById(id);
  }

  public Product[] findByName(String search) {
    int maxResults = 10;
    Product[] result = new Product[maxResults];
    int nextIndex = 0;

    for (Product product : repository.getAll()) {
      if (product == null) {
        continue;
      }

      if (product.getName().toLowerCase().contains(search.toLowerCase())) {
        result[nextIndex] = product;
        nextIndex++;
      }

      if (nextIndex == maxResults) {
        break;
      }
    }

    return result;
  }


    public void updateById(int id, String name, int price, String os, String model, String color, int size, int memorySize, int shelfLIve, String volume, String taste) {
    }

  public void removeById(int id) {
  }
}
