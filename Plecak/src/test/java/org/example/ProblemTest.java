package org.example;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;;
class ProblemTest {

    @Test
    public void AtLeast1(){
        Problem pr1 = new Problem(1,1,10,10);
        assertEquals(1, pr1.Solve(10).capacity);
    }
    @Test
    public void AtLeast2(){
        Problem pr1 = new Problem(2,1,100,100);
        assertEquals(2, pr1.Solve(200).capacity);
    }

    @Test
    public void NoOne(){
        Problem pr1 = new Problem(1,1,100,100);
        assertEquals(0, pr1.Solve(10).capacity);
    }

    @Test
    public void testWeight() {
        int minWeight = 1;
        int maxWeight = 10;
        Problem problem = new Problem(5, 1, minWeight, maxWeight);

        for (Item item : problem.items) {
            assertTrue(item.weight >= minWeight && item.weight <= maxWeight);
        }
    }

    @Test
    public void testSum() {

        Problem problem = new Problem(10, 1, 1, 10);
        int weights = 0;
        int values = 0;
        for (Item item : problem.items) {
            weights += item.weight;
            values += item.value;
        }
        assertEquals(60, weights);
        assertEquals(64, values);
    }

    @Test
    public void testInstance() {
        Problem problem = new Problem(10, 1, 1, 10);
        List<Integer> result = problem.Solve(10).items;
        List<Integer> required = new ArrayList<>();
        required.add(6);
        required.add(6);
        assertEquals(required, result);


    }



}