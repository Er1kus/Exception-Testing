package ru.netology.domain;


import ru.netology.repository.ProductRepository;
import ru.netology.repository.NotFoundException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();
    Product first = new Book(11, "Metro 2033", 500, "Glukhovsky Dmitry");
    Product second = new Smartphone(324, "Iphone 14", 25_000, "Apple Inc China");
    Product third = new Book(267, "Survivor", 550, "Palanik Chuck");
    Product forth = new Book(198, "The Buried giant", 600, "Ishiguro Kazuo");
    Product fifth = new Smartphone(73, "Motorola 20", 30_000, "Motorola LTD China");

    @BeforeEach
    void insertData() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(forth);
        repo.save(fifth);
    }

    @Test
    public void saveTest() {

        Product[] actual = repo.findAll();
        Product[] expected = {first, second, third, forth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        repo.removeById(267);
        Product[] actual = repo.findAll();
        Product[] expected = {first, second, forth, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        Product[] actual = repo.findById(73);
        Product[] expected = {fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByAbsentId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(14);
        });
    }
}
