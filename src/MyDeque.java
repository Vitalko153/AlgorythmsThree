import java.util.Arrays;

public class MyDeque<T> {
    private T[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;
    private int begin;
    private int end;

    public MyDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity: " + capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public MyDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public T removeRight() {
        T temp = peekLeft();
        size--;
        end = prevIndex(end);
        list[end] = null;
        return temp;
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new RuntimeException("deque is empty");
        }
        return list[begin];
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new RuntimeException("deque is full");
        }
        size++;
        begin = prevIndex(begin);
        list[begin] = item;
    }

    public T removeLeft() {
        T temp = peekRight();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return temp;
    }

    public T peekLeft() {
        if (isEmpty()) {
            throw new RuntimeException("deque is empty");
        }
        return list[prevIndex(end)];
    }

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    private int prevIndex(int index) {
        return (list.length + index - 1) % list.length;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return Arrays.toString(list) + " b = " + begin + " e = " + end;
    }
}

