package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dto.Course;
import ua.alevel.dto.Grade;
import ua.alevel.dto.Teacher;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectInit {
    private static final Logger LOG = LoggerFactory.getLogger(ObjectInit.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static Teacher newTeacher() {
        Teacher teacher = new Teacher();

        try {
            System.out.print("Input first name: ");
            String input = reader.readLine();

            teacher.setFirstName(input);

            System.out.print("Input last name: ");
            input = reader.readLine();
            teacher.setLastName(input);
        } catch (IOException e) {
            System.out.println("Incorrect values.");
            return newTeacher();
        }

        return teacher;
    }

    public static Course newCourse() {
        Course course = new Course();

        try {
            System.out.print("Input name: ");
            String input = reader.readLine();
            course.setName(input);

            System.out.print("Input duration: ");
            int duration = Integer.parseInt(reader.readLine());

            if (duration < 1) {
                System.out.println("Incorrect values. Duration cannot be less than 1.");
                return newCourse();
            }

            course.setDuration(duration);

            System.out.print("Input teacher id: ");
            course.setTeacherId(Integer.parseInt(reader.readLine()));

            System.out.print("Input theme id: ");
            course.setThemeId(Integer.parseInt(reader.readLine()));

            System.out.println("Input course start date ( format : yyyy-mm-dd )");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = getDate(dateFormat);
            course.setStartDate(startDate);
        } catch (IOException e) {
            System.out.println("Incorrect values.");
            return newCourse();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return newCourse();
        }

        return course;
    }

    private static Date getDate(SimpleDateFormat dateFormat) {
        while (true) {
            try {
                final String startDateLine = reader.readLine();
                return dateFormat.parse(startDateLine);
            } catch (ParseException e) {
//                LOG.error("Can not parse date ", e);
                System.out.println("Incorrect format. Try again.");
            } catch (IOException e) {
                System.out.println("Incorrect values.");
            }
        }
    }

    public static Course updateCourse() {
        Course course = new Course();

        try {
            System.out.print("Input id: ");
            course.setId(Integer.parseInt(reader.readLine()));

            System.out.print("Input name: ");
            String input = reader.readLine();
            course.setName(input);

            System.out.print("Input duration: ");
            int duration = Integer.parseInt(reader.readLine());

            if (duration < 1) {
                System.out.println("Incorrect values. Duration cannot be less than 1.");
                return updateCourse();
            }

            course.setDuration(duration);

            System.out.print("Input teacher id: ");
            course.setTeacherId(Integer.parseInt(reader.readLine()));

            System.out.print("Input theme id: ");
            course.setThemeId(Integer.parseInt(reader.readLine()));

            System.out.println("Input course start date ( format : yyyy-mm-dd )");
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = getDate(dateFormat);
            course.setStartDate(startDate);
        } catch (IOException e) {
            System.out.println("Incorrect values.");
            return updateCourse();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return updateCourse();
        }

        return course;
    }

    public static Grade newGrade() {
        Grade grade = new Grade();

        try {
            System.out.print("Input student course id: ");
            grade.setStudentsCourseId(Integer.parseInt(reader.readLine()));

            System.out.print("Input mark: ");
            grade.setMark(Integer.parseInt(reader.readLine()));
        } catch (IOException e) {
            System.out.println("Incorrect values.");
            return newGrade();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return newGrade();
        }

        return grade;
    }

    public static Grade updateGrade() {
        Grade grade = new Grade();

        try {
            System.out.print("Input grade id: ");
            grade.setId(Integer.parseInt(reader.readLine()));

            System.out.print("Input mark: ");
            grade.setMark(Integer.parseInt(reader.readLine()));

        } catch (IOException e) {
            System.out.println("Incorrect values.");
            return updateGrade();
        } catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return updateGrade();
        }

        return grade;
    }

}
