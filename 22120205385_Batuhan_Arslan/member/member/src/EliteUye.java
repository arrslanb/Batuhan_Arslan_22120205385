import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EliteUye extends NormalUye{
    static ArrayList<String> eliteUyead=new ArrayList<String>();
    static ArrayList<String> eliteUyesoyad=new ArrayList<String>();
    static ArrayList<String> eliteUyemail=new ArrayList<String>();
    public EliteUye(String ad, String soyAd, String eMail) throws IOException {
        super(ad, soyAd, eMail);
        eliteUyead.add(ad);
        eliteUyesoyad.add(soyAd);
        eliteUyemail.add(eMail);
    }

    @Override
    public  void uyeEkle(NormalUye uye) throws IOException {
        FileWriter writer=null;
        writer=new FileWriter("Elit_Üye.txt",true);
        try {
            writer.write(eliteUyead.get(eliteUyead.size()-1)+"\t"+(eliteUyesoyad.get(eliteUyesoyad.size()-1)+"\t"+(eliteUyemail.get(eliteUyemail.size()-1)))+"\n");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
