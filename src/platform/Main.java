package platform;

import platform.service.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CourseService courseService = new CourseService();
        LessonService lessonService = new LessonService();
        ProgressService progressService = new ProgressService();

        courseService.enroll(1, 1);
        courseService.enroll(1, 2);
        lessonService.openLesson(1, 1);
        lessonService.openLesson(1, 2);
        lessonService.openLesson(1, 3);
        lessonService.openLesson(1, 4);
        progressService.markCompleted(1, 2);
        progressService.markCompleted(1, 3);

        double progress = progressService.getProgress(1, 1);
        System.out.println("Course progress: " + progress + "%");
    }
}
