package com.exercici.books;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exercici.books.model.Book;
import com.exercici.books.model.Category;
import com.exercici.books.repository.IBookRepository;

@SpringBootApplication
public class BooksApplication {
	
	@Autowired
	private IBookRepository bookRepository;
		
	@PostConstruct
    public void initBooks() {
        List<Book> books = Stream.of(
                new Book("Da Vinci Code,The", 					      "Brown, Dan", "...",                    		  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Deathly Hallows",      "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Philosopher's Stone",  "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Order of the Phoenix", "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Fifty Shades of Grey",                      "James, E. L.", "...",  						  Category.BESTSELLER,	   12, 10, false),
                new Book("Harry Potter and the Goblet of Fire",       "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Chamber of Secrets",   "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Prisoner of Azkaban",  "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Angels and Demons",                         "Brown, Dan", "...",    						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Harry Potter and the Half-blood Prince",    "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Fifty Shades Darker",                       "Rowling, J.K.", "...", 						  Category.BESTSELLER, 	   12, 10, false),
                new Book("Captain America",                           "‎Jack Kirby, ‎Joe Simon‎ ", "...",                Category.COMIC, 		   12, 10, false),
                new Book("Wolverine",                            	  "Roy Thomas, Len Wein, John Romita Sr.", "...", Category.COMIC, 		   12, 10, false),
                new Book("Amazing Spider-Man",                   	  "Stan Lee, Kaare Andrews, Steve Ditko", "...",  Category.COMIC, 		   12, 10, false),
                new Book("Secret Wars",                          	  "Stan Lee", "...",                              Category.COMIC, 		   12, 10, false),
                new Book("The Uncanny X-Men's: Dawn of Mutants", 	  "Stan Lee, Jack Kirby", "...",                  Category.COMIC, 		   12, 10, false),
                new Book("The Kree-Skrull War",                  	  "Roy Thomas", "...",                            Category.COMIC, 		   12, 10, false),
                new Book("Incredible Hulk",                      	  "Stan Lee, Jack Kirby", "...",                  Category.COMIC, 		   12, 10, false),
                new Book("Avengers",                             	  "Stan Lee, Jack Kirby", "...",                  Category.COMIC, 		   12, 10, false),
                new Book("Fantastic Four",                       	  "Stan Lee, Jack Kirby", "...",                  Category.COMIC, 		   12, 10, false),
                new Book("Amazing Spider-Man (1963)",            	  "Stan Lee, Steve Ditko", "...",                 Category.COMIC, 		   12, 10, false),
                new Book("Iron Man: Armor Wars (1987)",          	  "David Michelinie and Bob Layton", "...",       Category.COMIC,          12, 10, false),
                new Book("Days of Future Past",                  	  "Chris Claremont, John Byrne", "...",           Category.COMIC,          12, 10, false),
                new Book("La casa de los espíritus", 				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Largo pétalo de mar",      				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Paula",                    				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Eva Luna",                 				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Hija de la fortuna",       				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("El amante japonés",        				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("La ciudad de las bestias", 				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("De amor y de sombra",      				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Más allá del invierno",    				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("La isla bajo el mar",      				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Retrato en sepia",         				  "Isabel Allende", "...", 						  Category.OV, 			   12, 10, false),
                new Book("Where the wild things are",      			  "Maurice Sendak", "...", 						  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("The snowy day",      						  "Erza Jack Keats", "...", 					  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Goodnight moon",      					  "Margaret Wise Brown", "...", 				  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Blueberries for sal",      				  "Robert McCloskey", "...", 					  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Little bear",      						  "Else Holmelund Minarek", "...", 				  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Owl moon",      							  "Jane Yolen", "...", 							  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("The giving tree",      					  "Shel Silverstein", "...", 					  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("The true story of the three little pigs",   "Jon Scieszka", "...", 						  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Tuesday",      							  "David Wiesner", "...", 						  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Where the sidewalk ends",      			  "Shel Silverstein", "...", 					  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Harold and the purple crayon",      		  "Crockett Johnson", "...", 					  Category.CHILDRENSSTORY, 12, 10, false),
                new Book("Make way for ducklings",      			  "Robert McCloskey", "...", 					  Category.CHILDRENSSTORY, 12, 10, false)
       ).collect(Collectors.toList());
        bookRepository.saveAll(books);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

}
