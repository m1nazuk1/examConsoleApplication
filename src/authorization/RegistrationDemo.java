package authorization;

import adminPanel.AdminMenu;
import authorization.Entities.User;
import authorization.Register.Authorization;
import authorization.Register.Registration;
import authorization.Register.WorkWithFiles;
import constants.ConstSample;
import generalMenu.MyMenu;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class RegistrationDemo {

    public static void first() throws FileNotFoundException {
        System.out.println("\n\t[1] администратор");
        System.out.println("\n\t[2] пользователь\n");
        int commandNumber = new Scanner(System.in).nextInt();
        switch (commandNumber){
            case 1 -> adminAuthStart();
            case 2 -> start();
        }
    }

    public static void adminAuthStart() throws FileNotFoundException {
        User user = new User();
        System.out.println("\n\t-[ Формат ввода: логин пароль ]-\n");
        String data = new Scanner(System.in).nextLine();

        String[] components = data.split("\\s+");
        if (components.length != 2) {
            System.out.println("\n\t-[ Неверный формат. Верный формат: " +
                    "логин пароль ]-");
            adminAuthStart();
        } else {
            user.setLogin(components[ConstSample.INDEX_LOGIN]);
            if (!user.getLogin().matches(ConstSample.LOGIN_TEMPLATE)) {
                System.out.println("\n\t-[ Неверный формат логина в строке " + user.getLogin() + " (должен содержать буквы) ]-");
                adminAuthStart();
            } else {
                user.setPassword(components[ConstSample.INDEX_PASSWORD]);
                if (!user.getPassword().matches(ConstSample.PASSWORD_TEMPLATE)) {
                    System.out.println("\n\t-[ Неверный формат пароля в строке " + user.getPassword() + " (должен содержать заглавные и" +
                            " строчные буквы, специальные символы и числа) ]-");
                    adminAuthStart();
                } else {
                    if (Authorization.admin(user.getLogin(), user.getPassword())) {
                        System.out.println("\n\t-[ Вы успешно авторизовались ]-");
                        AdminMenu.menu();
                    } else {
                        System.out.println("\n\t-[ Такого аккаунта не существует ]-");
                        first();
                    }
                }
            }
        }
    }


    public static void start() throws FileNotFoundException {
        System.out.println("\n\t[1] регистрация \n" +
                "\t[2] авторизация\n" +
                "\t[0] выход\n");
        Scanner scanner = new Scanner(System.in);
        int commandNumber = scanner.nextInt();
        switch (commandNumber){
            case 1 -> register();
            case 2 -> authStart();
            default -> {
                break;
            }
        }
    }

    public static void register() throws FileNotFoundException {
        User user = new User();
        System.out.println("\n\t-[ введите свои данные" +
                "\n\tформат ввода: логин пароль почта " +
                "(пишите через пробел, соблюдая все правила ввода) ]- \n");
        String data = new Scanner(System.in).nextLine();

        String[] components = data.split("\\s+");
        if (components.length != 3) {
            System.out.println("\n\t-[ Неверный формат ]-");
            register();
        }else {
            user.setLogin(components[ConstSample.INDEX_LOGIN]);
            if (!user.getLogin().matches(ConstSample.LOGIN_TEMPLATE)) {
                System.out.println("\n\t-[ Неверный формат логина в строке " + user.getLogin() + " (должен содержать буквы) ]-");
                register();
            }else{
                user.setPassword(components[ConstSample.INDEX_PASSWORD]);
                if (!user.getPassword().matches(ConstSample.PASSWORD_TEMPLATE)) {
                    System.out.println("\n\t-[ Неверный формат пароля в строке " + user.getPassword() + " (должен содержать заглавные и" +
                            " строчные буквы, специальные символы и числа) ]-");
                    register();
                }else{
                    user.setEmail(components[ConstSample.INDEX_EMAIL]);
                    if (!user.getEmail().matches(ConstSample.EMAIL_TEMPLATE)){
                        System.out.println("\n\t-[ Неверный формат почты в строке " + user.getEmail() + " (должен содержать специальные символы)");
                        register();
                    }else if (Authorization.auth(user.getLogin(), user.getPassword())) {
                        System.out.println("\n\t-[ Такой аккаунт уже существует! Пройдите пожалуйста авторизацию ]-");
                        authStart();
                    }else{
                        user.setId((long) WorkWithFiles.getFile());
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(user.getId());
                        stringBuilder.append("\n" + user.getLogin());
                        stringBuilder.append("\n" + user.getPassword());
                        stringBuilder.append("\n" + user.getEmail());
                        Registration.write(stringBuilder, user.getId());
                        System.out.println("\n\t-[ Вы успешно зарегистрировались! ]-");
                        MyMenu.menu();
                    }
                }
            }
        }
    }

    public static void authStart() throws FileNotFoundException {
        User user = new User();
        System.out.println("\n\t-[ Формат ввода: логин пароль ]-\n");
        String data = new Scanner(System.in).nextLine();

        String[] components = data.split("\\s+");
        if (components.length != 2) {
            System.out.println("\n\t-[ Неверный формат. Верный формат: " +
                    "логин пароль ]-");
            authStart();
        }else {
            user.setLogin(components[ConstSample.INDEX_LOGIN]);
            if (!user.getLogin().matches(ConstSample.LOGIN_TEMPLATE)) {
                System.out.println("\n\t-[ Неверный формат логина в строке " + user.getLogin() + " (должен содержать буквы) ]-");
                authStart();
            }else{
                user.setPassword(components[ConstSample.INDEX_PASSWORD]);
                if (!user.getPassword().matches(ConstSample.PASSWORD_TEMPLATE)) {
                    System.out.println("\n\t-[ Неверный формат пароля в строке " + user.getPassword() + " (должен содержать заглавные и" +
                            " строчные буквы, специальные символы и числа) ]-");
                    authStart();
                }else{
                    if (Authorization.auth(user.getLogin(), user.getPassword())){
                        System.out.println("\n\t-[ Вы успешно авторизовались ]-");
                        MyMenu.menu();
                    }else {
                        System.out.println("\n\t-[ Такого аккаунта не существует, пройдите пожалуйста регистрацию ]-");
                        register();
                    }
                }
            }
        }
    }
}
