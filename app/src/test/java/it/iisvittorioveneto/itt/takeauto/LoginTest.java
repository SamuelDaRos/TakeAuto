package it.iisvittorioveneto.itt.takeauto;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static it.iisvittorioveneto.itt.takeauto.Registration.userList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginTest {

    Login l = new Login();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testUserExist() {
        User user = new User("prova@gmail.com", "prova", "prova");
        Registration.userList.add(user);
        assertTrue(l.userExist(user.getUsername(), user.getPassword()));
        assertFalse(l.userExist("fs", "fas"));
        Registration.userList.remove(user);
    }
}