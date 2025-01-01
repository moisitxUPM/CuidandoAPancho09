package org.pancho.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pancho.model.Caretaker;
import org.pancho.model.Owner;
import org.pancho.model.User;
import org.pancho.model.enums.LanguageEnum;
import servidor.ExternalRRSS;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    
    UserController userController;
    static ArrayList<User> userList;

    @BeforeAll
    static void setup(){
        System.out.println("Empezando los tests!");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("Todos los test ejecutados!");
    }

    @BeforeEach
    public void setUp() {
        userController = UserController.getUserController();
        userController.getUserList().clear();
    }

    @Test
    public void testSingleton() {
        UserController instance1 = UserController.getUserController();
        UserController instance2 = UserController.getUserController();
        assertSame(instance1, instance2);
    }

    @Test
    void showUserList() {
        Owner user = new Owner("Edu", "Bravo Murillo", LanguageEnum.fromValue("es"), "edu@upm.es");
        userController.addUser(user);
    }

    // Test con un user correcto
    @Test
    void existsUser() {
        Owner user = new Owner("Edu","Bravo Murillo",LanguageEnum.fromValue("ES"),"edu@upm.es");
        userController.addUser(user);
        assertTrue(userController.existsUser("edu@upm.es"));
    }

    // Test con un user incorrecto
    @Test
    void existsUser2() {
        Owner user = new Owner("Edu","Bravo Murillo",LanguageEnum.fromValue("ES"),"edu@upm.es");
        userController.addUser(user);
        assertFalse(userController.existsUser("edu2@upm.es"));
    }

    //Test correcto
    @Test
    void logUser() {
        Owner user = new Owner("Moi", "Bravo Murillo 123", LanguageEnum.fromValue("es"), "moi@upm.es");
        userController.addUser(user);

        User loggedInUser = userController.logUser();

        assertNotNull(loggedInUser);
        assertEquals(user, loggedInUser);
    }

    //Test que devuelva null al introducir mal el usuario
    @Test
    void logUser2() {

        Owner user = new Owner("Moi", "Bravo Murillo 123", LanguageEnum.fromValue("es"), "moi@upm.es");
        userController.addUser(user);

        User loggedInUser = userController.logUser();

        assertNull(loggedInUser);
        assertNotEquals(user, loggedInUser);

    }

    //Pilla el user correctamente
    @Test
    void getUser() {
        Owner user = new Owner("Edu","Bravo Murillo",LanguageEnum.fromValue("ES"),"edu@upm.es");
        userController.addUser(user);
        User XUser = userController.getUser("edu@upm.es");
        assertNotNull(XUser);
        assertEquals(user, XUser);
    }

    //Pilla el user incorrectamente y es igual a null
    @Test
    void getUser2() {
        Owner user = new Owner("Edu","Bravo Murillo",LanguageEnum.fromValue("ES"),"edu@upm.es");
        userController.addUser(user);
        User XUser = userController.getUser("edu2@upm.es");
        assertNull(XUser);
    }

    //usuario logueado correctamente
    @Test
    void whoIsLoggedIn() {
        Owner user = new Owner("Edu", "Bravo Murillo", LanguageEnum.fromValue("es"), "edu@upm.es");
        Owner user2 = new Owner("jin", "Calle pepito", LanguageEnum.fromValue("es"), "jin.chen@upm.es");
        user2.setOauthId("oauth-id");
        userController.addUser(user);
        userController.addUser(user2);
        assertEquals(user2, userController.whoIsLoggedIn());
    }

    //usuario no logeado
    @Test
    void whoIsLoggedIn2() {
        Owner user = new Owner("Edu", "Bravo Murillo", LanguageEnum.fromValue("es"), "edu@upm.es");
        Owner user2 = new Owner("Jin", "Calle pepito", LanguageEnum.fromValue("es"), "jin.chen@upm.es");
        userController.addUser(user);
        userController.addUser(user2);

        User loggedInUser = userController.whoIsLoggedIn();
        assertNull(loggedInUser);
    }

    @Test
    void logout() {
        Owner user = new Owner("Edu", "Bravo Murillo", LanguageEnum.fromValue("es"), "edu@upm.es");
        Owner user2 = new Owner("jin", "Calle pepito", LanguageEnum.fromValue("es"), "jin.chen@upm.es");
        user2.setOauthId("oauth-id");
        userController.addUser(user);
        userController.addUser(user2);
        userController.logout();
        assertNull(user2.getOauthId());
    }

    //Creado owner correctamente
    @Test
    void createOwner() {
        userController.createOwner("Rafa", "Bravo Murillo 22", LanguageEnum.fromValue("es"), "rafa@upm.es");
        assertTrue(userController.existsUser("rafa@upm.es"));
    }

    //Owner no creado
    @Test
    void createOwner2() {
        userController.createOwner("Rafa", "Bravo Murillo 22", LanguageEnum.fromValue("es"), "rafa@mm.es");
        assertFalse(userController.existsUser("rafa2@mm.es"));
    }

    // Caretaker correcto
    @Test
    void createCaretaker() {
        userController.createCaretaker("David", "Calle juean", "2", 12.2, 15.5, LanguageEnum.fromValue("ES"), "david@upm.es");
        assertTrue(userController.existsUser("david@upm.es"));
    }

    // Caretaker incorrecto
    @Test
    void createCaretaker2() {
        userController.createCaretaker("David", "Calle juean", "2", 12.2, 15.5, LanguageEnum.fromValue("ES"), "david@mm.es");
        assertFalse(userController.existsUser("david2@mm.es"));
    }

    @Test
    public void testAddUser() {
        Owner user = new Owner("jin", "Calle pepito", LanguageEnum.fromValue("es"), "jin.chen@upm.es");
        userController.addUser(user);
        assertTrue(userController.getUserList().contains(user));
    }

    @Test
    void getUserList() {
        Owner user = new Owner("Edu", "Bravo Murillo", LanguageEnum.fromValue("es"), "edu@upm.es");
        Owner user2 = new Owner("jin", "Calle pepito", LanguageEnum.fromValue("es"), "jin.chen@upm.es");
        Owner user3 = new Owner("Rafa", "Bravo Murillo 22", LanguageEnum.fromValue("es"), "rafa@upm.es");
        userController.addUser(user);
        userController.addUser(user2);
        userController.addUser(user3);
        ArrayList<User> users = userController.getUserList();
        assertEquals(3, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user2));
    }
}