package it.iisvittorioveneto.itt.takeauto;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LoginTest {
    @Test
    public void addition_isCorrect() {
        Login l= new Login();
        assertEquals(false, l.UserExist("prova", "prova"));
    }
}