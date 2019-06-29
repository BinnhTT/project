/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhtt;

import java.util.Comparator;

/**
 *
 * @author DELL
 */
public class Student implements Comparable<Student>{
    private String id;
    private String fullname;
    private  boolean male;
    private String major;
    private int birthyear;

    public Student() {
    }

    public Student(String id) {
        this.id = id;
    }

    public Student(String id, String fullname, boolean male, String major, int birthyear) {
        this.id = id;
        this.fullname = fullname;
        this.male = male;
        this.major = major;
        this.birthyear = birthyear;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getBirthyear() {
        return birthyear;
    }

    public void setBirthyear(int birthyear) {
        this.birthyear = birthyear;
    }

    @Override
    public String toString() {
        String str = "";
        str = this.id + "-" + this.fullname + "-" + this.major + "-" + (this.male ? "Male" : "Female") + "-" + this.birthyear;
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student){
            Student s = (Student) obj;
//            System.out.println(this.id + " - " + s.getId());
            boolean flag = s.getId().equals(this.id);
//            System.out.println(flag);
            return flag;
        }
        return false;
    }
    
    @Override
    public int compareTo(Student o) {
        return this.getFullname().compareTo(o.getFullname());
    }
    
    public static Comparator<Student> cmpById = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId().compareTo(o2.getId());
        }
    };
    
    public static Comparator<Student> cmpByName = new Comparator<Student>() {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getFullname().compareTo(o2.getFullname());
        }
    };
    
    
    
    
}
