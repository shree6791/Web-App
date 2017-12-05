package com.bookstore.service.impl;

import java.util.List;
import java.util.ArrayList;

import com.bookstore.domain.Book;
import com.bookstore.service.BookService;
import com.bookstore.repository.BookRepository;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll() {

		List<Book> bookList = (List<Book>) bookRepository.findAll();

		List<Book> activeBookList = new ArrayList<>();

		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}

		return activeBookList;
	}

	public Book findOne(Long id) {
		return bookRepository.findOne(id);
	}

	public Book save(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> blurrySearch(String keyword) {

		List<Book> bookList = bookRepository.findByTitleContaining(keyword);

		List<Book> activeBookList = new ArrayList<>();

		for (Book book : bookList) {
			if (book.isActive()) {
				activeBookList.add(book);
			}
		}

		return activeBookList;
	}

	public void removeOne(Long id) {
		bookRepository.delete(id);
	}
}
