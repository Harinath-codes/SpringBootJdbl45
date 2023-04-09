package propagationisolationexample.com.propagationisolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BookService {
	
	@Autowired
	BookRepo bookRepo;
	
	//@Transactional(propagation = Propagation.MANDATORY)
	public void saveBook(Book book) {
		bookRepo.save(book);
	}

}
