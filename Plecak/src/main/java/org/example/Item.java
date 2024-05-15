package org.example;

public class Item implements  Comparable<Item>{
    int weight;
    int value;
    int nr;
    float ratio;
    public Item(int v, int w, int n)
    {
        weight = w;
        value = v;
        nr = n;
        ratio = (float)v / (float)w;

    }

    @Override
    public int compareTo(Item other) {
        return Float.compare(this.ratio, other.ratio);
    }

    @Override
    public String toString() {
        return "Item{number='" + nr + "', value=" +  value + ", weight=" +  weight + '}';
    }
}
