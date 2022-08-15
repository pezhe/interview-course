package ru.pezhe.interview.lesson2;

public class TestApp {

    public static void main(String[] args) {
        MyList<String> myList = new MyArrayList<>();
//        MyList<String> myList = new MyLinkedList<>();
        System.out.println("Initial empty list");
        System.out.println("Size: " + myList.size());
        System.out.println("listing: " + myList);
        System.out.println("\nAdding first 5 elements \"Lorem ipsum dolor amet, consectetur\"");
        myList.add("Lorem");
        myList.add("ipsum");
        myList.add("dolor");
        myList.add("amet,");
        myList.add("consectetur");
        System.out.println("Size: " + myList.size());
        System.out.println("listing: " + myList);
        System.out.println("\nInserting 1 element to index 3 \"sit\"");
        myList.add(3, "sit");
        System.out.println("Size: " + myList.size());
        System.out.println("listing: " + myList);
        System.out.println("\nAdding 2 more elements \"adipiscing elit,\"");
        myList.add("adipiscing");
        myList.add("elit,");
        System.out.println("Size: " + myList.size());
        System.out.println("listing: " + myList);
        System.out.println("\nRemoving 1 element from index 5");
        System.out.println(myList.remove(5));
        System.out.println("Size: " + myList.size());
        System.out.println("listing: " + myList);
        System.out.println("\nGetting 1 element from index 5");
        System.out.println(myList.get(5));
        System.out.println("\nTesting iterator in foreach cycle");
        for (String s : myList) {
            System.out.println(s);
        }
    }

}
