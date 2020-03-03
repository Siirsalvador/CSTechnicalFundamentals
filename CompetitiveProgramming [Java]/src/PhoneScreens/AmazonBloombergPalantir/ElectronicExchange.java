package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-12-29
 */
public class ElectronicExchange {

    private PriorityQueue<Product> tradedProducts;

    public ElectronicExchange() {
        tradedProducts = new PriorityQueue<>();
    }

    public static void main(String[] args) {

        ElectronicExchange exchange = new ElectronicExchange();
        exchange.addProduct("Vodafone", 25);
        exchange.addProduct("Vodafone", 50);
        exchange.addProduct("Apple", 30);
        exchange.addProduct("Google", 250);

        System.out.println(exchange.getTopKProducts(exchange, 2));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0, 2);
        list.add(0, 1);
        System.out.println(list);
    }

    public void addProduct(String name, int volume) {

        //Add product to

        for (Product product : tradedProducts) {
            if (product.name.equals(name)) {
                product.volume = product.volume + volume;
                return;
            }
        }

        tradedProducts.add(new Product(name, volume));
    }

    public ArrayList getTopKProducts(ElectronicExchange e, int k) {

        Product[] products = e.tradedProducts.toArray(new Product[0]);
        Arrays.sort(products); // O(nlogn)

        return new ArrayList<>(Arrays.asList(products).subList(0, k)); // O(k)
    }
}

class Product implements Comparable<Product> {
    String name;
    int volume;

    public Product() {
    }

    public Product(String name, int volume) {
        this.name = name;
        this.volume = volume;
    }

    public int compareTo(Product o) {
        return o.volume - this.volume;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                '}';
    }
}
