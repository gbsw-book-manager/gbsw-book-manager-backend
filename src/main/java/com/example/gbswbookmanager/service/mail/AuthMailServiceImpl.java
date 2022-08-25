package com.example.gbswbookmanager.service.mail;

import com.example.gbswbookmanager.entity.AuthMailToken;
import com.example.gbswbookmanager.repository.MailTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthMailServiceImpl implements AuthMailService {

    private final JavaMailSender javaMailSender;

    private final MailTokenRepository mailTokenRepository;

    @Override
    public MimeMessage createAuthMessage(String name, String email) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();

        String code = UUID.randomUUID().toString().substring(0, 6);

        AuthMailToken authMailToken = AuthMailToken.createEmailToken(email, code);
        mailTokenRepository.save(authMailToken);

        message.setFrom("gbsw_book_manager@naver.com");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("경북소프트웨어고등학교 전공도서 관리 사이트 회원가입 인증번호");
        message.setContent("<!DOCTYPE html PUBLIC\"-//W3C//DTD XHTML 1.0 Transitional//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\"content=\"text/html; charset=UTF-8\"/><title>Demystifying Email Design</title><meta name=\"viewport\"content=\"width=device-width, initial-scale=1.0\"/></head><body style=\"margin: 0; padding: 0\"><!--<table border=\"1\"cellpadding=\"0\"cellspacing=\"0\"width=\"100%\"><tr><td>Hello!</td></tr></table>--><center style=\"min-width: 580px; width: 100%\"><table style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><td style=\"\n" +
                "                -moz-hyphens: auto;\n" +
                "                -webkit-hyphens: auto;\n" +
                "                margin: 0;\n" +
                "                border-collapse: collapse !important;\n" +
                "                color: #322f37;\n" +
                "                font-family: Helvetica, Arial, sans-serif;\n" +
                "                font-size: 10px;\n" +
                "                font-weight: 400;\n" +
                "                hyphens: auto;\n" +
                "                line-height: 10px;\n" +
                "                margin: 0;\n" +
                "                mso-line-height-rule: exactly;\n" +
                "                padding: 0;\n" +
                "                text-align: left;\n" +
                "                vertical-align: top;\n" +
                "                word-wrap: break-word;\n" +
                "              \"height=\"10px\">&nbsp;</td></tr></tbody></table><table style=\"\n" +
                "          margin: 0 auto;\n" +
                "          background: #fff;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 580px;\n" +
                "        \"align=\"center\"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><td style=\"\n" +
                "                -moz-hyphens: auto;\n" +
                "                -webkit-hyphens: auto;\n" +
                "                margin: 0;\n" +
                "                border-collapse: collapse !important;\n" +
                "                color: #322f37;\n" +
                "                font-family: Helvetica, Arial, sans-serif;\n" +
                "                font-size: 16px;\n" +
                "                font-weight: 400;\n" +
                "                hyphens: auto;\n" +
                "                line-height: 1.3;\n" +
                "                margin: 0;\n" +
                "                padding: 0;\n" +
                "                text-align: left;\n" +
                "                vertical-align: top;\n" +
                "                word-wrap: break-word;\n" +
                "              \"><table style=\"\n" +
                "                  background-attachment: scroll;\n" +
                "                  background-color: #fff;\n" +
                "                  background-image: none;\n" +
                "                  background-position: top left;\n" +
                "                  background-repeat: repeat;\n" +
                "                  border-bottom: 1px solid #bcbcbc;\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  display: table;\n" +
                "                  margin: 10px 0 15px 0;\n" +
                "                  padding: 0;\n" +
                "                  position: relative;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                  z-index: 1;\n" +
                "                \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                        margin: 0 auto;\n" +
                "                        color: #322f37;\n" +
                "                        font-family: Helvetica, Arial, sans-serif;\n" +
                "                        font-size: 16px;\n" +
                "                        font-weight: 400;\n" +
                "                        line-height: 1.3;\n" +
                "                        padding: 0;\n" +
                "                        padding-bottom: 0 !important;\n" +
                "                        padding-left: 20px;\n" +
                "                        padding-right: 20px;\n" +
                "                        padding-top: 0 !important;\n" +
                "                        text-align: left;\n" +
                "                        width: 560px;\n" +
                "                      \"><table style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"><tbody><tr style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"><a href=\"\"style=\"\n" +
                "                                  margin: 0;\n" +
                "                                  color: #9147ff;\n" +
                "                                  font-family: helvetica, arial, sans-serif;\n" +
                "                                  font-weight: 400;\n" +
                "                                  line-: 1.3;\n" +
                "                                  margin: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  text-align: left;\n" +
                "                                  text-decoration: none;\n" +
                "                                \"rel=\"noreferrer noopener\"target=\"_blank\"><img src=\"https://i.ibb.co/TRFnqsb/logo.png\"style=\"\n" +
                "                                    -ms-interpolation-mode: bicubic;\n" +
                "                                    margin: 0 auto;\n" +
                "                                    border: none;\n" +
                "                                    border-bottom: 1px solid royalblue;\n" +
                "                                    clear: both;\n" +
                "                                    display: block;\n" +
                "                                    float: none;\n" +
                "                                    margin: 0 auto;\n" +
                "                                    margin-bottom: -1px;\n" +
                "                                    max-width: 100%;\n" +
                "                                    outline: 0;\n" +
                "                                    padding: 15px 0;\n" +
                "                                    position: relative;\n" +
                "                                    text-align: center;\n" +
                "                                    text-decoration: none;\n" +
                "                                    width: 200px !important;\n" +
                "                                    z-index: 2;\n" +
                "                                  \"loading=\"lazy\"/></a></th><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0 !important;\n" +
                "                                text-align: left;\n" +
                "                                visibility: hidden;\n" +
                "                                width: 0;\n" +
                "                              \"></th></tr></tbody></table></th></tr></tbody></table><table style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  padding: 0;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><td style=\"\n" +
                "                        -moz-hyphens: auto;\n" +
                "                        -webkit-hyphens: auto;\n" +
                "                        margin: 0;\n" +
                "                        border-collapse: collapse !important;\n" +
                "                        color: #322f37;\n" +
                "                        font-family: Helvetica, Arial, sans-serif;\n" +
                "                        font-size: 15px;\n" +
                "                        font-weight: 400;\n" +
                "                        hyphens: auto;\n" +
                "                        line-height: 15px;\n" +
                "                        margin: 0;\n" +
                "                        mso-line-height-rule: exactly;\n" +
                "                        padding: 0;\n" +
                "                        text-align: left;\n" +
                "                        vertical-align: top;\n" +
                "                        word-wrap: break-word;\n" +
                "                      \"height=\"15px\">&nbsp;</td></tr></tbody></table><table style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  display: table;\n" +
                "                  padding: 0;\n" +
                "                  position: relative;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                        margin: 0 auto;\n" +
                "                        color: #322f37;\n" +
                "                        font-family: Helvetica, Arial, sans-serif;\n" +
                "                        font-size: 16px;\n" +
                "                        font-weight: 400;\n" +
                "                        line-height: 1.3;\n" +
                "                        margin: 0 auto;\n" +
                "                        padding: 0;\n" +
                "                        padding-bottom: 0 !important;\n" +
                "                        padding-left: 20px;\n" +
                "                        padding-right: 20px;\n" +
                "                        padding-top: 0 !important;\n" +
                "                        text-align: left;\n" +
                "                        width: 560px;\n" +
                "                      \"><table style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"><tbody><tr style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"><h6 style=\"\n" +
                "                                  margin: 0;\n" +
                "                                  margin-bottom: 10px;\n" +
                "                                  color: inherit;\n" +
                "                                  font-family: Helvetica, Arial, sans-serif;\n" +
                "                                  font-size: 18px;\n" +
                "                                  font-weight: 400;\n" +
                "                                  line-height: 1.3;\n" +
                "                                  margin: 0;\n" +
                "                                  margin-bottom: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  padding-bottom: 0;\n" +
                "                                  text-align: center;\n" +
                "                                  word-wrap: normal;\n" +
                "                                \">안녕하세요, " + name + "님<a href=\"\"style=\"\n" +
                "                                    margin: 0;\n" +
                "                                    color: royalblue;\n" +
                "                                    font-family: helvetica, arial, sans-serif;\n" +
                "                                    font-weight: 400;\n" +
                "                                    line-: 1.3;\n" +
                "                                    margin: 0;\n" +
                "                                    padding: 0;\n" +
                "                                    text-align: left;\n" +
                "                                    text-decoration: none;\n" +
                "                                  \"rel=\"noreferrer noopener\"target=\"_blank\"> 인증번호입니다.</a></h6><table style=\"\n" +
                "                                  border-collapse: collapse;\n" +
                "                                  border-spacing: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  text-align: left;\n" +
                "                                  vertical-align: top;\n" +
                "                                  width: 100%;\n" +
                "                                \"><tbody><tr style=\"\n" +
                "                                      padding: 0;\n" +
                "                                      text-align: left;\n" +
                "                                      vertical-align: top;\n" +
                "                                    \"><td style=\"\n" +
                "                                        -moz-hyphens: auto;\n" +
                "                                        -webkit-hyphens: auto;\n" +
                "                                        margin: 0;\n" +
                "                                        border-collapse: collapse !important;\n" +
                "                                        color: #322f37;\n" +
                "                                        font-family: Helvetica, Arial,\n" +
                "                                          sans-serif;\n" +
                "                                        font-size: 10px;\n" +
                "                                        font-weight: 400;\n" +
                "                                        hyphens: auto;\n" +
                "                                        line-height: 10px;\n" +
                "                                        margin: 0;\n" +
                "                                        mso-line-height-rule: exactly;\n" +
                "                                        padding: 0;\n" +
                "                                        text-align: left;\n" +
                "                                        vertical-align: top;\n" +
                "                                        word-wrap: break-word;\n" +
                "                                      \"height=\"10px\">&nbsp;</td></tr></tbody></table><div style=\"\n" +
                "                                  background: #faf9fa;\n" +
                "                                  border: 1px solid #dad8de;\n" +
                "                                  text-align: center;\n" +
                "                                  padding: 5px;\n" +
                "                                  margin: 0 auto;\n" +
                "                                  font-size: 24px;\n" +
                "                                  line-height: 1.5;\n" +
                "                                  width: 80%;\n" +
                "                                \">" + code + "</div></th><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0 !important;\n" +
                "                                text-align: left;\n" +
                "                                visibility: hidden;\n" +
                "                                width: 0;\n" +
                "                              \"></th></tr></tbody></table></th></tr></tbody></table><table style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  display: table;\n" +
                "                  padding: 0;\n" +
                "                  position: relative;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                        margin: 0 auto;\n" +
                "                        color: #322f37;\n" +
                "                        font-family: Helvetica, Arial, sans-serif;\n" +
                "                        font-size: 16px;\n" +
                "                        font-weight: 400;\n" +
                "                        line-height: 1.3;\n" +
                "                        margin: 0 auto;\n" +
                "                        padding: 0;\n" +
                "                        padding-bottom: 16px;\n" +
                "                        padding-left: 20px;\n" +
                "                        padding-right: 20px;\n" +
                "                        padding-top: 20px;\n" +
                "                        text-align: left;\n" +
                "                        width: 560px;\n" +
                "                      \"><table style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"><tbody><tr style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"><table style=\"\n" +
                "                                  border-collapse: collapse;\n" +
                "                                  border-spacing: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  text-align: left;\n" +
                "                                  vertical-align: top;\n" +
                "                                  width: 100%;\n" +
                "                                \"><tbody><tr style=\"\n" +
                "                                      padding: 0;\n" +
                "                                      text-align: left;\n" +
                "                                      vertical-align: top;\n" +
                "                                    \"><td style=\"\n" +
                "                                        -moz-hyphens: auto;\n" +
                "                                        -webkit-hyphens: auto;\n" +
                "                                        margin: 0;\n" +
                "                                        border-collapse: collapse !important;\n" +
                "                                        color: #322f37;\n" +
                "                                        font-family: Helvetica, Arial,\n" +
                "                                          sans-serif;\n" +
                "                                        font-size: 10px;\n" +
                "                                        font-weight: 400;\n" +
                "                                        hyphens: auto;\n" +
                "                                        line-height: 10px;\n" +
                "                                        margin: 0;\n" +
                "                                        mso-line-height-rule: exactly;\n" +
                "                                        padding: 0;\n" +
                "                                        text-align: left;\n" +
                "                                        vertical-align: top;\n" +
                "                                        word-wrap: break-word;\n" +
                "                                      \"height=\"10px\">&nbsp;</td></tr></tbody></table><br/></th><th colspan=\"1\"rowspan=\"1\"style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0 !important;\n" +
                "                                text-align: left;\n" +
                "                                visibility: hidden;\n" +
                "                                width: 0;\n" +
                "                              \"></th></tr></tbody></table></th></tr></tbody></table></td></tr></tbody></table><table style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><td style=\"\n" +
                "                -moz-hyphens: auto;\n" +
                "                -webkit-hyphens: auto;\n" +
                "                margin: 0;\n" +
                "                border-collapse: collapse !important;\n" +
                "                color: #322f37;\n" +
                "                font-family: Helvetica, Arial, sans-serif;\n" +
                "                font-size: 10px;\n" +
                "                font-weight: 400;\n" +
                "                hyphens: auto;\n" +
                "                line-height: 10px;\n" +
                "                margin: 0;\n" +
                "                mso-line-height-rule: exactly;\n" +
                "                padding: 0;\n" +
                "                text-align: left;\n" +
                "                vertical-align: top;\n" +
                "                word-wrap: break-word;\n" +
                "              \"height=\"10px\">&nbsp;</td></tr></tbody></table><table style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"><tbody><tr style=\"padding: 0; text-align: left; vertical-align: top\"><td style=\"\n" +
                "                -moz-hyphens: auto;\n" +
                "                -webkit-hyphens: auto;\n" +
                "                margin: 0;\n" +
                "                border-collapse: collapse !important;\n" +
                "                color: #322f37;\n" +
                "                font-family: Helvetica, Arial, sans-serif;\n" +
                "                font-size: 30px;\n" +
                "                font-weight: 400;\n" +
                "                hyphens: auto;\n" +
                "                line-height: 30px;\n" +
                "                margin: 0;\n" +
                "                mso-line-height-rule: exactly;\n" +
                "                padding: 0;\n" +
                "                text-align: left;\n" +
                "                vertical-align: top;\n" +
                "                word-wrap: break-word;\n" +
                "              \"height=\"30px\">&nbsp;</td></tr></tbody></table></center></body></html>", "text/html; charset=UTF-8");

        return message;
    }

    @Override
    public void sendAuthMail(String name, String email) throws Exception {
        try {
            MimeMessage mailMessage = createAuthMessage(name, email);
            javaMailSender.send(mailMessage);
        } catch (MailException mailException) {
            mailException.printStackTrace();
            throw new IllegalAccessException();
        }
    }

    @Override
    public Boolean checkAuthCode(String email, String code) {
        LocalDateTime time = LocalDateTime.now();
        AuthMailToken authMailToken = mailTokenRepository.findByEmailAndExpirationDateAfterAndExpired(email, time, false);

        if (authMailToken.getCode().equals(code)) {
            authMailToken.setTokenToUsed();
            mailTokenRepository.save(authMailToken);
            return true;
        } else {
            return false;
        }
    }

}