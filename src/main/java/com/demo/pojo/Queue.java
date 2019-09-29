package com.demo.pojo;

/**
 * @ProjectName: springmvc
 * @Package: com.demo.pojo
 * @ClassName: Queue
 * @Author: Administrator
 * @Description: ${description}
 * @Date: 2019/9/19 16:40
 * @Version: 1.0
 */
import java.util.LinkedList;

public class Queue {

        private LinkedList ll = new LinkedList();

        public void put(Object[] o) {
            for (int i = 0; i < o.length; i++) {
                ll.addLast(o[i]);
            }
        }

        // 使用removeFirst()方法，返回队列中第一个数据，然后将它从队列中删除
        public Object get() {
            return ll.removeFirst();
        }

        public boolean empty() {
            return ll.isEmpty();
        }

        public static void main(String[] args) {
            Queue mq = new Queue();

            String[] str = { "a", "b", "c", "d" };
            mq.put(str);
            String[] str1 = { "e", "f", "g", "h" };
            mq.put(str1);
            System.out.println(mq.get());
            System.out.println(mq.get());
            System.out.println(mq.ll);

        }


}
