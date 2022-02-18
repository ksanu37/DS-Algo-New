package design;

/*
    https://www.geeksforgeeks.org/lru-cache-implementation/

    We are given total possible page numbers that can be referred.
    We are also given cache (or memory) size (Number of page frames that cache can hold at a time).
    he LRU caching scheme is to remove the least recently used frame when the cache is full
    and a new page is referenced which is not there in cache.


    Using Dequeue: We can use a doubly ended queue to maintain the keys
        --> Whenever a key is put:
               if the key is present, remove it from the queue and add it in front
               if the key is not present:
                    if the cache size is less than capacity, simply add it in front
                    else remove the last element in the queue(This is the Least Recently Used key)
                        and add the key in the front.


 */

import java.util.*;

public class LRUCache {
    private Deque<Integer> dequeue;
    private HashMap<Integer, Integer> map;
    private int capactiy;

    LRUCache(int capactiy){
        dequeue = new LinkedList<>();
        map = new HashMap<>();
        this.capactiy = capactiy;
    }

    public void put(int key, int value){
        if(!map.containsKey(key)){ // The key is not present in the cache
            if(dequeue.size() == capactiy){
               int last = dequeue.removeLast(); // if the size is reached, removed LRU key
                 map.remove(last);
            }
        } else { // The key is present, move it to the front
            dequeue.remove(key);
        }
        dequeue.addFirst(key); // Add the key to the beginning of the queue
        map.put(key, value);
    }

    public int get(int key){
        if(map.containsKey(key)){ // If the cache contains the key, move it to front
            dequeue.remove(key);
            dequeue.push(key);
            return map.get(key);
        }
        return -1;
    }
}
