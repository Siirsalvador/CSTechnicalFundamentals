package Firecode;

import java.util.ArrayList;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-09-28
 */
public class JavaNoKillUsOh {


    public static void incrementCount(int count){

        if(count == 4) return;

        count++;
        incrementCount(count);
        System.out.println(count);
        incrementCount(count);
    }


    public static void main(String[] args){
        int count = 0;
        incrementCount(count);


    }
}
