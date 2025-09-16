package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
   private  List<Product> productList;

    public Instock() {
        this.productList = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public boolean contains(Product product) {
        return productList.stream().anyMatch(p->p.getLabel().equals(product.getLabel()));
    }

    @Override
    public void add(Product product) {
     productList.add(product);
    }

    @Override
    public void changeQuantity(String label, int quantity) {

        Product product = getProduct(label);

        product.setQuantity(quantity);

    }

    private Product getProduct(String label) {
        Optional<Product> optionalProduct = productList.stream().
                filter(p -> p.getLabel().equals(label)).
                findFirst();
       return optionalProduct.orElseThrow(IllegalArgumentException::new);

    }

    @Override
    public Product find(int index) {
        if (index<0 || index>=getCount()){
            throw  new IndexOutOfBoundsException();
        }

        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
       return  getProduct(label);

    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
       if ( count>getCount()){
           return  new ArrayList<>();
       }
          return productList.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).toList();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        return productList.stream().
        filter(p->p.getPrice()>lo && p.getPrice()<=hi)
        .sorted(Comparator.comparing(Product::getPrice).reversed()).toList();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
      return productList.stream().filter(p->p.getPrice()==price).toList();
    }


    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if ( count>getCount()){
           throw new IllegalArgumentException();
        }

       return productList.stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(count).toList();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return productList.stream().filter(q->q.getQuantity()==quantity).toList();
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }
}
