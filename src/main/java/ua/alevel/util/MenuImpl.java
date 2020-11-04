package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;
import ua.alevel.services.TeacherService;
import ua.alevel.services.ThemeService;
import ua.alevel.users.AbstractUser;
import ua.alevel.users.AdminUser;
import ua.alevel.users.StudentUser;
import ua.alevel.users.TeacherUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class MenuImpl implements Menu {
    private final Logger LOG = LoggerFactory.getLogger(MenuImpl.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private UserAuth userAuth;

    @Autowired
    public MenuImpl(UserAuth userAuth) {
        this.userAuth = userAuth;
    }

    @Autowired
    private AbstractUser abstractUser;

    @Autowired
    private AdminUser adminUser;

    @Autowired
    private TeacherUser teacherUser;

    @Autowired
    private StudentUser studentUser;

    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ThemeService themeService;


    public MenuImpl() {
    }

    public void mainMenu() {
        List<Object> user = userAuth.getUserIdWithType();
        String userType = (String) user.get(0);
        int userId = (int) user.get(1);

        switch (userType) {
            case "admin":
                mainMenuAdmin();
                break;
            case "teacher":
                mainMenuTeacher(userId);
                break;
            case "student":
                mainMenuStudent(userId);
                break;
        }
    }

    private void mainMenuAdmin() {
        try {
            while (true) {
                System.out.println("\nChoose an action, please: ");
                System.out.println("1 - See all courses");
                System.out.println("2 - See all courses sorted a-z");
                System.out.println("3 - See all courses sorted z-a");
                System.out.println("4 - See all courses sorted by duration 1-9");
                System.out.println("5 - See all courses sorted by duration 9-1");
                System.out.println("6 - See all courses sorted by students amount 1-9");
                System.out.println("7 - See all courses sorted by students amount 9-1");
                System.out.println("8 - See all courses by theme");
                System.out.println("9 - See all courses by teacher");
                ////     special role opportunities       ////
                System.out.println("10 - Add new teacher");
                System.out.println("11 - Add new course");
                System.out.println("12 - Update course");
                System.out.println("13 - Delete course");
                System.out.println("14 - Put teacher to course");
                System.out.println("15 - Ban student");
                ////     quit program       ////
                System.out.println("q - quit\n");

                String input = reader.readLine();

                List<Course> courses = new ArrayList<>();
                List<CourseWithStudentsAmount> coursesWithAmount = new ArrayList<>();

                switch (input) {
                    case "1":
                        courses = abstractUser.selectAllCourses();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "2":
                        courses = abstractUser.selectAllCoursesAZ();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "3":
                        courses = abstractUser.selectAllCoursesZA();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "4":
                        courses = abstractUser.selectCoursesSortedByDuration("ASC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "5":
                        courses = abstractUser.selectCoursesSortedByDuration("DESC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "6":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("ASC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "7":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("DESC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "8":
                        themeService.selectAllThemes().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTheme(Input.inputTheme());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "9":
                        teacherService.selectAllTeachers().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTeacher(Input.inputTeacherId());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "10":

                        break;
                    case "11":

                        break;
                    case "12":

                        break;
                    case "13":

                        break;
                    case "14":

                        break;
                    case "15":

                        break;
                    case "q":
                        System.out.println("Exit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input 'q' to quit.\n");
                }

            }

        } catch (IOException e) {
            LOG.error("IO exception", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                LOG.error("IO exception", e);
            }
        }
    }


    private void mainMenuStudent(int id) {
        System.out.println("your id is " + id);

        try {
            while (true) {
                System.out.println("\nChoose an action, please: ");
                System.out.println("1 - See all courses");
                System.out.println("2 - See all courses sorted a-z");
                System.out.println("3 - See all courses sorted z-a");
                System.out.println("4 - See all courses sorted by duration 1-9");
                System.out.println("5 - See all courses sorted by duration 9-1");
                System.out.println("6 - See all courses sorted by students amount 1-9");
                System.out.println("7 - See all courses sorted by students amount 9-1");
                System.out.println("8 - See all courses by theme");
                System.out.println("9 - See all courses by teacher");
                ////     special role opportunities       ////
                System.out.println("10 - Go to new course");
                System.out.println("11 - See my future courses");
                System.out.println("12 - See my current courses");
                System.out.println("13 - See my finished courses");
                ////     quit program       ////
                System.out.println("q - quit\n");

                String input = reader.readLine();

                List<Course> courses = new ArrayList<>();
                List<CourseWithStudentsAmount> coursesWithAmount = new ArrayList<>();

                switch (input) {
                    case "1":
                        courses = abstractUser.selectAllCourses();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "2":
                        courses = abstractUser.selectAllCoursesAZ();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "3":
                        courses = abstractUser.selectAllCoursesZA();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "4":
                        courses = abstractUser.selectCoursesSortedByDuration("ASC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "5":
                        courses = abstractUser.selectCoursesSortedByDuration("DESC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "6":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("ASC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "7":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("DESC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "8":
                        themeService.selectAllThemes().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTheme(Input.inputTheme());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "9":
                        teacherService.selectAllTeachers().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTeacher(Input.inputTeacherId());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "10":

                        break;
                    case "11":

                        break;
                    case "12":

                        break;
                    case "13":

                        break;
                    case "q":
                        System.out.println("Exit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input 'q' to quit.\n");
                }

            }

        } catch (IOException e) {
            LOG.error("IO exception", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                LOG.error("IO exception", e);
            }
        }
    }

    private void mainMenuTeacher(int id) {
        System.out.println("your id is " + id);

        try {
            while (true) {
                System.out.println("\nChoose an action, please: ");
                System.out.println("1 - See all courses");
                System.out.println("2 - See all courses sorted a-z");
                System.out.println("3 - See all courses sorted z-a");
                System.out.println("4 - See all courses sorted by duration 1-9");
                System.out.println("5 - See all courses sorted by duration 9-1");
                System.out.println("6 - See all courses sorted by students amount 1-9");
                System.out.println("7 - See all courses sorted by students amount 9-1");
                System.out.println("8 - See all courses by theme");
                System.out.println("9 - See all courses by teacher");
                ////     special role opportunities       ////
                System.out.println("10 - See my courses");
                System.out.println("11 - Grade student");
                System.out.println("12 - Update student's grade");
                System.out.println("13 - See grades journal");
                ////     quit program       ////
                System.out.println("q - quit\n");

                String input = reader.readLine();

                List<Course> courses = new ArrayList<>();
                List<CourseWithStudentsAmount> coursesWithAmount = new ArrayList<>();

                switch (input) {
                    case "1":
                        courses = abstractUser.selectAllCourses();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "2":
                        courses = abstractUser.selectAllCoursesAZ();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "3":
                        courses = abstractUser.selectAllCoursesZA();
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "4":
                        courses = abstractUser.selectCoursesSortedByDuration("ASC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "5":
                        courses = abstractUser.selectCoursesSortedByDuration("DESC");
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "6":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("ASC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "7":
                        coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("DESC");
                        if (coursesWithAmount.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        coursesWithAmount.forEach(System.out::println);
                        break;
                    case "8":
                        themeService.selectAllThemes().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTheme(Input.inputTheme());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "9":
                        teacherService.selectAllTeachers().forEach(System.out::println);
                        courses = abstractUser.selectCoursesByTeacher(Input.inputTeacherId());
                        if (courses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        courses.forEach(System.out::println);
                        break;
                    case "10":

                        break;
                    case "11":

                        break;
                    case "12":

                        break;
                    case "13":

                        break;
                    case "q":
                        System.out.println("Exit!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Input 'q' to quit.\n");
                }

            }

        } catch (IOException e) {
            LOG.error("IO exception", e);
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                LOG.error("IO exception", e);
            }
        }
    }

}

