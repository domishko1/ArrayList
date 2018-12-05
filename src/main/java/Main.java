import java.util.Scanner;

public class Main {
    public int getMenu(MyArray obj) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" 0 - exit; 1 - add new element; 2 - add element with certain index; 3 - delete element with certain index; 4 - change element with certain index");
        int choose = sc.nextInt();
        switch (choose) {
            case 1: {
                System.out.println("Enter new element: ");
                obj.addElement(sc.nextInt());
                obj.getArray();
                break;
            }
            case 2: {
                System.out.println("Enter the index of the element where you want to add the new element: ");
                int index = sc.nextInt() - 1;
                if (obj.correctnessOfIndex(index)) {
                    System.out.println("Enter the element: ");
                    obj.addElementByIndex(index, sc.nextInt());
                    obj.getArray();
                }
                break;
            }
            case 3: {
                if (obj.getSizeOfArray() != 0) {
                    System.out.println("Enter the index of the element that you want to delete: ");
                    int index = sc.nextInt() - 1;
                    if (obj.correctnessOfIndex(index)) {
                        obj.deleteElementByIndex(index);
                        obj.getArray();
                    }
                } else
                    System.out.println("Array is empty!");
                break;
            }
            case 4: {
                if (obj.getSizeOfArray() != 0) {
                    System.out.println("Enter the index of element that you want to change: ");
                    int index = sc.nextInt() - 1;
                    if (obj.correctnessOfIndex(index)) {
                        System.out.println("Enter the new element: ");
                        obj.changeElementByIndex(index, sc.nextInt());
                        obj.getArray();
                    }
                } else
                    System.out.println("Array is empty!");
            }
            break;
        }
        return choose;

    }

    public static void main(String[] args) {
        MyArray obj = new MyArray(10);
        Main menu = new Main();
        obj.setArray();
        obj.getArray();
        int choose;
        do {
            choose = menu.getMenu(obj);
        } while (choose != 0);
    }
}

