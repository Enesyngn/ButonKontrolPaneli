import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/*
------Yapan Kişiler------
* Batuhan Seyrek 1220505046
* Enes Yenigün 1220505062
* */
class OdevButonlar extends JButton {
    private String graphQLAdresi;//Değişken tanımladık.
    private Color AktifRenk;//Renk değişken tanımladık.
    private Color PasifRenk;//Renk değişken tanımladık.
    private boolean isAktif;//boolean değişken tanımladık.
    private static OdevButonlar EnSonAktif; // En son aktif olan butonun referansını saklamak için

    public OdevButonlar(String text) {
        super(text);
        this.graphQLAdresi = ""; // Gerçek adresini eklenecek kısım.
        this.AktifRenk = Color.GREEN; //AktifRenk değişkenini renk olarak tanımlayıp yeşil değerini verdik.
        this.PasifRenk = Color.YELLOW;//PasifRenk  değişkenini renk olarak tanımlayıp sarı değerini verdik.
        this.isAktif = false;

        PasifeAyarlama();
        addActionListener(new ButtonClickListener());
    }

    public void GraphQLAyarla(String schema) {//GraphQLAyarlanması için oluşturulmuş metod
        this.graphQLAdresi = schema;
    }

    public void AktifRenkAyarlama(Color color) {//Butonun aktif hale gelmesi için gereken method
        this.AktifRenk = color;
    }

    public void PasifRenkAyarlama(Color color) {//Butonun pasif hale gelmesi için gereken method
        this.PasifRenk = color;
    }

    private void PasifeAyarlama() {//Pasife ayarlamak için kullanılan method
        setBackground(PasifRenk);//Arkaplanı sarıya olarak ayarlar
        setText("Pasif");//yazıyı pasif olarak ayarlar
        isAktif = false;//isAktif değişkenini false değerine eşitler
    }

    private void AktifeAyarlama() {//Aktife ayarlamak için kullanılan method
        setBackground(AktifRenk);//Arkaplanı yeşil olarak ayarlar
        setText("Aktif");//yazıyı Aktif olarak ayarlar
        isAktif = true;//isAktif değişkenini true değerine eşitler
    }

    private class ButtonClickListener implements ActionListener {//class'a ActionListener'i implamente ettik
        @Override
        public void actionPerformed(ActionEvent e) {
            if (isAktif) {//true değeri ne eşitse gerçekleşir
                SeciliHaricPasif();//metodu çağırdık.
            } else {
                EnSonAktif(); // En son aktif olan butonu sakla
                AktifeAyarlama();//Aktif olarak ayarlanır.
                System.out.println("Mutation çalıştırıldı: " + graphQLAdresi);//graphQLAdresi nin terminale yansıması sağlanır
            }
        }
    }

    private void EnSonAktif() {

        EnSonAktif = this; // En son aktif olan butonu belirler
    }

    private void SeciliHaricPasif() {
        for (Component component : getParent().getComponents()) {
            if (component instanceof OdevButonlar && component != this) {
                ((OdevButonlar) component).PasifeAyarlama();
            }
        }


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Button Panel");//Isım vermiş olduk
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//kapatma tuşuna tıklandığında uygulamanın kapanması sağlanır
            frame.setLayout(new GridLayout(4, 4, 15, 15)); //4 sütun ve 4 satırlık alan kullanma sınırı verir boşluklarıda 15 olarak ayarladık.

            OdevButonlar[][] buttons = new OdevButonlar[4][4];
            for (int i = 0; i < 4; i++) {//for döngüsü kulanılarak butonların içerisine yazılar yazılıyor
                for (int j = 0; j < 4; j++) {
                    buttons[i][j] = new OdevButonlar("Button " + (i * 4 + j + 1));
                    frame.add(buttons[i][j]);
                }
            }
                for (int k = 0; k < 4; k++) {//for döngüsü kulanılarak butonların içerisine yazılar yazılıyor
                    for (int l = 0; l < 4; l++) {
                        buttons[k][l].GraphQLAyarla("https://api.example.com/graphql");
                    }
                }
            // Örnek şema adresleri, gerçek adreslerle değiştirilmelidir.

            frame.setSize(500, 400);//bu yapı sayesindede pencerenin genişliğini 500 , yüksekliğini ise 400 tanımladık.
            frame.setVisible(true);//kullanıcı tarafından görülebilir hale gelmesini sağlar.
        });
    }
}