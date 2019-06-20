package cracking_coding_interview.Stacks;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;
import java.util.Queue;

public class _3_6_animalShelter<Cat, Dog> {
  private Queue<Cat> cats;
  private Queue<Dog> dogs;
  private Queue<Object> both;

  private int sizeCats;
  private int sizeDogs;

  public _3_6_animalShelter() {
    cats = new ArrayDeque<>();
    dogs = new ArrayDeque<>();
    both = new ArrayDeque<>();
    sizeCats = 0;
    sizeDogs = 0;
  }

  public void addDog(Dog dog) {
    dogs.add(dog);
    sizeDogs++;
  }

  public void addCat(Cat cat) {
    cats.add(cat);
    sizeCats++;
  }

  public Dog dequeueDog() {
    if (sizeDogs == 0) throw new NoSuchElementException();
    Dog dog = dogs.poll();
    both.remove(dog);
    sizeDogs--;
    return dog;
  }

  public Cat dequeueCat() {
    if (sizeCats == 0) throw new NoSuchElementException();
    Cat cat = cats.poll();
    both.remove(cat);
    sizeCats--;
    return cat;
  }

  @SuppressWarnings("unchecked")
  public Object dequeueAny() {
    if (sizeCats + sizeDogs == 0) throw new NoSuchElementException();
    Object object = both.poll();
    try {
      Cat cat = (Cat) object;
      sizeCats--;
      cats.remove(cat);
      return object;
    } catch (ClassCastException e) {
      Dog dog = (Dog) object;
      sizeDogs--;
      dogs.remove(dog);
      return object;
    }
  }
}
