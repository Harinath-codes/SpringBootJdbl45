package com.example.jbdl.minorproject1;

import java.util.ArrayList;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.jbdl.minorproject1.models.Book;
import com.example.jbdl.minorproject1.models.Genre;
import com.example.jbdl.minorproject1.models.Student;
import com.example.jbdl.minorproject1.repositories.TransactionRepository;
import com.example.jbdl.minorproject1.services.BookService;
import com.example.jbdl.minorproject1.services.StudentService;
import com.example.jbdl.minorproject1.services.TransactionService;

@RunWith(MockitoJUnitRunner.class)
public class MinorProject1ApplicationTests {

	private static final int studentId = 1;
	private static final int bookId = 10;

	// @InjectMocks// create a real object of transaction service and inject all
	// the dependent mocks
	@Mock // Create a mock object but kind of dummy one, and other dependent
			// mock object will not be injected
	TransactionService transactionService;

	@Mock
	StudentService studentService;

	@Mock
	BookService bookService;

	@Mock
	TransactionRepository transactionRepository;

	@Test
	public void testIssueBook() throws Exception {
		Student student = Student.builder().studentId(studentId).name("ABC").age(20).bookList(new ArrayList<>())
				.build();
		Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(null);
		Mockito.when(studentService.getStudentById(studentId)).thenReturn(student);
		transactionService.issueBook(studentId, bookId);
		Mockito.verify(transactionRepository, Mockito.times(2)).save(Mockito.any());
		System.out.print("Inside context load method Test cases");

	}

	@Test
	public void testIssueBook1() throws Exception {

		Student student = Student.builder().studentId(studentId).name("ABC").age(20).bookList(new ArrayList<>())
				.build();


		Mockito.when(transactionRepository.save(Mockito.any())).thenReturn(null);
		Mockito.when(studentService.getStudentById(studentId)).thenReturn(student);

		System.out.print("Inside context load method Test cases");

	}

}
