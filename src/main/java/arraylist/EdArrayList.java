package arraylist;

public class EdArrayList<E> {
  private final static int DEFAULT_CAPACITY = 10;

  private int size = 0;
  private int capacity;
  private E[] elementData;

  public int size() {
    return size;
  }

  public EdArrayList(int capacity) {
    this.capacity = capacity;
    this.elementData = (E[]) new Object[capacity];

  }

  public EdArrayList() {
    this.elementData = (E[]) new Object[DEFAULT_CAPACITY];
    this.capacity = DEFAULT_CAPACITY;
  }

  private void ensureCapacity() {
    System.out.println(size);
    if (size + 1 > capacity) {
      doChangeCapacity(1);
    }
  }

  public void add(E element) {
    ensureCapacity();
    elementData[size++] = element;
  }

  public void add(int index, E element) {
    ensureCapacity();
    System.arraycopy(elementData, index, elementData, index + 1, size - index);
    elementData[index] = element;
    size++;
  }

  public E get(int index) {
    return elementData[index];
  }

  public void remove(int index) {
    int numMoved = size - index;
    System.arraycopy(elementData, index + 1, elementData, index, numMoved);
    elementData[--size] = null;
    trimToSize();
  }

  public boolean remove(E obj) {
    int index = 0;
    for (int i = 0; i < size; i++) {
      if (elementData[i].equals(obj)) {
        index = i;
        int numMoved = size - index;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        trimToSize();
        return true;
      }
    }
    return false;
  }

  private void doChangeCapacity(int vector) {
    E[] oldData = elementData;
    capacity = vector > 0 ? (capacity * 3) / 2 + 1 : capacity / 2;
    elementData = (E[]) new Object[capacity];
    System.arraycopy(oldData, 0, elementData, 0, size);

  }

  private void trimToSize() {
    if (capacity - size > capacity / 2 && capacity > DEFAULT_CAPACITY) {
      doChangeCapacity(-1);
    }
  }

  public void printCollection() {
    for (int i = 0; i < size; i++) {
      System.out.println(elementData[i].toString());
    }
  }

  public void addAll(EdArrayList<E> collection) {
    for (int i = 0; i < collection.size; i++) {
      add(collection.get(i));
    }
  }
}
