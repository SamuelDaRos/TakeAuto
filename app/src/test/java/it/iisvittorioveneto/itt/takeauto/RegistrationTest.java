package it.iisvittorioveneto.itt.takeauto;

import android.util.Patterns;
import android.widget.EditText;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest {

    Registration r = new Registration();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // TODO non funziona il controllo della mail sul test, NullPointerException...
    @Test
    public void testCheckEmail() {
        assertFalse(r.checkEmail("fakeEmail.hi"));
        assertTrue(r.checkEmail("possibleEmail@something.com"));
    }

    @Test
    public void testIsEmailAvailable() {
        User user = new User("email@something.com", "HelloWorld", "No0neKnowMyP$w");
        Registration.userList.add(user);
        assertFalse(r.isEmailAvailable(user.getEmail()));
        assertTrue(r.isEmailAvailable("fakeEmail@something.com"));
        Registration.userList.remove(user);
    }

    @Test
    public void testIsUserAvailable() {
        User user = new User("email@something.com", "HelloWorld", "No0neKnowMyP$w");
        Registration.userList.add(user);
        assertFalse(r.isUserAvailable(user.getUsername()));
        assertTrue(r.isUserAvailable("HowAreYouWorld"));
        Registration.userList.remove(user);
    }

    @Test
    public void testCheckPassword() {
        assertFalse(r.checkPassword("wakepsw"));
        assertTrue(r.isEmailAvailable("Str0nG#p$W"));
    }
}