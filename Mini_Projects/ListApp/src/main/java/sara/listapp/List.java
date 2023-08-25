package sara.listapp;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author saraqin
 */
public class List {

    int length;
    int nextSpace = 0;
    String[] arr = new String[length];

    public List(int length) {
        this.length = length;
    }

    public int increaseLength()//increase 5
    {
        length = length + 5;
        return length;
    }

    public int getNextSpace() {
        return nextSpace;
    }

    public String getElement(int n) {
        return arr[n];
    }

    public void renewList() {
        if (nextSpace >= arr.length) {
            length = increaseLength();
            String[] arrTemperary = new String[length];
            for (int i = 0; i < arr.length; i++) {
                arrTemperary[i] = arr[i];
            }
            arr = arrTemperary;
        }
    }

    public void add(String string) {
        renewList();

        arr[nextSpace] = string;
        nextSpace++;
    }

    public void add(int index, String string) {
        renewList();
        String temp;
        for (int i = index; i < arr.length; i++) {
            temp = arr[i];
            arr[i] = string;
            string = temp;
        }
        nextSpace++;
    }

    public void remove(int index) {
        if (index == arr.length - 1) {
            arr[index] = null;
        } else {
            if (index < arr.length - 1) {

                for (int i = index + 1; i < arr.length; i++) {
                    arr[index] = arr[i];
                    index++;
                }
                arr[arr.length - 1] = null;
            }
        }
    }

    public void remove(String string) {
        int index = -1;

        for (int i = 0; i < arr.length; i++)//find the element
        {
            if (string.equals(arr[i])) {
                arr[i] = null;
                index = i;
                break;
            }
        }

        if (index >= 0) {
            remove(index);
        }
    }

    public String toString() {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.print(arr[i] + " ");
            }

        }
        return "";
    }

    public int size() {
        int size = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                size++;
            }

        }
        return size;
    }

}
