package hw.ch01;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays; 

public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }
    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
}
//----------------------------------------------------
class iteratorByGenre implements Iterator<Book>{
    private String genre; 
    private BookShelf bookShelf;
    private int index; 
    public iteratorByGenre(BookShelf bookShelf, String genre)
    {
        this.bookShelf = bookShelf; 
        this.genre = genre; 
        index = 0; 
    }
    @Override
    public boolean hasNext() {
       while(index < bookShelf.getLength())
      { 
        Book book = bookShelf.getBookAt(index);
        if(book.getGenre().equals(genre)){
            return true; 
        }
        index ++;
      }
        return false; 
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Book book = bookShelf.getBookAt(index);
        index++;
        return book;
    }
    }

//-----------------------------------------------
class iteratorByYear implements Iterator<Book>{
    private Book[] sortShelf; 
    private int index; 
    private int size; 
    
    public iteratorByYear(BookShelf bookShelf)
    {
        sortShelf = new Book[bookShelf.getLength()];
        index = 0;
        size = bookShelf.getLength();
        for(int i = 0; i <size; i++)
        {
            sortShelf[i] = bookShelf.getBookAt(i);
        }
        Arrays.sort(sortShelf, (a, b) -> b.getYear() - a.getYear());
    }

    @Override
    public boolean hasNext() {
        if (index < size) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return sortShelf[index++];
    }
    }
