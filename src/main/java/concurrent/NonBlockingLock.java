package concurrent;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

public class NonBlockingLock<E> {

//    private volatile Node<E> tail = null;
//
//    private static final sun.misc.Unsafe UNSAFE;
//    private static final long tailOffset;
//
//    boolean casTail(Node<E> cmp, Node<E> val) {
//        return UNSAFE.compareAndSwapObject(this, tailOffset, cmp, val);
//    }
//
//    static {
//        try {
//            UNSAFE = sun.misc.Unsafe.getUnsafe();
//            Class<?> k = NonBlockingLock.class;
//            tailOffset = UNSAFE.objectFieldOffset
//                    (k.getDeclaredField("tail"));
//        } catch (Exception e) {
//            throw new Error(e);
//        }
//    }
//
//    public boolean offer(E item) {
//        Node<E> newNode = new Node<>(item);
//        for (;;) {
//            Node<E> t = tail;
//            if (casTail(null, newNode) || casTail(t, newNode)) {
//                tail.next = newNode;
//                tail = newNode;
//                return true;
//            }
//        }
//    }
    private static final AtomicBoolean flag = new AtomicBoolean(true);

    private LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<>();

    private Queue<E> queue = new LinkedList<>();

    private void add(E item) {
        for (;;) {
            if (flag.compareAndSet(true, false)) {
                queue.add(item);
                linkedBlockingQueue.add("入队成功:" + item);
                flag.compareAndSet(false, true);
                break;
            }
        }
    }

    private E remove() {
        for (;;) {
            if (flag.compareAndSet(true, false)) {
                E item = null;
                if (!queue.isEmpty()) {
                    item = queue.remove();
                }
                linkedBlockingQueue.add("出队成功:" + item);
                flag.compareAndSet(false, true);
                return item;
            }
        }
    }

    private void print() {
        while (!linkedBlockingQueue.isEmpty()) {
            System.out.println(linkedBlockingQueue.poll());
        }
    }

    public static void main(String[] args) {
        NonBlockingLock<Integer> nonBlockingLock = new NonBlockingLock<>();
        IntStream.rangeClosed(1, 10).parallel().forEach(
                i -> {
                    if (i % 2 == 0) {
                        nonBlockingLock.add(i);
                    } else {
                        nonBlockingLock.remove();
                    }
                }
        );
        nonBlockingLock.print();
    }

}


class Node<E> {
    volatile E item;
    volatile Node<E> next;

    public Node(E item) {
        this.item = item;
    }

}