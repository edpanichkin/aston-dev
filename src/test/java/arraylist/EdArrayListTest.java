package arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdArrayListTest {
  public EdArrayList<String> arrayList = new EdArrayList<>();

  {
    arrayList.add("Element0");
    arrayList.add("Element1");
    arrayList.add("Element2");
    arrayList.add("Element3");
  }


  @Test
  void getSize() {
    Assertions.assertEquals(4, arrayList.size());
    arrayList.add("ElementToRemove");
    Assertions.assertEquals(5, arrayList.size());
    arrayList.remove(5);
    Assertions.assertEquals(4, arrayList.size());
    //arrayList.printCollection();
  }

  @Test
  void add() {
    arrayList.add("Element4");
    Assertions.assertEquals("Element4", arrayList.get(4));
  }

  @Test
  void testAdd() {
    arrayList.add(4, "Element3-4");
    Assertions.assertEquals("Element3-4", arrayList.get(4));
    Assertions.assertEquals(5, arrayList.size());
  }

  @Test
  void get() {
    Assertions.assertEquals("Element1", arrayList.get(1));
  }

  @Test
  void remove() {
    arrayList.remove("Element10");
  }

  @Test
  void addAll() {

    EdArrayList<String> arrayList2 = new EdArrayList<>();
    for (int i = 0; i < 100; i++) {
      arrayList2.add("Element_" + i);
    }
    arrayList.addAll(arrayList2);
    Assertions.assertEquals(104, arrayList.size());

  }
}