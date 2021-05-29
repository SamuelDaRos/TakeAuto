package it.iisvittorioveneto.itt.takeauto;

import org.junit.Test;

import static it.iisvittorioveneto.itt.takeauto.Registration.userList;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void addition_isCorrect() {
        Login l= new Login();
        User user=new User("prova@gmail.com", "prova", "prova");
        userList.add(user);
        assertEquals(true, l.UserExist("prova", "prova"));
    }
}