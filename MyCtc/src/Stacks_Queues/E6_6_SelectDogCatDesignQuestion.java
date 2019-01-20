package Stacks_Queues;
import java.util.*;
/*
 * 3.7
An animal shelter holds only dogs and cats, and operates on a strictly "first in, first
out" basis. People must adopt either the "oldest" (based on arrival time) of all animals
at the shelter, or they can select whether they would prefer a dog or a cat (and will
receive the oldest animal of that type). They cannot select which specific animal they
would like. Create the data structures to maintain this system and implement opera-
tions such as enqueue, dequeueAny, dequeueDog and dequeueCat. You may
use the built-in L inkedL ist data structure.

Solution:
Here we have taken 2 linklist one for dog and the other for cat every animal has an associated id with it when 
we enqueue we increment the id and during dequeue we pop the older animal out of the 2 link list comparing their id
 */
class Animal{
	private int id;
	private String name;
	public Animal(String name){
		this.name = name;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getName(){
		return this.name;
	}
	
	public boolean isOlder(Animal a){
		return (this.id < a.id);
	}
}

class Dog extends Animal{
	public Dog(String name){
		super(name);
	}
}

class Cat extends Animal{
	public Cat(String name){
		super(name);
	}
}

public class E6_6_SelectDogCatDesignQuestion<T> {
	private int id;
	LinkedList<Dog> dogList = new LinkedList<Dog>();
	LinkedList<Cat> catList = new LinkedList<Cat>();
	
	private void enQueue(Animal a){
		id++;
		a.setId(id);
		if(a instanceof Dog) dogList.addLast((Dog)a);
		else catList.addLast((Cat)a);
	}
	
	private  Animal deQueueAny(){
		if(dogList.size() == 0) return deQueueCat();
		else if(catList.size() == 0) return deQueueCat();
		if((dogList.peek()).isOlder(catList.peek())) return deQueueDog();
		else return deQueueCat();
	}
	
	private Animal deQueueDog(){
		return dogList.poll();
	}
	
	private Animal deQueueCat(){
		return catList.poll();
	}
	
	public static void main(String[] args) {
		E6_6_SelectDogCatDesignQuestion obj = new E6_6_SelectDogCatDesignQuestion();
		obj.enQueue(new Dog("tommy"));
		obj.enQueue(new Cat("billi"));
		obj.enQueue(new Dog("kutta"));
		obj.enQueue(new Cat("meow"));
		Animal a1 = obj.deQueueAny();
		System.out.println(a1.getName());
		Animal a2 = obj.deQueueDog();
		System.out.println(a2.getName());
		Animal a3 = obj.deQueueCat();
		System.out.println(a3.getName());
	}
}
