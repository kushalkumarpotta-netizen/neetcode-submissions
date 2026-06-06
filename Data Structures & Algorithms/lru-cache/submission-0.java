class LRUCache {

    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;

    private void addNode(Node newNode){
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void removeNode(Node oldNode)
    {
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
    }

    private void moveToFront(Node Node)
    {
        removeNode(Node);
        addNode(Node);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key))
        {
            return -1;
        }

        Node node = map.get(key);
        moveToFront(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key))
        {
            Node node = map.get(key);
            node.value = value;

            moveToFront(node);
        }
        else{
            Node node = new Node(key,value);
            map.put(key,node);
            addNode(node);

            if(map.size() > capacity)
            {
                Node last = tail.prev;
                removeNode(last);
                map.remove(last.key);
            }
        }
    }

    //get -> get the value if exist 
    //if not exist -1 
    //return value of key
    //move to front 

    //put -> if exist then update the value of key
    //if not exist add key value and hashmap
    //move to front 

    //move to front -> remove from existing
    //add to front 
}
