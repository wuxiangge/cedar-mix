package com.cedar.design.pattern.creational.builder;

/**
 * @author zhangnan
 * @className CourseActualBuilder
 * @date 2020-04-03 12:05
 * @description
 */
public class CourseActualBuilder extends CourseBuilder {

    private Course course = new Course();

    @Override
    public void builderCourseName(String courseName) {
        this.course.setCourseName(courseName);
    }

    @Override
    public void builderCoursePPT(String coursePPT) {
        this.course.setCoursePPT(coursePPT);
    }

    @Override
    public void builderCourseVideo(String courseVideo) {
        this.course.setCourseVideo(courseVideo);
    }

    @Override
    public void builderCourseArticle(String courseArticle) {
        this.course.setCourseArticle(courseArticle);
    }

    @Override
    public void builderCourseQA(String courseQA) {
        this.course.setCourseQA(courseQA);
    }

    @Override
    public Course makeCourse() {
        return this.course;
    }
}
