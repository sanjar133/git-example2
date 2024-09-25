public class HashSet<K> {

    private static class Entry<K, V> {
        private K k;
        private V v;

        private Entry<K, V> next;

        public Entry(K k) {
            this.k = k;
        }
    }

    private Entry<K, Object> bucket[];

    public HashSet(int size) {
        this.bucket = new Entry[size];
    }

    public boolean add(K k) {
        int index = hash(k);
        Entry<K, Object> entry = bucket[index];
        if (entry == null) {
            bucket[index] = new Entry<>(k);
            return true;
        }

        while (entry.next != null) {
            if (entry.k.equals(k)) {
                return false;
            }
            entry = entry.next;
        }

        if (entry.k.equals(k)) {
            return false;
        }
        entry.next = new Entry<>(k);
        return true;
    }

    public void print() {
        StringBuilder s = new StringBuilder("[");
        for (Entry<K, Object> entry: bucket) {
            while (entry != null) {
                s.append(entry.k + " ");
                entry = entry.next;
            }
        }
        s.append("]");
        System.out.println(s);
    }
    public void remove(int key) {

    }

    private int hash(K k) {
        return k.hashCode() % 16;
    }

}
