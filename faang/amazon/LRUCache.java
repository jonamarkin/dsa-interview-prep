package faang.amazon;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class Node{
        int key, value;
        Node prev, next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> map;
    int capacity;

    Node head, tail;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;

        head = new Node(0, 0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);

            remove(node);
            insertAtFront(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            //Update
            Node node = map.get(key);
            node.value =value;
            remove(node);
            insertAtFront(node);
        }else{
            if (map.size() == capacity){
                //Remove the least recently used
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }

            //Insert new node at from
            Node newNode = new Node(key, value);
            insertAtFront(newNode);
            map.put(key, newNode);
        }
    }

    public void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;

    }
}
