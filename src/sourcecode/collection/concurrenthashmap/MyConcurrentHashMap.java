package sourcecode.collection.concurrenthashmap;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author jianshen
 *
 * Reference http://www.mianwww.com/html/2014/04/20670.html for thoughts behind
 */
//comment out for the compile of other project
//public class MyConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
//    /**
//     * Mask value for indexing into segments. The upper bits of a
//     * key’s hash code are used to choose the segment.
//     */
//    final int segmentMask;
//
//    /**
//     * Shift value for indexing within segments.
//     */
//    final int segmentShift;
//
//    /**
//     * The segments, each of which is a specialized hash table
//     */
//    final Segment<K,V>[] segments;
//
//    public V remove(Object key) {
//        int hash = hash(key.hashCode());
//        return segmentFor(hash).remove(key, hash, null);
//    }
//
//    private static int hash(int h) {
//// Spread bits to regularize both segment and index locations,
//// using variant of single-word Wang/Jenkins hash.
//        h += (h << 15) ^ 0xffffcd7d;
//
//        h ^= (h >>> 10);
//
//        h += (h << 3);
//
//        h ^= (h >>> 6);
//
//        h += (h << 2) + (h << 14);
//
//        return h ^ (h >>> 16);
//    }
//
//    //定位段的方法
//    final Segment<K,V> segmentFor(int hash) {
//        return segments[(hash >>> segmentShift) & segmentMask];
//    }
//
//    static final class HashEntry<K,V> {
//        final K key;
//        final int hash;
//        volatile V value;
//        final HashEntry<K,V> next;
//    }
//
//    static final class Segment<K,V> extends ReentrantLock implements Serializable {
//        private static final long serialVersionUID = 2249069246763182397L;
//
//        /**
//         * The number of elements in this segment’s region.
//         */
//        transient volatile int count;
//
//        /**
//         * Number of updates that alter the size of the table. This is
//         * used during bulk-read methods to make sure they see a
//         * consistent snapshot: If modCounts change during a traversal
//         * of segments computing size or checking containsValue, then
//         * we might have an inconsistent view of state so (usually)
//         * must retry.
//         */
//        transient int modCount;
//
//        /**
//        * The table is rehashed when its size exceeds this threshold.
//        * (The value of this field is always <tt>(int)(capacity *
//        * loadFactor)</tt>.)
//        */
//        transient int threshold;
//
//        /**
//         * The per-segment table.
//         */
//        transient volatile HashEntry<K,V>[] table;
//
//        /**
//         * The load factor for the hash table. Even though this value
//         * is same for all segments, it is replicated to avoid needing
//         * links to outer object.
//         * @serial
//         */
//        final float loadFactor;
//
//        V remove(Object key, int hash, Object value) {
//            lock();
//            try {
//                int c = count-1;
//                HashEntry<K,V>[] tab = table;
//
//                int index = hash & (tab.length - 1);
//
//                HashEntry<K,V> first = tab[index];
//
//                HashEntry<K,V> e = first;
//
//                while (e != null && (e.hash != hash || !key.equals(e.key))) {
//                    e = e.next;
//                }
//
//                V oldValue = null;
//                if (e != null) {
//
//                    V v = e.value;
//
//                    if (value == null || value.equals(v)) {
//
//                        oldValue = v;
//
//// All entries following removed node can stay
//// in list, but all preceding ones need to be
//// cloned.
//
//                        ++modCount;
//
//                        HashEntry<K,V> newFirst = e.next;
//
//                        for (HashEntry<K,V> p = first; p != e; p = p.next)
//
//                            newFirst = new HashEntry<K,V>(p.key, p.hash, p.value, newFirst);
//
//                        tab[index] = newFirst;
//
//                        count = c; // write-volatile
//
//                    }
//
//                }
//
//                return oldValue;
//
//            } finally {
//
//                unlock();
//
//            }
//
//        }
//
//        V put(K key, int hash, V value, boolean onlyIfAbsent) {
//            lock();
//            try {
//                int c = count;
//                if (c++ > threshold) // ensure capacity
//                    rehash();
//                HashEntry<K,V>[] tab = table;
//                int index = hash & (tab.length - 1);
//                HashEntry<K,V> first = tab[index];
//                HashEntry<K,V> e = first;
//
//                while (e != null && (e.hash != hash || !key.equals(e.key)))
//                    e = e.next;
//
//                V oldValue;
//
//                if (e != null) {
//                    oldValue = e.value;
//                    if (!onlyIfAbsent)
//                        e.value = value;
//                }
//                else {
//                    oldValue = null;
//                    ++modCount;
//                    tab[index] = new HashEntry<K,V>(key, hash, first, value);
//                    count = c; // write-volatile
//                }
//                return oldValue;
//            } finally {
//                unlock();
//            }
//        }
//
//        //get操作不需要锁
//        V get(Object key, int hash) {
//            if (count != 0) { // read-volatile
//                HashEntry<K,V> e = getFirst(hash);
//                while (e != null) {
//                    if (e.hash == hash && key.equals(e.key)) {
//                        V v = e.value;
//                        if (v != null)
//                            return v;
//                        return readValueUnderLock(e); // recheck
//                    }
//                    e = e.next;
//                }
//            }
//            return null;
//        }
//
//        V readValueUnderLock(HashEntry<K,V> e) {
//            lock();
//            try {
//                return e.value;
//            } finally {
//                unlock();
//            }
//        }
//
//        boolean containsKey(Object key, int hash) {
//            if (count != 0) { // read-volatile
//                HashEntry<K,V> e = getFirst(hash);
//                while (e != null) {
//                    if (e.hash == hash && key.equals(e.key))
//                        return true;
//                    e = e.next;
//                }
//            }
//            return false;
//        }
//
//    }
//}


