package ComparableComparator.Movie;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 *  It returns a negative integer, zero, or a positive integer
 *  if “this” object is less than, equal to, or greater than the object passed as an argument.
 */
public class Movie implements Comparable<Movie> {

    private int year;
    private String name;

    Movie(int year, String name) {
        this.year = year;
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * New object - this object means Descending order
     * this object - New object means Ascending order
     */
    @Override
    public int compareTo(Movie movie) {
        return movie.year - this.year;
    }
}

class NameComparator implements Comparator<Movie> {
    //Descending Order if second object is used first
    @Override
    public int compare(Movie movie1, Movie movie2) {
        //return movie2.getName().compareTo(movie1.getName());
        return movie2.getYear() - movie1.getYear();
    }
}

class NameAndYearComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie movie1, Movie movie2) {
        int sameNames = movie2.getName().compareTo(movie1.getName());
        return sameNames == 0 ? movie2.getYear() - movie1.getYear() : sameNames;
    }
}

class Solution {
    public static void main(String[] args) {

        ArrayList<Movie> list = new ArrayList<Movie>();
        list.add(new Movie(2017, "Avengers"));
        list.add(new Movie(2019, "Reasons Why"));
        list.add(new Movie(1977, "Rambo"));
        list.add(new Movie(2019, "Avengers"));

        Collections.sort(list);
        for (Movie movie : list) {
            System.out.println(String.format("%s %s", movie.getYear(), movie.getName()));
        }

        System.out.println("\n");
        list.sort(new NameComparator());

        for (Movie movie : list) {
            System.out.println(String.format("%s %s", movie.getYear(), movie.getName()));
        }

        System.out.println("\n");
        list.sort(new NameAndYearComparator());

        for (Movie movie : list) {
            System.out.println(String.format("%s %s", movie.getYear(), movie.getName()));
        }

    }
}


