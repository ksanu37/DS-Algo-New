package design;

/*
    https://www.geeksforgeeks.org/lru-cache-implementation/

    We are given total possible page numbers that can be referred.
    We are also given cache (or memory) size (Number of page frames that cache can hold at a time).
    he LRU caching scheme is to remove the least recently used frame when the cache is full
    and a new page is referenced which is not there in cache.


    Using Dequeue: We can use a doubly ended queue to maintain the keys
        --> Whenever a key is referred:
               if the key is present, remove it from the queue and add it in front
               if the key is not present:
                    if the cache size is less than capacity, simply add it in front
                    else remove the last element in the queue(This is the Least Recently Used key)
                        and add the key in the front.


 */

public class LRUCache {
}
