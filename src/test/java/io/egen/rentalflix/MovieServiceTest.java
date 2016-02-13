package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * JUnit test cases for MovieService
 */
@SuppressWarnings("deprecation")
public class MovieServiceTest {

	private MovieService msEmpty = null;
	private MovieService mService = null;
	
	@Before
	public void initialize(){
		mService = new MovieService();
		msEmpty = new MovieService();
		
		Movie m1 = new Movie(1,"Batman",2005,"English");
		Movie m2 = new Movie(2,"Superman",1978,"English");
		Movie m3 = new Movie(3,"Spiderman",2016,"English");
		Movie m4 = new Movie(4,"Shaktiman",2016,"Hindi");
		Movie m5 = new Movie(5,"Batman v Superman",1987,"English");
		Movie m6 = new Movie(6,"Dark Knight : Batman Begins",2000,"English");
	    mService.movieStore.put(1,m1);
	    mService.movieStore.put(2,m2);
	    mService.movieStore.put(3,m3);
	    mService.movieStore.put(4,m4);
	    mService.movieStore.put(5,m5);
	    mService.movieStore.put(6,m6);
	    mService.rentMovie(2,"Aniket");
	}
	
	@Test	
	public void testFindAll(){
	
		List<Movie> result = new ArrayList<Movie>();
		
		Movie m1 = new Movie(1,"Batman",2005,"English");
		Movie m2 = new Movie(2,"Superman",1978,"English");
		Movie m3 = new Movie(3,"Spiderman",2016,"English");
		Movie m4 = new Movie(4,"Shaktiman",2016,"Hindi");
		Movie m5 = new Movie(5,"Batman v Superman",1987,"English");
		Movie m6 = new Movie(6,"Dark Knight : Batman Begins",2000,"English");
		
		result.add(m1);
		result.add(m2);
		result.add(m3);
		result.add(m4);
		result.add(m5);
		result.add(m6);
		
		Assert.assertEquals(result,mService.findAll());
	}
	
	@Test	
	public void testFindAllEmpty(){
	
		List<Movie> result = new ArrayList<Movie>();
		Assert.assertEquals(result,msEmpty.findAll());
	}
	
	@Test
	public void  testFindByName(){
		
		List<Movie> list = new ArrayList<Movie>();
		
		Movie m1 = new Movie(1,"Batman",2005,"English");
		Movie m5 = new Movie(5,"Batman v Superman",1987,"English");
		Movie m6 = new Movie(6,"Dark Knight : Batman Begins",2000,"English");
		list.add(m1);
		list.add(m5);
		list.add(m6);
		Assert.assertEquals(list,mService.findByName("batman"));
		
		list = new ArrayList<Movie>();
		Movie m3 = new Movie(4,"Shaktiman",2016,"Hindi");
		list.add(m3);
		Assert.assertEquals(list,mService.findByName("Shaktiman"));
			
		list = new ArrayList<Movie>();
		Assert.assertEquals(list,mService.findByName("Transporter"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateExceptionExactMovie() {	
		Movie m1 = new Movie(1,"Batman",2005,"English");
		mService.create(m1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateExceptionSameId() {	
		Movie m1 = new Movie(1,"Catman",2005,"English");
		mService.create(m1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCreateExceptionSameMovie() {	
		Movie m1 = new Movie(7,"Batman",2005,"English");
		mService.create(m1);
	}
		
	@Test
	public void testCreate(){
		Movie m3 = new Movie(9,"Kung Fu Panda",2020,"English");
		Assert.assertEquals(m3,mService.create(m3));
	}
	
	@Test
	public void testUpdate(){
		Movie m1 = new Movie(1,"Terminator",2000,"English");
		Assert.assertEquals(m1,mService.update(m1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testUpdateExceptionNoMovie() {	
		Movie m1 = new Movie(9,"Batman",2005,"English");
		mService.update(m1);
	}
	
	@Test
	public void testDelete(){
		Movie m1 = new Movie(1,"Batman",2005,"English");
		Assert.assertEquals(m1,mService.delete(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeleteExceptionNoMovie() {	
		mService.delete(9);
	}
	
	@Test
	public void testRentMovie (){
		Assert.assertEquals(true,mService.rentMovie(1,"Aniket"));
		Assert.assertEquals(false,mService.rentMovie(31,"Aniket"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRentExceptionOut() {	
		mService.rentMovie(2,"Aniket");
	}
}
