/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binhtt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author DELL
 */
public class StudentList {

    private ArrayList<Student> list = new ArrayList<>();
    private final String FNAME = "data.txt";

    public StudentList() {
        readFile();
    }
    
    

    public Student findByID(String id) {
        Student s = null;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            if (id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }

    public void add(Student s) {
        list.add(s);
        writeFile();
    }

    public boolean remove(String id) {
//        Student s = this.findByID(id);
//        if(s == null){
//            return false;
//        } else {
//            int index = list.indexOf(s);
//            list.remove(index);
//            return true;
//        }
        Student s = new Student(id);
        int index = list.indexOf(s);
        if (index >= 0) {
            list.remove(index);
            writeFile();
            return true;
        }
        return false;
    }

    public void update(Student s) {
        list.set(list.indexOf(s), s);
        writeFile();
    }

    public ArrayList<Student> findByLikeName(String search) {
        ArrayList<Student> result = new ArrayList<>();
        Student s;
        for (int i = 0; i < list.size(); i++) {
            s = list.get(i);
            if (s.getFullname().toLowerCase().contains(search.toLowerCase())) {
                result.add(s);
            }
        }
        //Collections.sort(result);
        result.sort(Student.cmpByName);
        return result;
    }

    private void readFile() {
        FileReader fr = null;
        BufferedReader br = null;
        Student s;
        try {
            fr = new FileReader(FNAME);
            br = new BufferedReader(fr);
            String id, fullname, major;
            Boolean male;
            int birthyear;

            String line = "";

            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    String[] subStr = line.split("-");

                    id = subStr[0].trim();
                    fullname = subStr[1].trim();
                    major = subStr[2].trim();
                    male = subStr[3].trim().equalsIgnoreCase("male");
                    birthyear = Integer.parseInt(subStr[4].trim());
                    s = new Student(id, fullname, true, major, birthyear);
                    list.add(s);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if(fr  != null) fr.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    private void writeFile(){
        File f = null;
        PrintWriter pw = null;
        try {
            f = new File(FNAME);
            pw = new PrintWriter(f);
            list.sort(Student.cmpById);
            for (Student student : list) {
                pw.println(student.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(pw != null) pw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
