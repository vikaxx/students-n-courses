package ua.alevel.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    private static final Logger LOG = LoggerFactory.getLogger(Input.class);
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static String inputTheme() {
        String input = "";
        try {
            System.out.print("Input theme: ");
            input = reader.readLine();
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }
        return input;
    }

    public static int inputTeacherId() {
        int input = 1;
        try {
            System.out.print("Input teacher id: ");
            input = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return inputTeacherId();
        }
        return input;
    }

    public static int inputCourseId() {
        int input = 1;
        try {
            System.out.print("Input course id: ");
            input = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return inputCourseId();
        }
        return input;
    }


    public static int inputStudentId() {
        int input = 1;
        try {
            System.out.print("Input student id: ");
            input = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }catch (NumberFormatException e) {
            System.out.println("Incorrect value.");
            return inputStudentId();
        }
        return input;
    }

    public static boolean blockStudent() {
        try {
            System.out.print("Input 'true' to block or 'false' to unblock student: ");
            return Boolean.parseBoolean(reader.readLine());
        } catch (IOException e) {
            LOG.error("IO exception ", e);
        }
        return false;
    }
}
