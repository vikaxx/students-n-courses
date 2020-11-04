package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.alevel.dto.Course;
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
            course.setDuration(Integer.parseInt(reader.readLine()));

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
        }

        return course;
    }

    private static Date getDate(SimpleDateFormat dateFormat) {
        while (true) {
            try {
                final String startDateLine = reader.readLine();
                final Date startDate = dateFormat.parse(startDateLine);
                return startDate;
            } catch (ParseException e) {
                LOG.error("Can not parse date ", e);
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
            course.setDuration(Integer.parseInt(reader.readLine()));

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
        }

        return course;
    }
}
