package SendMail;

import com.icegreen.greenmail.mail.MailException;
import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetup;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.mail.Message;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class SendEmail {
    private static GreenMail greenMail;


    @BeforeAll
    static void startGreenMailServer() {
        try {
            log.info("Start SMTP server");
            ServerSetup setup = new ServerSetup(3025, "127.0.0.1", ServerSetup.PROTOCOL_SMTP);
            greenMail = new GreenMail(setup);
            greenMail.start();
            greenMail.setUser("user1@mail.com", "user1", "a1s2d3f4g5h6");
            greenMail.waitForIncomingEmail(5, 1);
            log.info("SMTP server start successful");
        } catch (Exception ex) {
            log.error(ex.getMessage());
        }


    }

    @AfterAll
    static void stopServer() {
        greenMail.stop();
    }

    @Test
    void testSendEmail() {

            GreenMailUtil.sendTextEmailTest("user1@mail.com", "user1@mail.com", "some subject",
                    "some body");
            Message[] messages = greenMail.getReceivedMessages();
            assertThat(messages.length).isGreaterThan(0);





    }
}
