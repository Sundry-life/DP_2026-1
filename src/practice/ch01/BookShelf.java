package practice.ch01;

import java.util.Iterator;

public class BookShelf implements Iterable<Book> {
//public class BookShelf{
    private Book[] books; //배열 선언
    private int last = 0; //책의 마지막 위치 현재 책 없으니 0

    public BookShelf(int maxsize) {
        this.books = new Book[maxsize]; //배열 생성
    }

    public Book getBookAt(int index) { //책 가져오는 메소드
        return books[index];
    }

    public void appendBook(Book book) { //책 넣는 메소드
        this.books[last] = book;
        last++;
    }

    public int getLength() {//책 갯수
        return last;
    }

    @Override
    public Iterator<Book> iterator() { //자기 자신(현 책꽂이)의 iterator를 생성해서 반환
        return new BookShelfIterator(this);//this : 현 책꽂이
    }
}
