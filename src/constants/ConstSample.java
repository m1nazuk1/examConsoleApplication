package constants;

public class ConstSample {
        public static final String LOGIN_TEMPLATE = "([A-z]).{4,}";
        public static final String PASSWORD_TEMPLATE = "(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9@#$%]).{8,}";
        public static final String EMAIL_TEMPLATE = "\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*\\.\\w{2,4}";
        public static final int INDEX_LOGIN = 0;
        public static final int INDEX_PASSWORD = 1;
        public static final int INDEX_EMAIL = 2;
        public static final int INDEX_DAY = 0;
        public static final int INDEX_MONTH = 1;
        public static final int INDEX_YEAR = 2;
        public static final String DAY_TEMPLATE = "([0-9]).{0,2}";
        public static final String MONTH_TEMPLATE = "([0-9]).{0,2}";
        public static final String YEAR_TEMPLATE = "([0-9]).{3,5}";
        public static final String PHONE_TEMPLATE = "7\\d{10}";


}
