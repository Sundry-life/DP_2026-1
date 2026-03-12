package practice.ch01;
import java.util.Iterator; 
public class Main{
    public static void main (String[] args)
    {
        Book book = new Book("Java programming");
        System.out.println("Book name: "+book.getName());

        BookShelf bookShelf = new BookShelf(5);
        bookShelf.appendBook(new Book("Java Programming"));
        bookShelf.appendBook(new Book("Design Pattern"));
        bookShelf.appendBook(new Book("Effective Java"));
        
        //방법 1 클라이언트가 직접 접근
        for(int i = 0 ; i < bookShelf.getLength(); i++)
        {
            System.out.println ("1)Book"+(i+1)+": "+bookShelf.getBookAt(i).getName());
        }
        //방법 2 iterator 이용
        //2-1 iterator 얻어오기 
        Iterator<Book> it = bookShelf.iterator();
        while(it.hasNext()){
            System.out.println("2-1)Book: "+it.next().getName());
        }
        //2-2  확장 for문
        //bookShelf가 iterable interface를 구현해서 가능
        for(Book b: bookShelf){
            System.out.println("2-2)Book:"+ b.getName());
        }
        
    }
}