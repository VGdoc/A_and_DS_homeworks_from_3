package HW8;

import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final ArrayList<Item<K, V>>[] data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public HashTableImpl(int initialCapacity) {
        data = new ArrayList[initialCapacity];
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {

        int index = hashFunc(key);

        if (data[index] == null) {
            data[index] = new ArrayList<>();
        }

        data[index].add(new Item<>(key, value));
        size++;

        return true;
    }


    private boolean isKeysEquals(Item<K, V> item, K key) {
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);

        if (index == -1) {
            return null;
        } else {
            for (Item<K, V> item : data[index]) {
                if (isKeysEquals(item, key)) {
                    return item.value;
                }
            }
        }
        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);

        if (data[index] == null) {
            return -1;
        } else {
            for (Item<K, V> item : data[index]) {
                if (isKeysEquals(item, key)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        }

        Item<K, V> removed = data[index].get(data[index].indexOf(getItem(key)));
        data[index].remove(removed);

        return removed.getValue();
    }

    private Item<K, V> getItem(K key) {

        int index = indexOf(key);

        if (data[index] == null) {
            return null;
        } else {
            for (Item<K, V> item : data[index]) {
                if (isKeysEquals(item, key)) {
                    return item;
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%s = [%s]%n", i, data[i]));
        }
        return sb.toString();
    }
}
