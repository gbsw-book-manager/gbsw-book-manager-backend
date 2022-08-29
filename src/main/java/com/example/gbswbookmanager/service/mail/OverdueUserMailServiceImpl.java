package com.example.gbswbookmanager.service.mail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class OverdueUserMailServiceImpl implements OverdueUserMailService {

    private final JavaMailSender javaMailSender;

    @Override
    public MimeMessage createExtensionUserMessage(String name, String email, String bookTitle) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();

        message.setFrom("gbsw_book_manager@naver.com");
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
        message.setSubject("경북소프트웨어고등학교 전공도서 관리, 알림");
        message.setContent("<!DOCTYPE html PUBLIC\"-//W3C//DTD XHTML 1.0 Transitional//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "  <head>\n" +
                "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n" +
                "    <title>overdue</title>\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n" +
                "  </head>\n" +
                "  <body style=\"margin: 0; padding: 0\">\n" +
                "    <!--<table border=\"1\"cellpadding=\"0\"cellspacing=\"0\"width=\"100%\"><tr><td>Hello!</td></tr></table>-->\n" +
                "    <center style=\"min-width: 580px; width: 100%\">\n" +
                "      <table\n" +
                "        style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"\n" +
                "      >\n" +
                "        <tbody>\n" +
                "          <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "            <td\n" +
                "              style=\"\n" +
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
                "              \"\n" +
                "              height=\"10px\"\n" +
                "            >\n" +
                "              &nbsp;\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <table\n" +
                "        style=\"\n" +
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
                "        \"\n" +
                "        align=\"center\"\n" +
                "      >\n" +
                "        <tbody>\n" +
                "          <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "            <td\n" +
                "              style=\"\n" +
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
                "              \"\n" +
                "            >\n" +
                "              <table\n" +
                "                style=\"\n" +
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
                "                \"\n" +
                "              >\n" +
                "                <tbody>\n" +
                "                  <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "                    <th\n" +
                "                      colspan=\"1\"\n" +
                "                      rowspan=\"1\"\n" +
                "                      style=\"\n" +
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
                "                      \"\n" +
                "                    >\n" +
                "                      <table\n" +
                "                        style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"\n" +
                "                      >\n" +
                "                        <tbody>\n" +
                "                          <tr\n" +
                "                            style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"\n" +
                "                          >\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"\n" +
                "                            >\n" +
                "                              <img\n" +
                "                                src=\"https://i.ibb.co/TRFnqsb/logo.png\"\n" +
                "                                style=\"\n" +
                "                                  -ms-interpolation-mode: bicubic;\n" +
                "                                  margin: 0 auto;\n" +
                "                                  border: none;\n" +
                "                                  border-bottom: 1px solid royalblue;\n" +
                "                                  clear: both;\n" +
                "                                  display: block;\n" +
                "                                  float: none;\n" +
                "                                  margin: 0 auto;\n" +
                "                                  margin-bottom: -1px;\n" +
                "                                  max-width: 100%;\n" +
                "                                  outline: 0;\n" +
                "                                  padding: 15px 0;\n" +
                "                                  position: relative;\n" +
                "                                  text-align: center;\n" +
                "                                  text-decoration: none;\n" +
                "                                  width: 200px !important;\n" +
                "                                  z-index: 2;\n" +
                "                                \"\n" +
                "                                loading=\"lazy\"\n" +
                "                              />\n" +
                "                            </th>\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
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
                "                              \"\n" +
                "                            ></th>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </th>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "              <table\n" +
                "                style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  padding: 0;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"\n" +
                "              >\n" +
                "                <tbody>\n" +
                "                  <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "                    <td\n" +
                "                      style=\"\n" +
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
                "                      \"\n" +
                "                      height=\"15px\"\n" +
                "                    >\n" +
                "                      &nbsp;\n" +
                "                    </td>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "              <table\n" +
                "                style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  display: table;\n" +
                "                  padding: 0;\n" +
                "                  position: relative;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"\n" +
                "              >\n" +
                "                <tbody>\n" +
                "                  <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "                    <th\n" +
                "                      colspan=\"1\"\n" +
                "                      rowspan=\"1\"\n" +
                "                      style=\"\n" +
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
                "                      \"\n" +
                "                    >\n" +
                "                      <table\n" +
                "                        style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"\n" +
                "                      >\n" +
                "                        <tbody>\n" +
                "                          <tr\n" +
                "                            style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"\n" +
                "                          >\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"\n" +
                "                            >\n" +
                "                              <h6\n" +
                "                                style=\"\n" +
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
                "                                \"\n" +
                "                              >\n" +
                "                                " + name + "님이 " + bookTitle + " 책을\n" +
                "                                연체하셨습니다.\n" +
                "                              </h6>\n" +
                "                              <table\n" +
                "                                style=\"\n" +
                "                                  border-collapse: collapse;\n" +
                "                                  border-spacing: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  text-align: left;\n" +
                "                                  vertical-align: top;\n" +
                "                                  width: 100%;\n" +
                "                                \"\n" +
                "                              >\n" +
                "                                <tbody>\n" +
                "                                  <tr\n" +
                "                                    style=\"\n" +
                "                                      padding: 0;\n" +
                "                                      text-align: left;\n" +
                "                                      vertical-align: top;\n" +
                "                                    \"\n" +
                "                                  >\n" +
                "                                    <!-- <td\n" +
                "                                      style=\"\n" +
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
                "                                      \"\n" +
                "                                      height=\"10px\"\n" +
                "                                    >\n" +
                "                                      &nbsp;\n" +
                "                                    </td> -->\n" +
                "                                  </tr>\n" +
                "                                </tbody>\n" +
                "                              </table>\n" +
                "                              <div\n" +
                "                                style=\"\n" +
                "                                  /* background: #faf9fa; */\n" +
                "                                  /* border: 1px solid #dad8de; */\n" +
                "                                  text-align: center;\n" +
                "                                  padding: 5px;\n" +
                "                                  margin: 0 auto;\n" +
                "                                  font-size: 18px;\n" +
                "                                  line-height: 1.5;\n" +
                "                                  width: 80%;\n" +
                "                                \"\n" +
                "                              >\n" +
                "                                책을 반납하여주시기 바랍니다.\n" +
                "                              </div>\n" +
                "                            </th>\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
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
                "                              \"\n" +
                "                            ></th>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </th>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "              <table\n" +
                "                style=\"\n" +
                "                  border-collapse: collapse;\n" +
                "                  border-spacing: 0;\n" +
                "                  display: table;\n" +
                "                  padding: 0;\n" +
                "                  position: relative;\n" +
                "                  text-align: left;\n" +
                "                  vertical-align: top;\n" +
                "                  width: 100%;\n" +
                "                \"\n" +
                "              >\n" +
                "                <tbody>\n" +
                "                  <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "                    <th\n" +
                "                      colspan=\"1\"\n" +
                "                      rowspan=\"1\"\n" +
                "                      style=\"\n" +
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
                "                      \"\n" +
                "                    >\n" +
                "                      <table\n" +
                "                        style=\"\n" +
                "                          border-collapse: collapse;\n" +
                "                          border-spacing: 0;\n" +
                "                          padding: 0;\n" +
                "                          text-align: left;\n" +
                "                          vertical-align: top;\n" +
                "                          width: 100%;\n" +
                "                        \"\n" +
                "                      >\n" +
                "                        <tbody>\n" +
                "                          <tr\n" +
                "                            style=\"\n" +
                "                              padding: 0;\n" +
                "                              text-align: left;\n" +
                "                              vertical-align: top;\n" +
                "                            \"\n" +
                "                          >\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
                "                                margin: 0;\n" +
                "                                color: #322f37;\n" +
                "                                font-family: Helvetica, Arial, sans-serif;\n" +
                "                                font-size: 16px;\n" +
                "                                font-weight: 400;\n" +
                "                                line-height: 1.3;\n" +
                "                                margin: 0;\n" +
                "                                padding: 0;\n" +
                "                                text-align: left;\n" +
                "                              \"\n" +
                "                            >\n" +
                "                              <table\n" +
                "                                style=\"\n" +
                "                                  border-collapse: collapse;\n" +
                "                                  border-spacing: 0;\n" +
                "                                  padding: 0;\n" +
                "                                  text-align: left;\n" +
                "                                  vertical-align: top;\n" +
                "                                  width: 100%;\n" +
                "                                \"\n" +
                "                              >\n" +
                "                                <tbody>\n" +
                "                                  <tr\n" +
                "                                    style=\"\n" +
                "                                      padding: 0;\n" +
                "                                      text-align: left;\n" +
                "                                      vertical-align: top;\n" +
                "                                    \"\n" +
                "                                  >\n" +
                "                                    <td\n" +
                "                                      style=\"\n" +
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
                "                                      \"\n" +
                "                                      height=\"10px\"\n" +
                "                                    >\n" +
                "                                      &nbsp;\n" +
                "                                    </td>\n" +
                "                                  </tr>\n" +
                "                                </tbody>\n" +
                "                              </table>\n" +
                "                              <br />\n" +
                "                            </th>\n" +
                "                            <th\n" +
                "                              colspan=\"1\"\n" +
                "                              rowspan=\"1\"\n" +
                "                              style=\"\n" +
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
                "                              \"\n" +
                "                            ></th>\n" +
                "                          </tr>\n" +
                "                        </tbody>\n" +
                "                      </table>\n" +
                "                    </th>\n" +
                "                  </tr>\n" +
                "                </tbody>\n" +
                "              </table>\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <table\n" +
                "        style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"\n" +
                "      >\n" +
                "        <tbody>\n" +
                "          <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "            <td\n" +
                "              style=\"\n" +
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
                "              \"\n" +
                "              height=\"10px\"\n" +
                "            >\n" +
                "              &nbsp;\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "      <table\n" +
                "        style=\"\n" +
                "          margin: 0 auto;\n" +
                "          border-collapse: collapse;\n" +
                "          border-spacing: 0;\n" +
                "          float: none;\n" +
                "          margin: 0 auto;\n" +
                "          padding: 0;\n" +
                "          text-align: center;\n" +
                "          vertical-align: top;\n" +
                "          width: 100%;\n" +
                "        \"\n" +
                "      >\n" +
                "        <tbody>\n" +
                "          <tr style=\"padding: 0; text-align: left; vertical-align: top\">\n" +
                "            <td\n" +
                "              style=\"\n" +
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
                "              \"\n" +
                "              height=\"30px\"\n" +
                "            >\n" +
                "              &nbsp;\n" +
                "            </td>\n" +
                "          </tr>\n" +
                "        </tbody>\n" +
                "      </table>\n" +
                "    </center>\n" +
                "  </body>\n" +
                "</html>\n", "text/html; charset=UTF-8");

        return message;
    }

    @Override
    public void sendExtensionUserMail(String name, String email, String bookTitle) throws Exception {
        try {
            MimeMessage mailMessage = createExtensionUserMessage(name, email, bookTitle);

            log.info("{} : email", email);

            javaMailSender.send(mailMessage);
        } catch (MailException mailException) {
            mailException.printStackTrace();
            throw new IllegalAccessException();
        }
    }
}
