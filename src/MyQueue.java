public class MyQueue<T> {
    private T[] queue;
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public MyQueue(){
        queue = (T[])new Object[10];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public MyQueue(int size){
        queue = (T[])new Object[size];
        this.head = 0;
        this.tail = 0;
        this.count = 0;
    }

    public boolean inQueue(T t){
        if(count == queue.length){
            return false;
        }
        queue[tail%(queue.length)] = t;
        tail++;
        count++;
        return true;
    }

    public T outQueue(){
        if(count == 0)
            return null;
        T t = queue[head%(queue.length)];
        head++;
        count--;
        return t;
    }

    public T peek(){
        if(count == 0)return null;
        return queue[head];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == queue.length;
    }

    public static void main(String[] args) {
        MyQueue<Integer> q = new MyQueue<Integer>();
        q.inQueue(1);
        System.out.println(q.peek());
    }
}
