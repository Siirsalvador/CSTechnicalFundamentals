package PhoneScreens.AmazonBloombergPalantir;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2020-03-02
 */
public class ElectronicExchange2 {
    //Product name
    //Volume of stocks traded

    //Top K products by volume at the end of the day
    //Top K products by volume throughout the day

    //Best approach will be to use a BST
    //Insertion is O(logn)
    //Retrieval is O(logn + k) -> O(k) - Traversal

    //Approach 2: PriorityQueue (k)
    //Insertion is O(n)
    /*
        Retrieval is O(klogn) because:
        - I first remove k elements from the queue @ logn time each ==> O(klogn)
        - Then I insert k elements back into the queue @ logn time each ===> O(klogn)
     */

    Queue<Product> products;

    ElectronicExchange2() {
        this.products = new PriorityQueue<>();
    }

    void addProduct(Product product) {

        for (Product p : products) {
            if (p.name.equals(product.name)) {
                p.volume += product.volume;
                return;
            }
        }

        products.add(product);
    }

    public List<Product> getTopKProducts(int k) {
        List<Product> topK = new ArrayList<>();
        Queue<Product> tmp = new PriorityQueue<>();

        while (!products.isEmpty() && k-- > 0) {
            Product curr = products.poll();
            tmp.offer(curr);
            topK.add(curr);
        }

        products.addAll(tmp);
        return topK;
    }


    class Product implements Comparable<Product> {
        String name;
        int volume;

        Product(String name, int volume) {
            this.name = name;
            this.volume = volume;
        }

        @Override
        public int compareTo(Product e) {
            return this.volume - e.volume;
        }
    }
}


