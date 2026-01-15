package platform;

import platform.service.*;

public class Main {

    public static void main(String[] args) throws Exception {

        CourseService courseService = new CourseService();
        LessonService lessonService = new LessonService();
        ProgressService progressService = new ProgressService();

        int userId = 1;
        int courseId = 1;
        int lessonId = 1;

        courseService.enroll(userId, courseId);
        lessonService.openLesson(userId, lessonId);
        progressService.markCompleted(userId, lessonId);

        double progress = progressService.getProgress(userId, courseId);
        System.out.println("Course progress: " + progress + "%");
    }
}
