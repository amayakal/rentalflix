package io.egen.rentalflix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Service implementing IFlix interface
 * You can use any Java collection type to store movies
 */
public class MovieService implements IFlix {
	
	Map<Integer, Movie> movieStore = new ConcurrentHashMap<Integer,Movie>();
	Map<Integer, String> movieRented = new ConcurrentHashMap<Integer,String>();
	
	@Override
	public List<Movie> findAll() {
		// TODO Auto-generated method stub
		List<Movie> result = new ArrayList<Movie>(movieStore.values());
		return result;
	}

	@Override
	public List<Movie> findByName(String name) {
		// TODO Auto-generated method stub
		List<Movie> result = new ArrayList<Movie>();
		for(Movie m:movieStore.values()){
			if(m.getTitle().toLowerCase().indexOf(name.toLowerCase()) != -1)
				result.add(m);
		}
		return result;
	}

	@Override
	public Movie create(Movie movie){
		// TODO Auto-generated method stub
		Movie m = (Movie)movieStore.get(movie.getId());
		if(m != null){
			if(m.getTitle().equalsIgnoreCase(movie.getTitle()))
				throw new IllegalArgumentException("Movie already exists");
			else
				throw new IllegalArgumentException("Movie Id already exists with different movie");
		}
		else if(movieStore.containsValue(movie))
			throw new IllegalArgumentException("Movie already exists with different Id");
		else{
			movieStore.put(movie.getId(),movie);
			return movie;
		}
	}

	@Override
	public Movie update(Movie movie) {
		// TODO Auto-generated method stub
		Movie m = (Movie)movieStore.get(movie.getId());
		if(m != null){
			movieStore.put(m.getId(),movie);
			return movie;
		}
		else
			throw new IllegalArgumentException("Movie Id not found");
	}

	@Override
	public Movie delete(int id) {
		// TODO Auto-generated method stub
		Movie m = (Movie)movieStore.get(id);
		if(m != null){
			movieStore.remove(id);
			return m;
		}
		else
			throw new IllegalArgumentException("Movie Id not found");
	}

	@Override
	public boolean rentMovie(int movieId, String user) {
		// TODO Auto-generated method stub
		if(movieStore.get(movieId) != null){
			if(movieRented.get(movieId) == null){
				movieRented.put(movieId, user);
				return true;
			}
			else
				throw new IllegalArgumentException("Movie Already rented");
				
		}
		else
			return false;
	}

}
