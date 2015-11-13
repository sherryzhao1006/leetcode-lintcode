/*Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
class Node{
    int key;
    int value;
    Node pre;
    Node next;
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}
/* head->new->...->old->tail
public class LRUCache {
    private Map<Integer,Node> map;
    private Node tail,head;
    private int cap;
    public LRUCache(int capacity) {
        cap=capacity;
        map=new HashMap<Integer,Node>();
        tail=new Node(-1,-1);
        head=new Node(-1,-1);
        head.next=tail;
        tail.pre=head;
    }
    public void moveToHead(Node cur){
        Node next=head.next;
        cur.next=next;
        next.pre=cur;
        head.next=cur;
        cur.pre=head;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node cur=map.get(key);
        Node p=cur.pre;
        Node q=cur.next;
        p.next=q;
        q.pre=p;
        moveToHead(cur);
        return cur.value;
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
            Node cur=map.get(key);
            cur.pre.next=cur.next;
            cur.next.pre=cur.pre;
            cur.value=value;
            moveToHead(cur);
        }else if(cap>map.size()){
            Node cur=new Node(key,value);
            map.put(key,cur);
            moveToHead(cur);
        }else{
            Node cur=new Node(key,value);
            moveToHead(cur);
            map.put(key,cur);
            Node del=tail.pre;
            del.pre.next=tail;
            del.next.pre=del.pre;
            map.remove(del.key);
        }
    }
}
