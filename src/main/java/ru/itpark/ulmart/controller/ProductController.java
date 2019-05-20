package ru.itpark.ulmart.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
  @GetMapping("/add")
  public String addPage(Model model){
    model.addAttribute("product");
    return "add";
  }
  @GetMapping("/addphone")
  public String addPhone(){
    return "addphone";
  }
  @PostMapping("/addphone")
  public String addPhone(@RequestParam String name,
                         @RequestParam int price,
                         @RequestParam String os,
                         @RequestParam String model,
                         @RequestParam String color,
                         @RequestParam int memorySize
                         ){
    service.addPhone(name, price, os, model, color, memorySize);
    return "redirect:/";
  }
  @GetMapping("/addshirt")
  public String addShirt(){
    return "addshirt";
  }
  @PostMapping("/addshirt")
  public String addShirt(@RequestParam String name,
                         @RequestParam int price,
                         @RequestParam int size,
                         @RequestParam String color
                         ) {
    service.addTSirt(name, price, size, color);
    return "redirect:/";
  }
  @GetMapping("/addcola")
  public String addCola(){
    return "addcola";
  }
  @PostMapping("/addcola")
    public String addCola(@RequestParam String name,
                          @RequestParam int price,
                          @RequestParam int shelfLIve,
                          @RequestParam String volume,
                          @RequestParam String taste
                          ){
    service.addCocaCola(name, price, shelfLIve, volume, taste);
    return "redirect:/";
  }

  @GetMapping("/view/{id}")
  public String details(@PathVariable int id, Model model) {
    model.addAttribute("product", service.getById(id));
    return "details";
  }




  @GetMapping("/edit/{id}")
  public String editPage(@PathVariable int id, Model model) {
    model.addAttribute("product", service.getById(id));
    return "edit";
  }



  @PostMapping("/edit/{id}/iphone")
  public String edit(
          @PathVariable int id,
          @RequestParam String name,
          @RequestParam int price,
          @RequestParam String os,
          @RequestParam String model,
          @RequestParam String color,
          @RequestParam int memorySize
  ) {
    service.updateById(id, name, price, os, model, color, memorySize);
    return "redirect:/";
  }

  @PostMapping("/remove/{id}")
  public String remove(@PathVariable int id){
    service.removeById(id);
    return "redirect:/";
  }
}
