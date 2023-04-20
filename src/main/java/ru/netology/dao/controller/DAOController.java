package ru.netology.dao.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.dao.repository.DAORepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class DAOController {
  private final DAORepository daoRepository;

  public DAOController(DAORepository daoRepository) {
    this.daoRepository = daoRepository;
  }

  @GetMapping("products/fetch-product")
  public List getProductByName(@RequestParam("name") String name) {
    return daoRepository.getProductByName(name);
  }
}
