package practice.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BookShelfIterator implements Iterator<Book> { //Iterator <- 이건 uti.Iterator 에서 가져온것. 제너릭이라 book 원소 넣기
    private BookShelf bookShelf; //bookshelf를 속성으로 가져야 책꽂이 돌아다님 oo
    private int index; //현 위치

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;//bookshelf에서 가져온거 속성으로 넣기
        this.index = 0;
    }

    @Override
    public boolean hasNext() { //hasnext : 꺼내올 다음 책 있는지 확인 메소드
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();//꺼내올거 x 면 예외 던짐 util에 있는 nosuch어쩌고 호출
        }
        Book book = bookShelf.getBookAt(index);//return 꺼낸 책 
        index++;
        return book;
    }
}
