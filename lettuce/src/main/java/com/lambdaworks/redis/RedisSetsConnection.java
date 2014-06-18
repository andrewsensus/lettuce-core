package com.lambdaworks.redis;

import java.util.Set;

import com.lambdaworks.redis.output.ValueStreamingChannel;

/**
 * Synchronous executed commands for Sets.
 * 
 * @param <K> Key type.
 * @param <V> Value type.
 * @author <a href="mailto:mpaluch@paluch.biz">Mark Paluch</a>
 * @since 17.05.14 21:16
 */
public interface RedisSetsConnection<K, V> {
    /**
     * Add one or more members to a set.
     * 
     * @param key the key
     * @param members the member type: value
     * @return Long integer-reply the number of elements that were added to the set, not including all the elements already
     *         present into the set.
     */
    Long sadd(K key, V... members);

    /**
     * Get the number of members in a set.
     * 
     * @param key the key
     * @return Long integer-reply the cardinality (number of elements) of the set, or `0` if `key` does not exist.
     */
    Long scard(K key);

    /**
     * Subtract multiple sets.
     * 
     * @param keys the key
     * @return Set<V> array-reply list with members of the resulting set.
     */
    Set<V> sdiff(K... keys);

    /**
     * Subtract multiple sets.
     * 
     * @return Long array-reply list with members of the resulting set.
     */
    Long sdiff(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Subtract multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sdiffstore(K destination, K... keys);

    /**
     * Intersect multiple sets.
     * 
     * @param keys the key
     * @return Set<V> array-reply list with members of the resulting set.
     */
    Set<V> sinter(K... keys);

    /**
     * Intersect multiple sets.
     * 
     * @return Long array-reply list with members of the resulting set.
     */
    Long sinter(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Intersect multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sinterstore(K destination, K... keys);

    /**
     * Determine if a given value is a member of a set.
     * 
     * @param key the key
     * @param member the member type: value
     * @return Boolean integer-reply specifically:
     * 
     *         `1` if the element is a member of the set. `0` if the element is not a member of the set, or if `key` does not
     *         exist.
     */
    Boolean sismember(K key, V member);

    /**
     * Move a member from one set to another.
     * 
     * @param source the source type: key
     * @param destination the destination type: key
     * @param member the member type: value
     * @return Boolean integer-reply specifically:
     * 
     *         `1` if the element is moved. `0` if the element is not a member of `source` and no operation was performed.
     */
    Boolean smove(K source, K destination, V member);

    /**
     * Get all the members in a set.
     * 
     * @param key the key
     * @return Set<V> array-reply all elements of the set.
     */
    Set<V> smembers(K key);

    /**
     * Get all the members in a set.
     * 
     * @return Long array-reply all elements of the set.
     */
    Long smembers(ValueStreamingChannel<V> channel, K key);

    /**
     * Remove and return a random member from a set.
     * 
     * @param key the key
     * @return V bulk-string-reply the removed element, or `nil` when `key` does not exist.
     */
    V spop(K key);

    /**
     * Get one or multiple random members from a set.
     * 
     * @return V bulk-string-reply without the additional `count` argument the command returns a Bulk Reply with the randomly
     *         selected element, or `nil` when `key` does not exist.
     */
    V srandmember(K key);

    /**
     * Get one or multiple random members from a set.
     * 
     * @param key the key
     * @param count the count type: long
     * @return Set<V> bulk-string-reply without the additional `count` argument the command returns a Bulk Reply with the
     *         randomly selected element, or `nil` when `key` does not exist.
     */
    Set<V> srandmember(K key, long count);

    /**
     * Get one or multiple random members from a set.
     * 
     * @return Long bulk-string-reply without the additional `count` argument the command returns a Bulk Reply with the randomly
     *         selected element, or `nil` when `key` does not exist.
     */
    Long srandmember(ValueStreamingChannel<V> channel, K key, long count);

    /**
     * Remove one or more members from a set.
     * 
     * @param key the key
     * @param members the member type: value
     * @return Long integer-reply the number of members that were removed from the set, not including non existing members.
     */
    Long srem(K key, V... members);

    /**
     * Add multiple sets.
     * 
     * @param keys the key
     * @return Set<V> array-reply list with members of the resulting set.
     */
    Set<V> sunion(K... keys);

    /**
     * Add multiple sets.
     * 
     * @return Long array-reply list with members of the resulting set.
     */
    Long sunion(ValueStreamingChannel<V> channel, K... keys);

    /**
     * Add multiple sets and store the resulting set in a key.
     * 
     * @param destination the destination type: key
     * @param keys the key
     * @return Long integer-reply the number of elements in the resulting set.
     */
    Long sunionstore(K destination, K... keys);

    /**
     * Incrementally iterate Set elements.
     */
    ValueScanCursor<V> sscan(K key);

    /**
     * Incrementally iterate Set elements.
     */
    ValueScanCursor<V> sscan(K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     */
    ValueScanCursor<V> sscan(K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     */
    ValueScanCursor<V> sscan(K key, ScanCursor scanCursor);

    /**
     * Incrementally iterate Set elements.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key);

    /**
     * Incrementally iterate Set elements.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     * 
     * @param channel
     * @param key the key
     * @param scanCursor the cursor type: long
     * @param scanArgs
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor, ScanArgs scanArgs);

    /**
     * Incrementally iterate Set elements.
     */
    StreamScanCursor sscan(ValueStreamingChannel<V> channel, K key, ScanCursor scanCursor);
}