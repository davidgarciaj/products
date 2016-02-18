import java.util.ArrayList;

/**
 * Manage the stock in a business.
 * The stock is described by zero or more Products.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StockManager
{
    // A list of the products.
    private ArrayList<Product> stock;

    /**
     * Initialise the stock manager.
     */
    public StockManager()
    {
        stock = new ArrayList<Product>();
    }

    /**
     * Add a product to the list.
     * @param item The item to be added.
     */
    public void addProduct(Product item)
    {
        Product product = findProduct(item.getID());
        if(product == null){
            stock.add(item);
        }
        else{System.out.println("This id is in use now");}
    }
    
    /**
     * Receive a delivery of a particular product.
     * Increase the quantity of the product by the given amount.
     * @param id The ID of the product.
     * @param amount The amount to increase the quantity by.
     */
    public void delivery(int id, int amount)
    {
        if(findProduct(id) != null){
            findProduct(id).increaseQuantity(amount);
        }
        else{System.out.println("El id indicado no pertenece a ningún producto.");}
    }
    
    /**
     * Try to find a product in the stock with the given id.
     * @return The identified product, or null if there is none
     *         with a matching ID.
     */
    public Product findProduct(int id)
    {
        Product find = null;
        boolean notFind = true;
        int cont = 0;
        while(cont < stock.size() && notFind){
            if(stock.get(cont).getID() == id){
                find = stock.get(cont);
                notFind = false;
            }
            cont++;
        }
        return find;
    }
    
    /**
     * Locate a product with the given ID, and return how
     * many of this item are in stock. If the ID does not
     * match any product, return zero.
     * @param id The ID of the product.
     * @return The quantity of the given product in stock.
     */
    public int numberInStock(int id)
    {
        int cantidad = 0;
        if(findProduct(id) != null){
            cantidad = findProduct(id).getQuantity();
        }
        return cantidad;
    }

    /**
     * Print details of all the products.
     */
    public void printProductDetails()
    {
        if(stock.size() > 0){
            for(Product product: stock){
                System.out.println(product);
            }
        }
        else{System.out.println("Don´t have any products in stock.");}
    }

    /**
     * Print details of all the products when his stock is under a given number.
     */
    public void underGivenNumberInStock(int number)
    {
        boolean isNotPrint = true;        
        for(Product product: stock){
            if(product.getQuantity() < number){
                 System.out.println(product);
                 isNotPrint = false; 
            }
        }
        if(isNotPrint){System.out.println("Don´t have any products with stock under " + number + ".");}
    }
    
    /**
     * Try to find a product in the stock with the given his name.
     */
    public Product findProduct(String name){
        Product find = null;
        boolean notFind = true;
        int cont = 0;
        while(cont < stock.size() && notFind){
            if(stock.get(cont).getName().equals(name)){
                find = stock.get(cont);
                notFind = false;
            }
            cont++;
        }
        return find;
    }
}
