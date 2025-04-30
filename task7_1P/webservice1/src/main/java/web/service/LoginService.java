package web.service;

public class LoginService {

    public static boolean login(String username, String password, String dob) {
        // Reject null or empty inputs
        if (isEmpty(username) || isEmpty(password) || isEmpty(dob)) {
            return false;
        }

        // Normalize input
        username = username.trim();
        password = password.trim();
        dob = dob.trim();

        // Accept both formats for DOB
        return "pj".equals(username) &&
               "pj_pass".equals(password) &&
               ("09-10-1996".equals(dob) || "1996-10-09".equals(dob));
    }

    private static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}