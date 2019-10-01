package Pramp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-17
 */
public class AbsValueSort {

    private static int[] absSort(int[] arr) {
        // your code goes here
        Integer[] numbers = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            numbers[i] = arr[i];
        }

        Arrays.sort(numbers, new AbsoluteNumbers());
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            result[i] = numbers[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, -7, -2, -2, 0};
        System.out.println(Arrays.toString(absSort(nums)));

    }

    static class AbsoluteNumbers implements Comparator<Integer> {
        public int compare(Integer numb, Integer numb2) {
            return Math.abs(numb) == Math.abs(numb2) ? numb - numb2 : Math.abs(numb) - Math.abs(numb2);
        }
    }
}

/*
in C#
using System;
using System.Collections.Generic;
using System.Linq;

public class HelloWorld
{
    static void Main()
    {
      int[] arr = {2, -7, -2, -2, 0};
      var res=AbsSort(arr);

      foreach(int k in res){
       Console.Write("   "+k);

      }
    }

  public static int[] AbsSort(int[] arr){

  AbsVal comparer = new AbsVal();
  List<int> ls = arr.ToList();
  ls.Sort(comparer);
  arr = ls.ToArray();
  //Arrays.sort(arr, (a,b) -> (Integer.compare(Math.abs(a),  Math.abs(b))));

  return arr;
}
  //[2, -2, -7]
  //2 , -2 => 2 equalTo |-2| ==> -2, 2
  //n2 bubble 1= 3>4 ?0:1;
  //Custom Comparator
  //my internet is very poor
  //that's okay, we can communicate like this if that's fine
}

class AbsVal : IComparer<int>{
  public int Compare(int x, int y){
    return Math.Abs(x) == Math.Abs(y) ? x.CompareTo(y) : Math.Abs(x).CompareTo(Math.Abs(y));
  }
}

//LinkedIn: https://www.linkedin.com/in/ayomideoyekanmi/
 */