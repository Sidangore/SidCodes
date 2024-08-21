package org.siddhantangore.hashing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Example_1_ImplementingChaining {
    static class MyHash {
        int BUCKET; // Usually preferred to be a prime number
        ArrayList<LinkedList<Integer>> hashTable;
        protected MyHash(int BUCKET) {
            this.BUCKET = BUCKET;
            this.hashTable = new ArrayList<>();
            for(int i = 0; i < this.BUCKET; i++) {
                this.hashTable.add(new LinkedList<>());
            }
        }
        private int myHashFunction(int key) {
            return key % BUCKET;
        }
        protected void insert(int key) {
            int index = myHashFunction(key);
            hashTable.get(index).add(key);

        }
        protected void remove(int key) {
            int index = myHashFunction(key);
            hashTable.get(index).remove((Integer) key);
        }
        protected boolean search(int key) {
            int index = myHashFunction(key);
            return hashTable.get(index).contains(key);
        }

        protected void display() {
            System.out.println();
            int index = 0;
            for(LinkedList<Integer> ll: hashTable) {
                System.out.println(index++ + ": " + ll);
            }
        }
    }
    public static void main(String[] args) {
        // Input
        int bucketSize;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the BUCKET size = ");
        bucketSize = sc.nextInt();

        // Configuration
        MyHash myHash = new MyHash(bucketSize);

        // Insertions
        myHash.insert(70);
        myHash.insert(72);
        myHash.insert(9);
        myHash.insert(12);
        myHash.insert(56);
        myHash.insert(63);

        // Display
        myHash.display();

        // Search
        System.out.println();
        System.out.println("72: " + myHash.search(72));
        System.out.println("9: " + myHash.search(9));
        System.out.println("6: " + myHash.search(6));

        myHash.display();

        // Remove
        myHash.remove(9);
        myHash.remove(56);

        myHash.display();

    }
}

