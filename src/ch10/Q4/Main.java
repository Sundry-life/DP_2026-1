package ch10.Q4;

import java.util.*;

class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("D", "B", "C", "E", "A");

        // 사전순으로 작은 순서
        list.sort( new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s1.compareTo(s2); //s1이 더 크면 양수 리턴 (s1 -s2)
                //양수 = sort에 의해서 위치 변경됨
                //즉 큰게 뒤로 감
                //그래서 오름차순 
            } 
        });
        System.out.println(list);

        //list.sort((s1,s2)->s1.compareTo(s2));
        //functional interface는 람다함수로도 대체 가능.

        // 사전순으로 큰 순서 
        list.sort( new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
              return s2.compareTo(s1);
            }
        });
        System.out.println(list);
    }
}
