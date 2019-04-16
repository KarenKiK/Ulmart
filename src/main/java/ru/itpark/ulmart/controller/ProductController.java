package ru.itpark.ulmart.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.ulmart.service.ProductService;

@Controller
@AllArgsConstructor // сгенерирует конструктор
public class ProductController {
  private ProductService service;

  // mapping -> привязка метода к обработке URL'а
  @GetMapping // RequestMapping: http://localhost:8080/ -> GET, POST, PUT, DELETE, @GetMapping только на GET
  public String frontPage(Model model) {
    model.addAttribute("products", service.getAll());
    return "index"; // строчка с именем шаблона (без расширения)
  }

  @GetMapping(params = "search")
  public String searchByName(@RequestParam String search, Model model) {
    model.addAttribute("products", service.findByName(search));
    model.addAttribute("search", search);
    return "index";
  }

  @GetMapping("/view/{id}")
  public String details(@PathVariable int id, Model model) {
    model.addAttribute("product", service.getById(id));
    return "details";
  }
}
