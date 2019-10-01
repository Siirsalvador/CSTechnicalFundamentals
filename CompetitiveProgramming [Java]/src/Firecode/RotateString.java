package Firecode;

/**
 * @author: Ayomide Oyekanmi aoyekanmi@teamapt.com, ayomideoyekanmi@gmail.com
 * @date: 2019-08-30
 */
//Leetcode: https://leetcode.com/problems/rotate-string/
public class RotateString {
    public static void main(String[] args) {
        char c = 'b';
        c = (char) ('a' + 'z' - c);
        System.out.println(c);
    }

    public boolean rotateString(String A, String B) {
        return (A + A).contains(B) && A.length() == B.length();
    }



/*import java.io.*;
import java.util.*;

    class Solution {
        public static void DfsHelper(int[][] binaryMatrix,int R,int C,boolean[][] visited){

            int i=binaryMatrix.length;
            int j=binaryMatrix[0].length;
            //corner cases
            if(R<0 || R>=i || C<0 || C>=j || binaryMatrix[R][C]== 0 || visited[R][C]==true){
                return;
            }

            visited[R][C]=true;

            DfsHelper(binaryMatrix,R+1,C,visited);
            DfsHelper(binaryMatrix,R,C+1,visited);
            DfsHelper(binaryMatrix,R-1,C,visited);
            DfsHelper(binaryMatrix,R,C-1,visited);
        }

        static int getNumberOfIslands(int[][] binaryMatrix) {
            int R=binaryMatrix.length; //row
            int C=binaryMatrix[0].length; //col

            boolean[][] visited=new boolean[R][C];
            int counter=0;

            for(int i=0;i<R;i++){
                for(int j=0;j<C;j++){
                    if(visited[i][j]==false && binaryMatrix[i][j]==1 ){
                        DfsHelper(binaryMatrix,i,j,visited);
                        counter++;

                    }
                }
            }

            return counter;

        }

  0,1
  1,0
  R*C
  [1,2,5,6,7,8]
    0,1,2,3,4,5,6 C
 0  0,v,v,0,1,1,1
 1, 0,0,0,0,1,1,1
 2, 0,1,0,1,1,1,1
 R

 VisitedSet -> 0,4, 0,5

 (0,4) -> 0,5, 1,4
 (0,5) -> 0,6, 1,5
 (0,6) -> 1,6


 counter = 1

 input:  binaryMatrix = [ [0,    1,    0,    1,    0],
                         [0,    0,    1,    1,    1],
                         [1,    0,    0,    1,    0],
                         [0,    1,    1,    0,    0],
                         [1,    0,    1,    0,    1] ]

output: 6 # since this is the number of islands in binaryMatrix.
          # See all 6 islands color-coded below.



        public static void main(String[] args) {

        } */

}

