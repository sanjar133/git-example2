public class MyHashMap<K, V> {

    private static class Entry<K, V> {
        private K k;
        private V v;
        private Entry<K, V> next;

        public Entry(K k, V v) {
            this.k = k;
            this.v = v;
        }
    }

    private Entry<K, V>[] bucket;

    public MyHashMap() {
        this(16);
    }

    public MyHashMap(int size) {
        this.bucket = new Entry[size];
    }

    public V put(K k, V v) {
        int index = hash(k);
        Entry<K, V> entry = bucket[index];

        if (entry == null) {
            bucket[index] = new Entry<>(k, v);
            return null;
        }

        while (entry.next != null) {
            if (entry.k.equals(k)) {
                V oldV = entry.v;
                entry.v = v;
                return oldV;
            }

            entry = entry.next;
        }

        if (entry.k.equals(k)) {
            V oldV = entry.v;
            entry.v = v;
            return oldV;
        }

        entry.next = new Entry<>(k, v);
        return null;
    }

    public void print() {
        StringBuilder s = new StringBuilder();
        s.append("{");
        for (Entry<K, V> entry : bucket) {
            while (entry != null) {
                s.append(entry.k + "=" + entry.v + " ");
                entry = entry.next;
            }
        }
        s.append("}");

        System.out.println(s.toString().trim());
    }

    private int hash(K k) {
        return k.hashCode() % 16;
    }
}
