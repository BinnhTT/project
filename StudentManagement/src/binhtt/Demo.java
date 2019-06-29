/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhtt;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Demo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentList list = new StudentList();
        int choice = 0, choice2 = 0;
        do {
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Search by Name");
            System.out.println("4. Update");
            System.out.println("5. Exit");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1: {
                    boolean flag = false;
                    String id;
                    do {
                        System.out.println("ID: ");
                        id = sc.nextLine();
                        Student s = list.findByID(id);
                        if (s == null) {
                            flag = true;
                        } else {
                            System.out.println("ID is available");
                            flag = false;
                        }
                    } while (!flag);
                    System.out.println("Fullname: ");
                    String fullname = sc.nextLine();
                    System.out.println("Major: ");
                    String major = sc.nextLine();
                    System.out.println("Sex: ");
                    boolean male = Boolean.parseBoolean(sc.nextLine());
                    System.out.println("Birthyear: ");
                    int birthyear = Integer.parseInt(sc.nextLine());
                    Student s = new Student(id, fullname, male, major, birthyear);
                    list.add(s);
                    break;
                }
                case 2: {
                    System.out.println("Please input student id : ");
                    String id = sc.nextLine();
                    Student s = list.findByID(id);
                    if (s == null) {
                        System.out.println("ID is not available");
                    } else {
                        list.remove(id);
                        System.out.println("Student information is removed");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Input information:");
                    String search = sc.nextLine();
                    ArrayList<Student> result = list.findByLikeName(search);
                    if (result.isEmpty()) {
                        System.out.println("Not found");
                    } else {
                        for (Student student : result) {
                            System.out.println(student.toString());
                        }
                    }
                    break;
                }
                case 4: {
                    do {
                        System.out.println("Input ID: ");
                        String id = sc.nextLine();
                        Student s = list.findByID(id);
                        if (s == null) {
                            System.out.println("Dont found!");
                        } else {
                            System.out.println("1.Fullname: ");
                            System.out.println("2. Major");
                            System.out.println("3.Gender");
                            System.out.println("4. Birthyear: ");
                            choice2 = Integer.parseInt(sc.nextLine());
                            switch (choice2) {
                                case 1:{
                                    System.out.println("New fullname: ");
                                    String fullname = sc.nextLine();
                                    s.setFullname(fullname);
                                    break;
                                }
                                case 2:
                                    {
                                    System.out.println("New major: ");
                                    String major = sc.nextLine();
                                    s.setMajor(major);
                                    break;
                                }
                                case 3:
                                    {
                                    System.out.println("New gender: ");
                                    Boolean male = Boolean.parseBoolean(sc.nextLine());
                                    s.setMale(male);
                                    break;
                                }
                                case 4:
                                    {
                                    System.out.println("New birthyear: ");
                                    int birthyear = Integer.parseInt(sc.nextLine());
                                    s.setBirthyear(birthyear);
                                    break;
                                }
                            }
                            list.update(s);
                        }
                        
                    } while (choice2 < 1 || choice2 > 4);
                    
                    break;
                }
            }
        } while (choice >= 1 && choice <= 4);
    }
}
