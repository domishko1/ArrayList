import java.security.InvalidParameterException;
import java.util.Random;

public class MyArray {
    int[] array;
    int sizeOfArray;


    /**
     * Конструктор. Выделяет память под _sizeOfArray элементов.
     *
     * @param _sizeOfArray
     */
    public MyArray(int _sizeOfArray) {
        sizeOfArray = _sizeOfArray;
        array = new int[sizeOfArray];
    }

    /**
     * Выделение памяти под newSize элементов.
     *
     * @param newSize
     */
    public void resize(int newSize) {
        sizeOfArray = newSize;
        array = new int[newSize];
    }

    /**
     * Заполнение массива случайными числами от 0 до 9.
     */
    public void setArray() {
        Random random = new Random();
        for (int index = 0; index < sizeOfArray; index++) {
            array[index] = random.nextInt(10);
        }
    }

    /**
     * Вывод массива.
     */
    public void getArray() {
        System.out.println("Array information: ");
        for (int index = 0; index < sizeOfArray; index++) {
            System.out.println(array[index]);
        }
    }

    public int getArrayByIndex(int index_) throws InvalidParameterException {
        if (correctnessOfIndex(index_))
            return array[index_];
        else
            throw new InvalidParameterException("Index is not right!");
    }

    /**
     * В массив temporaryArray копируем элементы массива array. Выделяем память на единицу больше для array.
     * Копируем из temporaryArray в array. А на последнее место вставляем новый элемент.
     *
     * @param element
     */
    public void addElement(int element) {
        int[] temporaryArray = new int[++sizeOfArray];
        System.arraycopy(array, 0, temporaryArray, 0, sizeOfArray - 1);
        resize(sizeOfArray);
        array = temporaryArray;
        array[sizeOfArray - 1] = element;
    }

    /**
     * Формирует новый массив temporaryArray размерностью больше на единицу. Копирует значения массива array,
     * вставляя новое значение на нужное место. Перевыделяет память для массива array. Копирует все из temporaryArray в array.
     *
     * @param index
     * @param element
     */
    public void addElementByIndex(int index, int element) {
        sizeOfArray++;
        int[] temporaryArray = new int[sizeOfArray];
        for (int ind = 0, temp = 0; ind < sizeOfArray - 1; ind++, temp++) {
            if (ind == index) {
                temporaryArray[temp++] = element;
                temporaryArray[temp] = array[ind];
            } else {
                temporaryArray[temp] = array[ind];
            }
        }
        resize(sizeOfArray);
        System.arraycopy(temporaryArray, 0, array, 0, sizeOfArray);
    }

    /**
     * Заменяем старый элемент на новый по индексу.
     *
     * @param index
     * @param newElement
     */
    public void changeElementByIndex(int index, int newElement) {
        array[index] = newElement;
    }

    /**
     * Проверяет на корректность ввода индекса. Если индекс от 0 до sizeOfArray, то ввод индекса корректен.
     *
     * @param index
     * @return
     */
    public boolean correctnessOfIndex(int index) {
        if (index < 0 || index >= sizeOfArray) {
            System.out.println("Error! Index is not right!");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Начиная с позиции index, элементы смещаются в лево. Размерность массива уменьшается на 1.
     *
     * @param index
     */
    public void deleteElementByIndex(int index) {
        for (int ind = index; ind < sizeOfArray - 1; ind++) {
            array[ind] = array[ind + 1];
        }
        sizeOfArray--;
    }

    /**
     * Возвращает размер массива
     * @return
     */
    public int getSizeOfArray(){
        return sizeOfArray;
    }
}
