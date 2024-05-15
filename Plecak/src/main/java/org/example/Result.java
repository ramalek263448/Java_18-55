package org.example;

import java.util.ArrayList;
import java.util.List;

public class Result {
    int weights;
    int values;
    int capacity;
    List<Integer> items;
    public Result()
    {
        weights = 0;
        values = 0;
        capacity = 0;
        items = new ArrayList<>();

    }

    public void addItem(Item item) {
        items.add(item.nr);
        weights += item.weight;
        values += item.value;
        ++capacity;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Result{capacity='" + capacity + "', values=" +  values + ", weights=" +  weights + '}' + '\n');
        stringBuilder.append("Order: ");
        for (int item : items) {
            stringBuilder.append(item).append(" ");
        }
        return stringBuilder.toString();
    }

}
