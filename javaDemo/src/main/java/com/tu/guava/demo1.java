package com.tu.guava;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tuyongjian on 2018/9/18.
 */
public class demo1 {

    public static void main(String[] args) {

        Multiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("d");
        multiset.add("d");
        System.out.println(multiset.size());
        System.out.println(multiset.contains("a"));
        System.out.println(multiset.count("d"));

        demo1 d1 = new demo1();
        d1.testStudent();

    }

    private static final String CLASS_NAME_1="一年级";
    private static final String CLASS_NAME_2="二年级";
    Map<String,List<Student>> StudentsMap = new HashMap<String, List<Student>>();
    Multimap<String, Student> multimap = ArrayListMultimap.create();

    public void testStudent() {
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.name = "Tom" + i;
            student.age = 6;
            //addStudent(CLASS_NAME_1, student);
            multimap.put(CLASS_NAME_1,student);
        }
        for (int i = 0; i < 5; i++) {
            Student student = new Student();
            student.name = "Jary" + i;
            student.age = 7;
            //addStudent(CLASS_NAME_2, student);
            multimap.put(CLASS_NAME_2,student);
        }
     /*   List<Student> class1StudentList = StudentsMap.get(CLASS_NAME_1);

        for (Student stu : class1StudentList) {
            System.out.println("一年级学生 name:" + stu.name + " age:" + stu.age);
        }*/

        for (Student stu : multimap.get(CLASS_NAME_1)) {
            System.out.println("一年级学生 name:" + stu.name + " age:" + stu.age);
        }

        //判断键是否存在
        if(multimap.containsKey(CLASS_NAME_1)){
            System.out.println("键值包含："+CLASS_NAME_1);
        }
        //”键-单个值映射”的个数
        System.out.println(multimap.size());
        //不同键的个数
        System.out.print(multimap.keySet().size());
    }

    public void addStudent(String className, Student student) {
        List<Student> students = StudentsMap.get(className);
        if (students == null) {
            students = new ArrayList<Student>();
            StudentsMap.put(className, students);
        }
        students.add(student);
    }



}

class Student{
    String name;
    int age;
}


