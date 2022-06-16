package ru.netology.domain;

import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();

    private ProductManager manager = new ProductManager(repository);
    private Product first = new Book(11, "Metro 2033", 500, "Glukhovsky Dmitry");
    private Product second = new Smartphone(324, "Iphone 14", 25_000, "Apple Inc China");
    private Product third = new Book(267, "Survivor", 550, "Palanik Chuck");
    private Product forth = new Book(198, "The Buried giant", 600, "Ishiguro Kazuo");
    private Product fifth = new Smartphone(73, "Motorola 20", 30_000, "Motorola LTD China");

    @BeforeEach
    void setData() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
    }

    @Test
    public void shouldFind2Elements() {

        Product[] actual = manager.searchBy("20");
        Product[] expected = {first, fifth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNoElements() {

        Product[] actual = manager.searchBy("War and peace");
        Product[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindBookByAuthor() {

        Product[] actual = manager.searchBy("Kazuo");
        Product[] expected = {forth};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartphoneByManufacture() {

        Product[] actual = manager.searchBy("LTD");
        Product[] expected = {fifth};

        Assertions.assertArrayEquals(expected, actual);
    }
}
