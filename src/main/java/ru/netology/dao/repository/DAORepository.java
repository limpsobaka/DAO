package ru.netology.dao.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;


@Repository
@NoArgsConstructor
public class DAORepository {
  private final String SCRIPT = read("getProductsQuery.sql");

  @PersistenceContext
  private EntityManager entityManager;

  public List getProductByName(String name) {
    return entityManager.createQuery(SCRIPT)
            .setParameter("name", name)
            .getResultList();
  }

  private static String read(String scriptFileName) {
    try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
      return bufferedReader.lines().collect(Collectors.joining("\n"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
