import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.Properties;

public class Mail {
    public static void mailGonder(ArrayList<String> alicilar,String konu,String mesaj){
        if (alicilar.isEmpty()){
            throw new IllegalArgumentException("Alıcılar Listesi Boş");
        }
        //Burada gmail sunucusu kullandığımız için hesap şifresinin yerine 16 haneli 2 faktörlü doğrulama şifresi kullanmamız gerekiyor.
        String hesap = "ikincihesap1234@gmail.com"; // Gönderen e-mail adresi
        String sifre = "pfmirhdtfijzyfma"; // 2 faktörlü doğrulama şifresi
        String host = "smtp.gmail.com"; // E-mail sağlayıcısı SMTP sunucusu

        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.port", "587");
        Session session = Session.getInstance(props, new Authenticator()// Gönderen E-mail Hesabına Giriş
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(hesap,sifre);
            }
        });
        try {
            // Alıcıları ekleme
            InternetAddress[] alicilarYeni = new InternetAddress[alicilar.size()];//Arraylisteki mail adreslerini buraya ekliyor.
            for (int i = 0; i < alicilar.size(); i++)//Listedeki mail adreslerini tek tek dönüyor.
            {
                alicilarYeni[i] = new InternetAddress(alicilar.get(i));
            }

            // E-mail oluşturma
            Message emailMessage = new MimeMessage(session);
            emailMessage.setFrom(new InternetAddress(hesap));
            emailMessage.setRecipients(Message.RecipientType.TO, alicilarYeni);
            emailMessage.setSubject(konu);
            emailMessage.setText(mesaj);

            Transport.send(emailMessage);//e-mail gönderme

            System.out.println("E-mail başarıyla gönderildi.");
        } catch (MessagingException e) {
            System.out.println("E-mail gönderimi sırasında bir hata oluştu: " + e.getMessage());
        }
    }


}