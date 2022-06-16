package ru.netology.repository;

import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    public void save(Product item) {
        if (findById(item.getId()) != null) {                                  //задача 2*
            throw new AlreadyExistsException(                                  //задача 2*
                    "Element with id: " + item.getId() + " is already added"); //задача 2*
        }                                                                      //задача 2*
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] findAll() {
        return items;
    }

    public Product[] removeById(int id) {
        if (findById(id) == null) {                                              //задача 1
            throw new NotFoundException("Element with id: " + id + " not found");//задача 1
        }                                                                        //задача 1
        int length = items.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
        return tmp;
    }

    public Product[] findById(int id) {                                           //задача 1
        for (Product item : items) {                                              //задача 1
            if (item.getId() == id) {                                             //задача 1
                return new Product[]{item};                                       //задача 1
            }                                                                     //задача 1
        }                                                                         //задача 1
        return null;                                                              //задача 1
    }

}
