package user;

import io.qameta.allure.Step;
import utils.PropertyReader;

public class UserFactory {
    @Step("User credentials with admin permission")
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("sucedemo.user"),
                PropertyReader.getProperty("sucedemo.password"));
    }

    @Step("User credentials with locked permission")
    public static User withLockedUserPermission() {
        return new User(PropertyReader.getProperty("sucedemo.locked_out_user"),
                PropertyReader.getProperty("sucedemo.password"));
    }

    @Step("User credentials with username only")
    public static User withUsernameOnly(String username) {
        return new User(username, PropertyReader.getProperty("sucedemo.password"));
    }

    @Step("User credentials with password only")
    public static User withPasswordOnly(String password) {
        return new User(PropertyReader.getProperty("sucedemo.user"), password);
    }
}
