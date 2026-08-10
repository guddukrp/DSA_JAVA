# Java Collections Cheat Sheet

# Collections Hierarchy
Collection
│
├── List
│   ├── ArrayList
│   ├── LinkedList
│   ├── Vector
│   └── Stack
│
├── Set
│   ├── HashSet
│   ├── LinkedHashSet
│   └── SortedSet
│       └── TreeSet
│
└── Queue
    ├── PriorityQueue
    └── BlockingQueue
        ├── PriorityBlockingQueue
        └── LinkedBlockingQueue

Map  ← Separate from Collection
├── HashMap
├── LinkedHashMap
├── TreeMap
└── Hashtable

## Common `Collection` Methods

```java
boolean add(E e)
boolean addAll(Collection<? extends E> c)
boolean remove(Object o)
boolean removeAll(Collection<?> c)
boolean contains(Object o)
boolean containsAll(Collection<?> c)
boolean retainAll(Collection<?> c)
Object[] toArray()
int size()
void clear()
boolean isEmpty()
```

Sorting:

```java
Collections.sort(list);                         // natural order
Collections.sort(list, Collections.reverseOrder());
Collections.sort(list, comparator);

list.subList(fromIndex, toIndex);               // view of a range, toIndex exclusive
Collections.sort(list.subList(fromIndex, toIndex));
```

## List

Ordered collection, allows duplicates, index-based access.

Implementations:

- `ArrayList`: fast random access, slower middle insert/delete.
- `LinkedList`: fast add/remove at ends, slower random access.
- `Vector`: synchronized legacy resizable array.
- `Stack`: legacy LIFO stack; prefer `Deque`/`ArrayDeque` for new code.

Important methods:

```java
boolean add(E e)
void add(int index, E element)
boolean addAll(int index, Collection<? extends E> c)
E get(int index)
E set(int index, E element)
E remove(int index)
int indexOf(Object o)
int lastIndexOf(Object o)
int size()
```

### `ArrayList`

```java
ArrayList<E> list = new ArrayList<>();
ArrayList<E> list = new ArrayList<>(initialCapacity);
ArrayList<E> list = new ArrayList<>(collection);
```

### `LinkedList`

```java
LinkedList<E> list = new LinkedList<>();
LinkedList<E> list = new LinkedList<>(collection);

list.getFirst();
list.getLast();
list.addFirst(e);
list.addLast(e);
list.removeFirst();
list.removeLast();
```

### `Vector`

```java
Vector<E> vector = new Vector<>();
Vector<E> vector = new Vector<>(collection);
Vector<E> vector = new Vector<>(initialCapacity);
Vector<E> vector = new Vector<>(initialCapacity, capacityIncrement);
```

### `Stack`

```java
Stack<E> stack = new Stack<>();

stack.push(e);
stack.pop();
stack.peek();
stack.search(o);
stack.empty();
```

## Set

Stores unique elements. No duplicates.

Implementations:

- `HashSet`: no ordering guarantee, fastest general-purpose set.
- `LinkedHashSet`: maintains insertion order.
- `TreeSet`: sorted order, implements `NavigableSet`/`SortedSet`.

### `HashSet`

```java
HashSet<E> set = new HashSet<>();
HashSet<E> set = new HashSet<>(initialCapacity);
HashSet<E> set = new HashSet<>(initialCapacity, loadFactor);
HashSet<E> set = new HashSet<>(collection);
```

### `LinkedHashSet`

```java
LinkedHashSet<E> set = new LinkedHashSet<>();
```

### `TreeSet`

```java
TreeSet<E> set = new TreeSet<>();
TreeSet<E> set = new TreeSet<>(collection);
TreeSet<E> set = new TreeSet<>(comparator);
TreeSet<E> set = new TreeSet<>(sortedSet);

set.first();
set.last();
set.headSet(e);    // elements less than e
set.tailSet(e);    // elements greater than or equal to e
```

