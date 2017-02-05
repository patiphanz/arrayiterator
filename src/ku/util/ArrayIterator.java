package ku.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This is a utility that you can iterate element in array 
 * without knowing type of array.
 * 
 * @author Patiphan Srisook
 *
 * @param <T> the type of elements returned by this iterator
 */
public class ArrayIterator<T> implements Iterator<T>{
	/** attribute for the array we want to iterate over */
	private T[] array;
	/** check if ArrayIterator can call remove()*/
	boolean operator;
	/** variable to remember its position in the collection*/
	private int cursor; 
	
	/**
	 * Initialize a new array iterator with the array to process.
	 * @param array is the array to iterate over
	 */
	public ArrayIterator(T[] array){
		this.array = array;
		this.operator = false;
	}
	
	/**
	 * Return the next non-null element from array, if any.
	 * @return the next non-null element in the array.
	 * @throws NoSuchElementException if there are no more elements to return.
	 */
	public T next() {
		if(hasNext()==true){
			T next = array[cursor];
			this.operator = true;
			cursor++;
			return next;
		}
		else{
			throw new NoSuchElementException();
		}
	}
	
	/**
	 * Check there is any next element in the array 
	 * @return if it has any next element in the array
	 */
	public boolean hasNext() {
		for (int a = cursor; a < array.length ; a++){
			if (array[a] != null) {
				cursor = a;
				return true;
			}
		}
		return false;
	}

	/**
	 *  Remove most recent element returned by next() 
	 *  from the array by setting it to null. 
	 *  This method may only be called once after a call to next(). 
	 *  
	 *  @throws IllegalStateException
	 *  if this method is called without calling next(). 
	 *  or called more than once after calling next().
	 */
	public void remove() {
		if (operator == true) {
			array[cursor -1] = null;
			operator = true;
		}
		else{
			throw new IllegalStateException();		
		}
	}
	
	public static void main(String args[]){
		Object [ ] array = new Object[1];
		ArrayIterator it = new ArrayIterator(array);
		System.out.println(it.hasNext());
		System.out.println(it.next());
	}
}
