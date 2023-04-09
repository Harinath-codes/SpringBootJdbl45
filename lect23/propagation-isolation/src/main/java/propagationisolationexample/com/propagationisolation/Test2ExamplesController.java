package propagationisolationexample.com.propagationisolation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Test2ExamplesController {
	
	@Autowired
	BookService bookService;
	
	
	//PROPAGATION LEVELS
	//Required ---> if any txn exist then it will use the same else it will create a new txn
	
	//Supports --> it will use the exiting txn if there is one ok else it will not create a new one
	
	//Requires_New --> the propagation level says that to suspend the outer txn and there exist then create a new one
	
	//Mandatory --> use an exsting txn is there is one, else throw exception
	//Never --> throw an eception if there is an active txn
	
	//NOT_supported --> suspend the current txn
	
	
	//ISOLATION LEVELS
	//READ_UNCOMMITTED = in this level we can have all three side effects --> dirty read, phatom read, non-repeatable read
	//T1 before first txn gets commited  before AND T2 can change the record amd also it can add new records
	
	//READ_COMMITTED ---> it is going to prevent dity read 
	//if two txn are happeing 
	
	
	//repeatable_read -> this say that if 2 txn are concurrent
	//till the first txn is commited the existing record canot not be changes by second txn 
	// but second txn can add new rcord
	//prevent dirty and non-repeatable read
	
	//serializable---> this will not have any of the side effects
	// txn will get excuted sequeentialy
	
	
	
	
	@GetMapping(value = "/getVal")
	@Transactional(propagation = Propagation.MANDATORY)
	public String getName() {
		
		Book book = new Book();
		book.setAuthorName("John Doe");
		book.setCost(500);
		book.setName("Rawanda Doe");
		book.setPublisherName("Arihant");
		
		bookService.saveBook(book);
		return "hi there";
	}

}