## Queue

Usually FIFO. `PriorityQueue` removes elements by priority/natural order.

```java
Queue<E> queue = new LinkedList<>();
Queue<E> queue = new ArrayDeque<>();
```

Important methods:

```java
boolean offer(E e)   // insert; returns false if insertion fails
E peek()             // get first element; null if empty
E poll()             // get and remove first element; null if empty
E element()          // get first element; throws NoSuchElementException if empty
E remove()           // get and remove first element; throws NoSuchElementException if empty
```

### `PriorityQueue`

```java
PriorityQueue<E> pq = new PriorityQueue<>();
PriorityQueue<E> pq = new PriorityQueue<>(comparator);

pq.add(e);
pq.offer(e);
pq.peek();
pq.poll();
pq.remove();
pq.size();
```

## Comparable / Comparator

Use `Comparable` for natural ordering of a class.

```java
class Student implements Comparable<Student> {
    public int compareTo(Student other) {
        return Integer.compare(this.id, other.id);
    }
}
```

Use `Comparator` for custom or multiple orderings.

```java
Comparator<Student> byName = (a, b) -> a.name.compareTo(b.name);
Comparator<Student> byIdDesc = (a, b) -> Integer.compare(b.id, a.id);

Collections.sort(list, byName);
list.sort(byIdDesc);
```

## Map

Stores key-value pairs. Keys are unique; values can be duplicated. `Map` is not a subtype of `Collection`.

Implementations:

- `HashMap`: no ordering guarantee.
- `LinkedHashMap`: maintains insertion order.
- `TreeMap`: sorted by key.
- `Hashtable`: synchronized legacy map.

Constructors:

```java
HashMap<K, V> map = new HashMap<>();
HashMap<K, V> map = new HashMap<>(initialCapacity);
HashMap<K, V> map = new HashMap<>(initialCapacity, loadFactor);
HashMap<K, V> map = new HashMap<>(otherMap);
```

Important methods:

```java
V put(K key, V value)
void putAll(Map<? extends K, ? extends V> m)
V get(Object key)
V remove(Object key)
boolean containsKey(Object key)
boolean containsValue(Object value)
boolean isEmpty()
int size()
void clear()

Set<K> keySet()
Collection<V> values()
Set<Map.Entry<K, V>> entrySet()
```

Iterating entries:

```java
for (Map.Entry<K, V> entry : map.entrySet()) {
    K key = entry.getKey();
    V value = entry.getValue();
}
```

## Interview Quick Notes

### Time Complexity

| Collection | Access/Search | Insert/Delete | Notes |
|---|---:|---:|---|
| `ArrayList` | `O(1)` access, `O(n)` search | `O(1)` append amortized, `O(n)` middle insert/delete | Best for index-based access |
| `LinkedList` | `O(n)` access/search | `O(1)` at ends, `O(n)` by index | Good as queue/deque |
| `HashSet` | `O(1)` average | `O(1)` average | No order, unique values |
| `TreeSet` | `O(log n)` | `O(log n)` | Sorted unique values |
| `HashMap` | `O(1)` average by key | `O(1)` average | Key-value lookup |
| `TreeMap` | `O(log n)` by key | `O(log n)` | Sorted by key |

### Common Interview Traps

- Prefer `ArrayDeque` over legacy `Stack` for stack/queue usage.
- `HashMap` allows one `null` key and multiple `null` values.
- `Hashtable` does not allow `null` keys or `null` values.
- `TreeSet` and `TreeMap` need natural ordering or a `Comparator`.
- For custom objects in `HashSet`/`HashMap`, override both `equals()` and `hashCode()`.
- `Comparable` defines natural order inside the class; `Comparator` defines external/custom order.
- Queue safe methods: `offer()`, `poll()`, `peek()` return special values.
- Queue exception methods: `add()`, `remove()`, `element()` throw exceptions on failure/empty queue.
