package guru.sfg.brewery.web.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class PasswordEncodingTest{

    public final String PASSWORD = "password";

    @Test
    void testLdap(){
        PasswordEncoder ldap = new LdapShaPasswordEncoder();
        System.out.println(ldap.encode(PASSWORD));

        assertTrue(ldap.matches(PASSWORD, ldap.encode(PASSWORD)));
    }

    @Test
    void testNoOp(){
        PasswordEncoder encoder = NoOpPasswordEncoder.getInstance();
        System.out.println(encoder.encode(PASSWORD));
    }

    @Test
    void hashingExample() {
        System.out.println(DigestUtils.md5DigestAsHex(PASSWORD.getBytes()));
        String salted = PASSWORD + "ThisISMySaltvaLUE";
        System.out.println(DigestUtils.md5DigestAsHex(salted.getBytes()));
    }
}
