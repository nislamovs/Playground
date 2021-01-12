package com.example.multitasking.multithreadingBasics.WaitNotifyNotifyAll;

import lombok.*;

public class CourseNotifier {
    @SneakyThrows
    public static void main(String[] args) {
        final Course course = new Course("Java multithread program!");

        //create three threads :
        //    two for the sudents waiting for notification
        //    one for the instructor who is writing the course

        new Thread(() -> {
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " is waiting for the course: " + course.getTitle());
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " the course: " + course.getTitle() + " is now completed");
            }
        }, "Student_A").start();

//        Thread.sleep(200);
        new Thread(() -> {
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " is waiting for the course: " + course.getTitle());
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " the course: " + course.getTitle() + " is now completed");
            }
        }, "Student_B").start();

        new Thread(() -> {
            synchronized (course) {
                System.out.println(Thread.currentThread().getName() + " is starting a new course: " + course.getTitle());
                try {
                    Thread.sleep(4000);
                    course.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, "Instructor").start();
    }
}


@Getter
@Setter
class Course {
    private String title;
    private boolean completed;

    public Course(String s) {
        this.title = s;
    }
}
