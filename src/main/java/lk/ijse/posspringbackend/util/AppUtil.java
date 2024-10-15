package lk.ijse.posspringbackend.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppUtil {
    // Method to generate Order ID in the format OXXX
    public static String createOrderId() {
        int randomNum = (int) (Math.random() * 1000);
        return String.format("O%03d", randomNum);  // Ensures format OXXX
    }

    // Method to generate Order Detail ID in the format ODXXX
    public static String createOrderDetailId() {
        int randomNum = (int) (Math.random() * 1000);
        return String.format("OD%03d", randomNum);  // Ensures format ODXXX
    }
}
