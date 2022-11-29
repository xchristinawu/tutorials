package playground;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ArrayList -> Array using .stream().mapToInt()
        List<Integer> al = new ArrayList<Integer>();
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);

        int[] arr = al.stream().mapToInt(i -> i).toArray();

        for (int x : arr)
            System.out.print(x + " ");


    }
    


}