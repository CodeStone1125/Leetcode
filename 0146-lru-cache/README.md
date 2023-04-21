<h2><a href="https://leetcode.com/problems/lru-cache/">146. LRU Cache</a></h2><h3>Medium</h3><hr><div><p>Design a data structure that follows the constraints of a <strong><a href="https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU" target="_blank">Least Recently Used (LRU) cache</a></strong>.</p>

<p>Implement the <code>LRUCache</code> class:</p>

<ul>
	<li><code>LRUCache(int capacity)</code> Initialize the LRU cache with <strong>positive</strong> size <code>capacity</code>.</li>
	<li><code>int get(int key)</code> Return the value of the <code>key</code> if the key exists, otherwise return <code>-1</code>.</li>
	<li><code>void put(int key, int value)</code> Update the value of the <code>key</code> if the <code>key</code> exists. Otherwise, add the <code>key-value</code> pair to the cache. If the number of keys exceeds the <code>capacity</code> from this operation, <strong>evict</strong> the least recently used key.</li>
</ul>

<p>The functions <code>get</code> and <code>put</code> must each run in <code>O(1)</code> average time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input</strong>
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
<strong>Output</strong>
[null, null, null, 1, null, -1, null, -1, 3, 4]

<strong>Explanation</strong>
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= capacity &lt;= 3000</code></li>
	<li><code>0 &lt;= key &lt;= 10<sup>4</sup></code></li>
	<li><code>0 &lt;= value &lt;= 10<sup>5</sup></code></li>
	<li>At most <code>2 * 10<sup>5</sup></code> calls will be made to <code>get</code> and <code>put</code>.</li>
</ul>
</div>

<h2>解法</h2>

**Main idea**:我們設定left是LRU的dummy node，right
1. 為了方便追蹤前一個和後一個node所以使用的是double linklist
2. put與get會時常需要更新linklist的位置，所以額外撰寫insert和remove來進行節點位置更新
3. 利用hashmap來做為紀錄linknode的key直接map到node
```
class LRUCache {
    private Map<Integer, Node> cache;
    private int capacity;
    
    private Node left;
    private Node right; 

    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(); 
        
        this.left = new Node(0,0);//left: LRU , right: recent
        this.right = new Node(0,0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
            insert(cache.get(key));
            return cache.get(key).val;
        }
        else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            remove(cache.get(key));
        }
        cache.put(key, new Node(key, value));
        insert(cache.get(key));
        
        if(cache.size()>capacity){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
    
    public void insert(Node node)  {
        Node prev = this.right.prev;
        Node next = this.right;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
        
    }
    
    public void remove(Node node)  {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
        
    }

    private class Node{
        private int key;
        private int val;
        
        Node next;
        Node prev;
        
        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }
    
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
```


需要注意的是put，如果在已經到達capacity的上限時，要記得把LRU的 victim node移出，同時hashmap中的資訊也要移掉。
```
public void put(int key, int value) {
    if(cache.containsKey(key)){
        remove(cache.get(key));
    }
    cache.put(key, new Node(key, value));
    insert(cache.get(key));

    if(cache.size()>capacity){
        Node lru = left.next;
        remove(lru);
        cache.remove(lru.key);
    }
}
```

另外在hashmap中的node沒有所謂的順序，因為hashmap只是作為pointer的存在，因此insert和remove都沒有對hashmap做操作。

```

public void insert(Node node)  {
    Node prev = this.right.prev;
    Node next = this.right;
    prev.next = node;
    next.prev = node;
    node.next = next;
    node.prev = prev;

}

public void remove(Node node)  {
    Node prev = node.prev;
    Node next = node.next;

    prev.next = next;
    next.prev = prev;

}
```

![](https://i.imgur.com/yd1eDkL.png)




