package Pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-17
 */
public class AbsValueSort {

    private static int[] absSort(int[] arr) {

        if (arr == null || arr.length == 0) return new int[1];
        // your code goes here
        List<Integer> numbers = new ArrayList<>();
        for (int value : arr) {
            numbers.add(value);
        }

        numbers.sort((numb, numb2) -> {
            return Math.abs(numb) == Math.abs(numb2) ? numb - numb2 : Math.abs(numb) - Math.abs(numb2);
        });

        int[] result = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            result[i] = numbers.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, -7, -2, -2, 0};
        System.out.println(Arrays.toString(absSort(nums)));
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

}

class AbsVal : IComparer<int>{
  public int Compare(int x, int y){
    return Math.Abs(x) == Math.Abs(y) ? x.CompareTo(y) : Math.Abs(x).CompareTo(Math.Abs(y));
  }
}

//LinkedIn: https://www.linkedin.com/in/ayomideoyekanmi/
 */