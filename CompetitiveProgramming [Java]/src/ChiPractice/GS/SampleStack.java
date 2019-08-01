package ChiPractice.GS;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-01
 */
public class SampleStack {

    //Push
    //Pop
    //Retrieve Min Element in Constant time

    int min;
    int size;
    ArrayList<Integer> arrayList;

    SampleStack(){
        this.min = Integer.MAX_VALUE;
        this.size = 0;
        this.arrayList = new ArrayList<>();
    }

    void push(int num){

        if(num < min){
            min = num;
        }

        arrayList.add(num);
        size++;
    }

    int pop(){
      int num = arrayList.get(size - 1);
      arrayList.remove(size - 1);
      size--;

      return num;
    }

    int getMin(){
        return min;
    }
}
