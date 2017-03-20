package com.company;
 
import java.util.*;
 
/**
 * Created by Alexander on 13.03.17.
 */
 
public class Main {
	
	public static void TestTree() {
        TreeSet<Integer> tree = new TreeSet<Integer>();
        
        tree.add(4);
        tree.add(2);
        tree.add(8);
        tree.add(7);
        tree.add(9);
        tree.add(5);
        int size = tree.size();
        tree.remove(4);
        size = tree.size();  
        System.out.println("Tree size: " + size);
    }    
	
	public static void TestHashMap(){
		HashMap<String, Integer> map = new HashMap<>(10);
        map.put("q", 10);
        map.put("a", 1);
        map.put("b", 2);   
        map.put("j", 57);
        map.put("v", 28);
        
        map.clear();
       
        System.out.println("Contains key:");        
        System.out.println(map.containsKey("q"));
        System.out.println(map.containsKey("c"));
        System.out.println(map.containsKey("z"));
        System.out.println(map.containsKey("b")); 
        
        System.out.println("Map get:");
        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
        System.out.println(map.get("d"));
        
        System.out.println("ContainsValue:");
        System.out.println(map.containsValue(1));
        System.out.println(map.containsValue(3));
        System.out.println(map.containsValue(10)); 
	}
 
    public static void TestArrayList() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3); 
        
        System.out.println("ArrayList: " + arrayList.isEmpty());
        
        Iterator<Integer> iterator = arrayList.getIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
 
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + " : " + arrayList.get(i));
        }
    }  
 
    public static void main(String[] args) {
        TestTree();   
        
        TestHashMap();      
        
        TestArrayList();
    }    
}