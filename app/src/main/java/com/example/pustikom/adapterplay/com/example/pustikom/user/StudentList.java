package com.example.pustikom.adapterplay.com.example.pustikom.user;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by pustikom on 04/11/16.
 */

public class StudentList implements List<Student> {
    private ArrayList<Student> studentList;
    public StudentList(){
        studentList=new ArrayList<>();
    }

    @Override
    public int size() {
        return studentList.size();
    }

    @Override
    public boolean contains(Object o) {
        //loop through all of the content to check if the o
        return studentList.contains(o);
    }

    @NonNull
    @Override
    public Iterator<Student> iterator() {
        return studentList.iterator();
    }

    @NonNull
    @Override
    public Object[] toArray() {
        return studentList.toArray();
    }

    @NonNull
    @Override
    public <T> T[] toArray(T[] a) {
        return studentList.toArray(a);
    }

    @Override
    public boolean remove(Object o) {
        return studentList.remove(o);
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return studentList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Student> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Student> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    /**
     * Todo: if current list is empty return true, false otherwise DONE
     * @return
     */
    @Override
    public boolean isEmpty() {
        if(studentList.size() == 0){
            return true;
        }
        return false;
    }

    /**
     * Todo: When adding student set the id of the student according to the current row index allocated DONE
     * @param student
     * @return
     */
    @Override
    public boolean add(Student student) {
        int id = studentList.size();
        student.setId(id);
        studentList.add(student);
        return true;
    }

    /**
     * Todo: clear the list DONE
     */
    @Override
    public void clear(){
        studentList.clear();
    }

    /**
     * Todo: return current student DONE
     * @param index
     * @return
     */
    @Override
    public Student get(int index) {
        return studentList.get(index);
    }

    /**
     * Todo: Replace current Element of the given index with passed element DONE
     * @param index
     * @param element
     * @return previous student element before replaced
     */
    @Override
    public Student set(int index, Student element) {
        //Don't forget you need to change student id
        element.setId(index);
        return studentList.set(index,element);
    }

    /**
     * Todo: Inserts the specified element at the specified position in this list. DONE
     * Shifts the element currently at that position (if any) and
     * any subsequent elements to the right (adds one to their indices).
     * @param index
     * @param element
     */
    @Override
    public void add(int index, Student element) {
        //add new element at certain index affect all elements post given index (the id)
        element.setId(index);
        recalculateId();
        studentList.add(index,element);

    }

    public void recalculateId(){
        for(int i = 1; i < studentList.size()+1; i++){
            Student student = studentList.get(i);
            student.setId(i);
        }
    }

    /**
     * Todo: Remove student of given index, then recalculate all affected student ids DONE
     * @param index
     * @return
     */
    @Override
    public Student remove(int index) {
        Student student = studentList.remove(index);
        recalculateId();
        return student;
    }

    @Override
    public int indexOf(Object o) {
        return studentList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return studentList.lastIndexOf(o);
    }

    @Override
    public ListIterator<Student> listIterator() {
        return studentList.listIterator();
    }

    @NonNull
    @Override
    public ListIterator<Student> listIterator(int index) {
        return studentList.listIterator(index);
    }

    @NonNull
    @Override
    public List<Student> subList(int fromIndex, int toIndex) {
        return studentList.subList(fromIndex,toIndex);
    }
}
