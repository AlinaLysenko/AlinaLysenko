package hw_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;

@Getter
@AllArgsConstructor
public class User {

    public static User ROMAN;

    private String login;
    private String password;
    private String fullName;

    private static java.util.Properties properties;

    static {
        properties = new java.util.Properties();
        try (InputStream inputStream = User.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ROMAN = new User(
                properties.getProperty("login"),
                properties.getProperty("password"),
                properties.getProperty("fullName")
        );
    }
}