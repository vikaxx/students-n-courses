package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.alevel.dto.Course;
import ua.alevel.dto.additional.CourseWithStudentsAmount;
import ua.alevel.dto.additional.GradeToBeAdded;
import ua.alevel.dto.additional.GradesInTeacherCourses;
import ua.alevel.services.CourseService;
import ua.alevel.services.StudentService;
import ua.alevel.services.TeacherService;
import ua.alevel.services.ThemeService;
import ua.alevel.users.AbstractUser;
import ua.alevel.users.AdminUser;
import ua.alevel.users.StudentUser;
import ua.alevel.users.TeacherUser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

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
                commonUserActionsInfo();
                System.out.println("10 - Add new teacher");
                System.out.println("11 - Add new course");
                System.out.println("12 - Update course");
                System.out.println("13 - Delete course");
                System.out.println("14 - Put teacher to course");
                System.out.println("15 - Block/unblock student");

                String input = reader.readLine();

                switch (input) {
                    case "10":
                        if (adminUser.addNewTeacher(ObjectInit.newTeacher()))
                            System.out.println("Teacher was added.");
                        break;
                    case "11":
                        if (adminUser.addNewCourse(ObjectInit.newCourse()))
                            System.out.println("Course was added");
                        break;
                    case "12":
                        abstractUser.selectAllCourses().forEach(System.out::println);
                        if (adminUser.updateCourse(ObjectInit.updateCourse()))
                            System.out.println("Course was updated");
                        break;
                    case "13":
                        abstractUser.selectAllCourses().forEach(System.out::println);
                        if (adminUser.deleteCourse(Input.inputCourseId()) == null)
                            System.out.println("Course cannot be deleted.");
                        else System.out.println("Course was deleted.");
                        break;
                    case "14":
                        teacherService.selectAllTeachers().forEach(System.out::println);
                        abstractUser.selectAllCourses().forEach(System.out::println);
                        if (adminUser.putTeacherToCourse(Input.inputTeacherId(), Input.inputCourseId()))
                            System.out.println("Teacher was changed.");
                        break;
                    case "15":
                        studentService.selectAllStudents().forEach(System.out::println);
                        int studId = Input.inputStudentId();
                        boolean ban = Input.blockStudent();
                        if (adminUser.setStudentBanned(studId, ban))
                            if (ban)
                                System.out.println("Student was blocked");
                            else System.out.println("Student was unblocked");
                        break;
                    default:
                        commonUserActions(input);
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
        studentUser.setStudentId(id);
        boolean isBanned = studentUser.isStudentBanned(id);

        try {
            while (true) {
                commonUserActionsInfo();
                System.out.println("10 - Go to new course");
                System.out.println("11 - See my future courses");
                System.out.println("12 - See my current courses");
                System.out.println("13 - See my finished courses");

                String input = reader.readLine();

                List<Course> courses;

                switch (input) {
                    case "10":
                        if (!isBanned) {
                            courses = studentUser.selectNotStartedCourses(id);
                            courses.forEach(System.out::println);
                            if (!courses.isEmpty()) {
                                if (studentUser.goToNewCourse(Input.inputCourseId()))
                                    System.out.println("New course was added.");
                            } else System.out.println("No new courses.");
                        } else System.out.println("Unfortunately you were blocked.");
                        break;
                    case "11":
                        courses = studentUser.selectNotStartedCoursesByStudent();
                        printCourses(courses);
                        break;
                    case "12":
                        courses = studentUser.selectStartedCoursesByStudent();
                        printCourses(courses);
                        break;
                    case "13":
                        courses = studentUser.selectEndedCoursesByStudent();
                        printCourses(courses);
                        break;
                    default:
                        commonUserActions(input);
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
        teacherUser.setTeacherId(id);

        try {
            while (true) {
                commonUserActionsInfo();
                System.out.println("10 - See my courses");
                System.out.println("11 - Grade student");
                System.out.println("12 - Update student's grade");
                System.out.println("13 - See grades journal");

                String input = reader.readLine();

                List<Course> courses;
                List<GradesInTeacherCourses> gradesInTeacherCourses;
                List<GradeToBeAdded> gradeToBeAddeds;

                switch (input) {
                    case "10":
                        courses = teacherUser.selectCoursesByTeacher();
                        printCourses(courses);
                        break;
                    case "11":
                        gradeToBeAddeds = teacherUser.selectNotGradedStudentsCourses(id);
                        if (!gradeToBeAddeds.isEmpty()) {
                            gradeToBeAddeds.forEach(System.out::println);
                            if (teacherUser.addGrade(ObjectInit.newGrade())) {
                                System.out.println("Grade was added.");
                            } else System.out.println("Grade cannot be added.");
                        } else System.out.println("All students graded.");
                        break;
                    case "12":
                        gradesInTeacherCourses = teacherUser.selectAllGradesByCourseTeacher();
                        gradesInTeacherCourses.forEach(System.out::println);
                        if (!gradesInTeacherCourses.isEmpty()) {
                            if (teacherUser.updateGrade(ObjectInit.updateGrade()))
                                System.out.println("Grade was updated.");
                            else System.out.println("Grade was not updated.");
                        } else System.out.println("No grades to update.");
                        break;
                    case "13":
                        gradesInTeacherCourses = teacherUser.selectAllGradesByCourseTeacher();
                        if (gradesInTeacherCourses.isEmpty()) {
                            System.out.println("No courses found.");
                        }
                        gradesInTeacherCourses.forEach(System.out::println);
                        break;
                    default:
                        commonUserActions(input);
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

    private void printCourses(List<Course> courses) {
        if (courses.isEmpty()) {
            System.out.println("No courses found.");
        }
        courses.forEach(System.out::println);
    }

    private void printCoursesWithAmount(List<CourseWithStudentsAmount> coursesWithAmount) {
        if (coursesWithAmount.isEmpty()) {
            System.out.println("No courses found.");
        }
        coursesWithAmount.forEach(System.out::println);
    }

    private void commonUserActionsInfo() {
        System.out.println("\nChoose an action, please: ");
        System.out.println("q  - quit");
        System.out.println("1  - See all courses");
        System.out.println("2  - See all courses sorted a-z");
        System.out.println("3  - See all courses sorted z-a");
        System.out.println("4  - See all courses sorted by duration 1-9");
        System.out.println("5  - See all courses sorted by duration 9-1");
        System.out.println("6  - See all courses sorted by students amount 1-9");
        System.out.println("7  - See all courses sorted by students amount 9-1");
        System.out.println("8  - See all courses by theme");
        System.out.println("9  - See all courses by teacher");
    }

    private void commonUserActions(String input) {
        List<Course> courses;
        List<CourseWithStudentsAmount> coursesWithAmount;

        switch (input) {
            case "1":
                courses = abstractUser.selectAllCourses();
                printCourses(courses);
                break;
            case "2":
                courses = abstractUser.selectAllCoursesAZ();
                printCourses(courses);
                break;
            case "3":
                courses = abstractUser.selectAllCoursesZA();
                printCourses(courses);
                break;
            case "4":
                courses = abstractUser.selectCoursesSortedByDuration("ASC");
                printCourses(courses);
                break;
            case "5":
                courses = abstractUser.selectCoursesSortedByDuration("DESC");
                printCourses(courses);
                break;
            case "6":
                coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("ASC");
                printCoursesWithAmount(coursesWithAmount);
                break;
            case "7":
                coursesWithAmount = abstractUser.selectCoursesSortedByStudentsQuantity("DESC");
                printCoursesWithAmount(coursesWithAmount);
                break;
            case "8":
                themeService.selectAllThemes().forEach(System.out::println);
                courses = abstractUser.selectCoursesByTheme(Input.inputTheme());
                printCourses(courses);
                break;
            case "9":
                teacherService.selectAllTeachers().forEach(System.out::println);
                courses = abstractUser.selectCoursesByTeacher(Input.inputTeacherId());
                printCourses(courses);
                break;
            case "q":
                System.out.println("Exit!");
                System.exit(0);
                break;
            default:
                System.out.println("Input 'q' to quit.\n");
        }
    }
}

