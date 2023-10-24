/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChon;

    protected Scanner scanner = new Scanner(System.in);

    public Menu() {
    }

    public Menu(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) {
            mChon.add((T) s);
        }
    }

    public void display() {
        System.out.println(title);
        System.out.println("---------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + ". " + mChon.get(i));
        }
        System.out.println("---------------------------------");
    }

  
    public String getSelected() {
        display();
        System.out.print("Enter selection: ");
        return scanner.nextLine();
    }

    public void run() {
        while (true) {
            String n = getSelected();
            execute(n);
            try {
                if (Integer.parseInt(n) >= mChon.size()) {
                    break;
                }
            } catch (NumberFormatException e) {
                run();
            }

        }
    }

    public abstract void execute(String n);

}
