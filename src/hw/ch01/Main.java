package hw.ch01;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf(10);
        shelf.appendBook(new Book("클린코드","기술",2008, 30000));
        shelf.appendBook(new Book("해리포터와 마법사의 돌","소설",1997,15000));
        shelf.appendBook(new Book("사피엔스","역사",2011,18000));
        shelf.appendBook(new Book("이펙티브 자바","기술",2018,36000));
        shelf.appendBook(new Book("객체지향의 사실과 오해","기술",2015,20000));
        shelf.appendBook(new Book("레미제라블","소설",1862,12000));
        shelf.appendBook(new Book("총균쇠","역사",1997,22000));
        shelf.appendBook(new Book("리팩터링","기술",2018,34000));
        shelf.appendBook(new Book("로마인 이야기","역사",1992,25000));
        shelf.appendBook(new Book("어린 왕자","소설",1943,9000));


        // 명시적으로 Iterator를 사용하는 방법 
        Iterator<Book> it = shelf.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println(book.getName());
        }
        System.out.println("\n");

        //---------------------------------
        Iterator<Book> it1 = shelf.iteratorByGenre("기술");
        while(it1.hasNext()){
            Book b = it1.next();
            System.out.println(b.getName()+" "+b.getGenre()+" "+b.getYear()+" "+b.getPrice());
        }
        System.out.println();

        Iterator<Book> it2 = shelf.iteratorByYear();
        while(it2.hasNext()){
            Book b2= it2.next();
            System.out.println(b2.getName()+" "+b2.getYear()+" "+b2.getGenre()+" "+b2.getPrice());
        }
        System.out.println("\n");
        //---------------------------------------
        // 확장 for문을 사용하는 방법
        for (Book book: shelf) {
            System.out.println(book.getName());
        }
        System.out.println();
    }
}
