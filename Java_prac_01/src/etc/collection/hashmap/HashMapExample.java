package etc.collection.hashmap;

import java.util.HashMap;

public class HashMapExample {
    public static void main(String[] args) {
        /*
        # Map
        - Key / Value가 한 세트를 이루는 자료구조
        - Key값을 통해 Value를 참조하는 방식 (인덱스 x)
        - Key는 중복 저장을 허용하지 않음.
         */

        HashMap<String, String> hmap = new HashMap<>();

        hmap.put("key1", "이은혁");
        hmap.put("key2", "이명철");
        hmap.put("key3", "김민성");
        hmap.put("key4", "강진성");
        // key중복되는 경우 기존 value값이 바뀌게됨.
        hmap.put("key1", "이은혁");
        // value는 중복 가능
        hmap.put("key5", "이은혁");

        System.out.println(hmap.get("key1"));
        System.out.println(hmap);

        if(hmap.containsKey("key1"))
            System.out.println(hmap.get("key1"));

        // Map에서 key들만 추출하는 메서드 keySet()
        // 모든 key들을 담은 set -> for-each문에서 사용 가능

        for (String s : hmap.keySet()) {
            System.out.printf("key = %s, value = %s \n", s, hmap.get(s));
        }

        hmap.remove("key5");
        System.out.println("hmap = " + hmap);

        hmap.clear();
        System.out.println("hmap = " + hmap);


    }
}
