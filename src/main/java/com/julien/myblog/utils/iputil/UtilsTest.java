package com.julien.myblog.utils.iputil;

import com.julien.myblog.utils.SendOutlookEmail;
import org.junit.Test;

import javax.mail.MessagingException;
import java.security.GeneralSecurityException;

/**
 * @function: test
 * @author: 863978160@qq.com
 * @create: 2021-02-11 16:59
 **/
public class UtilsTest {

    @Test
    public void test2(){
        SendOutlookEmail.sendSMTPMail("863978160@qq.com","outlook","test");
    }
}


