package ru.itpark.ulmart.service;

import org.springframework.stereotype.Service;
import ru.itpark.ulmart.domain.Product;
import ru.itpark.ulmart.repository.ProductRepository;

@Service
public class ProductService { // new BookService(-> <-);
  private ProductRepository repository;
  private int nextId = 1;

  public ProductService(ProductRepository repository) {
    this.repository = repository;
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
}
