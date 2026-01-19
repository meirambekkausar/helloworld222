package platform;

import platform.entity.Course;
import platform.entity.User;
import platform.entity.Lesson;
import platform.service.*;

        public class Main {
            public static void main(String[] args) throws Exception {

                UserService userService = new UserService();
                CourseService courseService = new CourseService();
                LessonService lessonService = new LessonService();

                // 1️⃣ Create user
                User user = userService.createUser("Bob", "bobfsd@mail.com");
                System.out.println("User created: " + user.getId());

                // 2️⃣ Create course
                Course course = courseService.createCourse("OOP in Java");
                System.out.println("Course created: " + course.getId());

                // 3️⃣ Create lesson
                Lesson lesson = lessonService.createLesson((long) course.getId(), "Classes and Objects");
                System.out.println("Lesson created: " + lesson.getId());
            }
        }

