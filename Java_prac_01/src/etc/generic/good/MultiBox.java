package etc.generic.good;

public class MultiBox<K, V> {
    private K key;
    private V value;

    public MultiBox(V value, K key) {
        this.value = value;
        this.key = key;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
