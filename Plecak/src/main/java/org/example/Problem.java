package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Problem {
    Random random;
    int n = 0;
    int lowerBound = 0;
    int upperBound = 1;
    List<Item> items = new ArrayList<>();
    public Problem(int n, int seed, int l, int u){
        this.n = n;
        this.lowerBound = l;
        this.upperBound = u;
        this.random = new Random(seed);

        for(int i = 0; i < n; ++i) {
            int v = random.nextInt(upperBound - lowerBound + 1) + lowerBound;
            int w = random.nextInt(upperBound - lowerBound + 1) + lowerBound;

            this.items.add(new Item(v, w, i+1));
        }

        System.out.println("Lista:");
        for (Item item : items) {
            System.out.println(item);
        }
    }

    public void Sort(){
        Collections.sort(items, Collections.reverseOrder());
    }

    public Result Solve(int cap)
    {
        Result result = new Result();
        int space = cap;
        this.Sort();

        for(int i=0; i < n; ++i)
        {

            while (items.get(i).weight <= space)
            {
                result.addItem(items.get(i));
                space -= items.get(i).weight;

            }


        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Lista:\n");
        for (Item item : items) {
            stringBuilder.append(item).append("\n");
        }
        return stringBuilder.toString();
    }

}
