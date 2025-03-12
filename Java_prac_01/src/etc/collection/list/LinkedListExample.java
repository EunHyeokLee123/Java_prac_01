package etc.collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<Integer> arr1 = new LinkedList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();

        arr1.addFirst(-2);
        arr1.addLast(1000);

        for (int i = 0; i <= 100; i+=2) {
            arr2.add(i);
        }

        // LIFO, push(), pop(), peek()
        arr1.push(3);
        arr1.pop();
        System.out.println(arr1.peek());

        System.out.println(arr1);


        List<Integer> array = new ArrayList<>();
        List<Integer> linked = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) {
            array.add(i);
            linked.add(i);
        }

        long start, end;
        // 배열리스트에서 데이터 제어
        start = System.currentTimeMillis();
        for (int i = 0; i < array.size(); i++) {
//            array.remove(0);
            array.get(i);
        }

        end = System.currentTimeMillis();

        System.out.printf("배열리스트의 소요시간: %dms\n", end-start);


        // 연결리스트에서 데이터 제어
        start = System.currentTimeMillis();
        for (int i = 0; i < linked.size(); i++) {
//            linked.remove(0);
            linked.get(i);
        }

        end = System.currentTimeMillis();

        System.out.printf("연결리스트의 소요시간: %dms\n", end-start);

    }
}
