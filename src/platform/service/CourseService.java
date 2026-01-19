package platform.service;

import platform.entity.Course;
import platform.exception.CourseArchivedException;
import platform.repository.CourseRepository;
import platform.repository.EnrollmentRepository;

public class CourseService {

    private final CourseRepository courseRepo = new CourseRepository();
    private final EnrollmentRepository enrollRepo = new EnrollmentRepository();

    public void enroll(int userId, int courseId) throws Exception {
        Course course = courseRepo.findById(courseId);

        if (course.isArchived()) {
            throw new CourseArchivedException();
        }

        enrollRepo.save(userId, courseId);
    }
    public Course createCourse(String title) throws Exception {
        return courseRepo.save(title);
    }

}
