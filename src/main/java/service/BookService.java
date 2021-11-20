package service;

import Model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IBookRepository;

import java.time.LocalDateTime;
import java.util.List;

public class BookService implements IBookService  {
    private IBookRepository bookRepository;

    public BookService (IBookService bookService)
    {
        this.bookRepository = bookRepository;

    }

    public Book saveBook(Model.Book book)
    {
        book.setCreateTime(LocalDateTime.now());
        return bookRepository.save(book);
    }

    public void deleteBook(Long id)
    {
        bookRepository.deleteById(id);
    }

    public List<Book> FindAllBooks()
    {
        return  bookRepository.findAll();
    }

}
