package leetcode.other;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

//Leetcode146
/*
public class LRUCache {
    //LRU，链表尾表示最近使用

    int cap;
    //头尾虚节点
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    Map<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        //如果不存在,则返回-1
        if (!map.containsKey(key)) {
            return -1;
        }

        //如果存在,更新为最近使用
        makeRecently(key);
        return map.get(key).val;
    }

    public void put(int key, int value) {
        //如果存在
        //更新为最近使用
        if (map.containsKey(key)) {
            delNode(key);
            addRecently(key, value);
            return;
        }

        //如果不存在，则新添加
        //如果达到上限，删除最不近使用的，然后添加
        if (this.cap == map.size()) {
            removeLeastRecently();
        }
        //如果未达到上限，则直接添加
        addRecently(key, value);
    }

    private void delNode(int key) {
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(key);
    }

    private void addRecently(int key, int val) {
        Node node = new Node(key, val);
        //添加到最后
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
        //加入map
        map.put(key, node);
    }

    //更新节点为最近使用
    private void makeRecently(int key) {
        //把节点从原位置删除
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        //然后加入到最后
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

    private void removeLeastRecently() {
        //从map中删除
        map.remove(head.next.key);
        //从链表中删除
        Node node = head.next;
        head.next = node.next;
        node.next.prev = head;
    }

    public static void main(String[] args) {

    }
}

class Node {
    public int key, val;
    public Node next, prev;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

 */

public class LRUCache {
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        //如果取不到则返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //将此节点删除并插入到最后
        int val = map.get(key);
        map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value) {
        //如果不为空，则删除此节点并插入到最后
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        //如果为空，判断是否达到capacity
        //如果达到上限，删除头节点
        if (map.size() == capacity) {
            int headKey = map.entrySet().iterator().next().getKey();
            map.remove(headKey);
        }
        //添加到最后
        map.put(key, value);
    }
}
