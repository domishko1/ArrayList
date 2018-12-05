import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayTest {


    @Test
    public void addElement() {
        MyArray arr = new MyArray(0);

        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);
    }

    @Test
    public void addElementByIndex() {
        MyArray arr = new MyArray(0);

        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(4);

        arr.addElementByIndex(2, 3);

        assertEquals(1, arr.getArrayByIndex(0));
        assertEquals(2, arr.getArrayByIndex(1));
        assertEquals(3, arr.getArrayByIndex(2));
        assertEquals(4, arr.getArrayByIndex(3));
    }

    @Test
    public void changeElementByIndex() {
        MyArray arr = new MyArray(0);

        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        arr.changeElementByIndex(2, 4);

        assertEquals(1, arr.getArrayByIndex(0));
        assertEquals(2, arr.getArrayByIndex(1));
        assertEquals(4, arr.getArrayByIndex(2));
    }

    @Test
    public void deleteElementByIndex() {
        MyArray arr = new MyArray(0);

        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        arr.deleteElementByIndex(1);

        assertEquals(1, arr.getArrayByIndex(0));
        assertEquals(3, arr.getArrayByIndex(1));
    }

    @Test
    public void getArrayByIndex() {
        MyArray arr = new MyArray(0);

        arr.addElement(1);
        arr.addElement(2);
        arr.addElement(3);

        assertEquals(2, arr.getArrayByIndex(1));
    }
}