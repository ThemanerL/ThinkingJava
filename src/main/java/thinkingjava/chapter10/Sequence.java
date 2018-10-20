package thinkingjava.chapter10;

/**
 * @author 李重辰
 * @date 2018/10/20 12:27
 */
public class Sequence {
    private Object[] items;
    private int next = 0;

    private Sequence(int size) {
        this.items = new Object[size];
    }

    private void add(Object x) {
        if (next < items.length) {
            items[next++] = x;
        }
    }

    private class SequenceSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == items.length;
        }

        public Object current() {
            return items[i];
        }

        public void next() {
            if (i < items.length) {
                i++;
            }
        }
    }

    private Selector selector() {
        return new SequenceSelector();
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence(10);
        for (int i = 0; i < 10; i++) {
            sequence.add(Integer.toString(i));
        }
        Selector selector = sequence.selector();
        while (!selector.end()){
            System.out.println(selector.current() + " ");
            selector.next();
        }
    }
}

interface Selector {
    /**
     * 结束
     * @return 标志位
     */
    boolean end();

    /**
     * 当前
     * @return 返回一个对象数组
     */
    Object current();

    /**
     * 下一个
     */
    void next();
}