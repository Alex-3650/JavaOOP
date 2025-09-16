package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class InStockTest {

    private static final String LABEL="test_product";
    private static final double PRICE=13.50;
    private static final int QUANTITY=21;
    private ProductStock stock;
    private Product product;

    @BeforeEach
    public void setUp(){
        this.stock=new Instock();
        this.product=new Product(LABEL,PRICE,QUANTITY);
    }


    @Test
    public  void test_addAndContainsProduct_ShouldReturn_CorrectResult_BeforeAndAfterAddition(){
        assertFalse(stock.contains(product));
         stock.add(product);

         assertTrue(stock.contains(product));


    }
    @Test
    public  void test_CountReturns_CorrectSize(){
        assertEquals(0,stock.getCount());
        stock.add(product);
        assertEquals(1,stock.getCount());


    }
    @Test
    public  void test_findThrows_WithInvalidIndex(){
       assertThrows(IndexOutOfBoundsException.class,()->stock.find(0));


    }
    @Test
    public  void test_findThrows_WithNegativeIndex(){
        assertThrows(IndexOutOfBoundsException.class,()->stock.find(-1));
    }
    @Test
    public  void test_findReturns_CorrectProduct(){
       stock.add(product);
       Product actual =stock.find(0);
       assertNotNull(actual);
       assertEquals(product.getLabel(),actual.getLabel());
    }
    @Test
    public  void test_findReturns_CorrectProduct_WithMultipleProducts(){

       addProducts();
        stock.add(product);
        Product actual =stock.find(stock.getCount()-1);
        assertNotNull(actual);
        assertEquals(product.getLabel(),actual.getLabel());
    }
    @Test
    public  void test_changeQuantity_ThrowsIfFound(){


        stock.add(product);

       assertThrows(IllegalArgumentException.class,()-> stock.changeQuantity(LABEL+"Not Existing",10));
    }
    @Test
    public  void test_changeQuantity_WithExistingProduct(){


        stock.add(product);
        addProducts();
        int newQuantity = QUANTITY + 12;
        stock.changeQuantity(product.getLabel(), newQuantity);
        assertEquals(newQuantity,product.getQuantity());

    }
    @Test
    public  void test_findByLabel_Throw_WhenProductIsMissing(){


        stock.add(product);
       assertThrows(IllegalArgumentException.class,()->stock.findByLabel(LABEL+"Not Existing"));

    }
    @Test
    public  void test_findByLabel_ShouldReturnCorrectProduct(){

        addProducts();
        stock.add(product);
        Product byLabel = stock.findByLabel(product.getLabel());
        assertNotNull(byLabel);
        assertEquals(product.getLabel(),byLabel.getLabel());

    }
    @Test
    public void test_findFirstByAlphabeticalOrder_ShouldReturnEmptyCollection_WhenNotEnoughProducts(){

        int productsSize = addProducts().size();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(productsSize + 1);
        List<Product> products = getIterableList(iterable);
        assertTrue(products.isEmpty());


    }
    @Test
    public void test_findFirstByAlphabeticalOrder_ShouldReturnCorrectNumberOfProducts(){
        int productsSize = addProducts().size();  //3
        stock.add(product); //4
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(productsSize ); //3
        List<Product> products = getIterableList(iterable); //3
        assertEquals(productsSize,products.size());

    }

    @Test
    public void test_findFirstByAlphabeticalOrder_ShouldReturnProductsOrdered(){
        List<Product> expected = addProducts().stream().sorted(Comparator.comparing(Product::getLabel)).toList();
        Iterable<Product> iterable = stock.findFirstByAlphabeticalOrder(expected.size());

        List<Product> actual= getIterableList(iterable);
        assertEquals(expected,actual);

    }
    @Test
    public void test_findAllInPriceRange_ShouldReturnEmptyCollection_IfNoneInRange(){
          addProducts();
        Iterable<Product> allInRange = stock.findAllInRange(3.4, 5.9);
        List<Product> productList = getIterableList(allInRange);
        assertTrue( productList.isEmpty());

    }
    @Test
    public void test_findAllInPriceRange_ShouldReturnCorrectRange(){
        addProducts();
        double lower = 0.5;
        double upper = 2.4;
        Iterable<Product> allInRange = stock.findAllInRange(lower, upper);
        List<Product> productList = getIterableList(allInRange);
        assertTrue(productList.stream().map(Product::getPrice).allMatch(p-> p>lower && p<=upper));

    }
    @Test
    public void test_findAllInPriceRange_ShouldReturnProductsInCorrectOrder(){
        double lo = 0.4;
        double hi = 7.4;
        List<Product> expected = addProducts().stream().
        filter(p->p.getPrice()>lo && p.getPrice()<=hi).
        sorted(Comparator.comparing(Product::getPrice).reversed()).toList();

        Iterable<Product> allInRange = stock.findAllInRange(lo, hi);
        List<Product> actual = getIterableList(allInRange);
        assertEquals(expected,actual);
    }
    @Test
    public void test_findAllByPrice_ReturnsEmptyCollection_NothingMatchesThePriceGiven(){
         addProducts();
        Iterable<Product> allByPrice = stock.findAllByPrice(101);
        List<Product> iterableList = getIterableList(allByPrice);
         assertTrue(iterableList.isEmpty());

    }
    @Test
    public void test_findAllByPrice_ReturnsOnlyMatchingProducts(){

        double price=0.5;
        addProducts();

        Iterable<Product> allByPrice = stock.findAllByPrice(price);
        List<Product> iterableList = getIterableList(allByPrice);
        assertTrue(iterableList.stream().map(Product::getPrice) .allMatch(p->p==price));

    }
    @Test
    public void test_findFirstMostExpensiveProducts_ShouldThrow_IfLessProductsInStock(){

        int size = addProducts().size();

        assertThrows(IllegalArgumentException.class,()->stock.findFirstMostExpensiveProducts(size+2));

    }
    @Test
    public void test_findFirstMostExpensiveProducts_ShouldReturnCorrectNumberOfProducts(){

        int count=4;

        List<Product> expected = addProducts().stream().sorted(Comparator.comparing(Product::getPrice).reversed()).limit(count).toList();

        Iterable<Product> firstMostExpensiveProducts = stock.findFirstMostExpensiveProducts(count);
        List<Product> actual= getIterableList(firstMostExpensiveProducts);
        assertEquals(expected,actual);

    }
    @Test
    public void test_findAllByQuantity_ShouldReturn_CorrectNumberOfProducts(){

        int count=0;
        int quantity=5;

        List<Product> expected = addProducts().stream().filter(q->q.getQuantity()==quantity).toList();

        Iterable<Product> allByQuantity = stock.findAllByQuantity(quantity);
        List<Product> actual = getIterableList(allByQuantity);
        assertEquals(expected,actual);

    }
    @Test
    public void test_findAllByQuantity_ShouldReturnEmptyList_IfNotMatch(){

        int quantity=0;
        Iterable<Product> allByQuantity = stock.findAllByQuantity(0);
        List<Product> iterableList = getIterableList(allByQuantity);
        assertTrue(iterableList.isEmpty());

    }
    @Test
    public void test_Iterator_ReturnsAllProducts(){
        List<Product> expected = addProducts();

        Iterator<Product> iterator = stock.iterator();
        assertNotNull(iterator);

        List<Product> actual = getIteratorList(iterator);
        assertEquals(expected,actual);



    }





    //Helper Methods
    private static List<Product> getIterableList(Iterable<Product> iterable) {
        assertNotNull(iterable);

        return getIteratorList(iterable.iterator());
    }
    private static List<Product> getIteratorList(Iterator<Product> iterator) {
        assertNotNull(iterator);
        List<Product> products=new ArrayList<>();
       while (iterator.hasNext()){
           products.add(iterator.next());
       }
        return products;
    }



    private List<Product> createProducts(){
        return List.of(
                new Product("Ruffles",3.4,5),
                new Product("Chio",2.4,5),
                new Product("Fanta",1.4,5),
                new Product("Chips",0.5,2),
                new Product("Nestle",0.5,2),
                new Product("Cola",1.4,2));
    }

    private List<Product> addProducts(){
        List<Product> products = createProducts();
       products.forEach(stock::add);
       return products;
    }
    /////////////////////
  
}