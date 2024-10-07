import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// 10x10 luk bir sayı patlatma oyunu
public class BomBom {
    static String[][] veriDizisi; //Her fonksiyonda kullanabilmek için class'da tanımlandı.
    static String koordinattakiSayi; //Her fonksiyonda kullanabilmek için class'da tanımlandı.

    public static void main(String[] args) {

        System.out.println("Lütfen haritanın bulunduğu txt dosyasının dosya yolunu giriniz! Örn: C://harita.txt");
        Scanner dosyaGirdisi = new Scanner(System.in);
        String dosyaYolu = dosyaGirdisi.nextLine(); // Txt dosyasının yolu

        try { // Dosyayı okumak için Scanner kullanımı
            File dosya = new File(dosyaYolu);
            Scanner metinDosyasi = new Scanner(dosya);

            veriDizisi = new String[10][10]; // Harita için 2 boyutlu dizi oluşturma (10x10)

            for (int i = 0; i < 10; i++) { // Dosyadan verileri 2 boyutlu diziye alma
                if (metinDosyasi.hasNextLine()) {
                    String satirText = metinDosyasi.nextLine().replaceAll("\\s+", ""); // Boşlukları kaldır
                    char[] charArray = satirText.toCharArray();

                    // Satırın sütun sayısına kadar veriyi kopyala
                    for (int j = 0; j < Math.min(10, charArray.length); j++) {
                        veriDizisi[i][j] = Character.toString(charArray[j]);
                    }
                }
            }

            for (int i = 0; i < 10; i++) { // Haritayı ekrana yansıtma
                for (int j = 0; j < 10; j++) {
                    System.out.print(veriDizisi[i][j] + "\t");
                }
                System.out.println();
            }

            // Dosya yolunun yanlış girilmesi durumunda kullanıcıyı bilgilendirme
        } catch (FileNotFoundException e) {
            System.out.println("Dosya bulunamadı: " + dosyaYolu);
            e.printStackTrace();
        }

        Scanner koordinatGirdisi = new Scanner(System.in);
        System.out.println("Lütfen bir satir koordinatı giriniz!");
        int satirKoordinati = koordinatGirdisi.nextInt();
        System.out.println("Lütfen bir sütun koordinatı giriniz!");
        int sutunKoordinati = koordinatGirdisi.nextInt();

        if (satirKoordinati == 0 && sutunKoordinati == 0) {
            System.out.println("Oyun bitti, güle gülee!");
        } else {
            while (satirKoordinati != 0 || sutunKoordinati != 0) { // 0-0 girilmediği sürece oyun devam etsin.
                koordinattakiSayi = veriDizisi[satirKoordinati - 1][sutunKoordinati - 1]; // Hedef sayı
                kontrolMekanizmasi(satirKoordinati - 1, sutunKoordinati - 1); // Değişim işlemleri
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 10; j++) {
                        System.out.print(veriDizisi[i][j] + "\t");
                    }
                    System.out.println();
                }
                System.out.println("--------------------------------------");

                System.out.println("Lütfen bir satir koordinatı giriniz!");
                satirKoordinati = koordinatGirdisi.nextInt();
                System.out.println("Lütfen bir sütun koordinatı giriniz!");
                sutunKoordinati = koordinatGirdisi.nextInt();
            }
            System.out.println("Oyun bitti, güle gülee!");
        }
    }

    static void kontrolMekanizmasi(int satir, int sutun) { // Girilen koordinatın etrafını ve kendisini x'e çevirme
        if (satir - 1 >= 0) { // Harita kenarlarının dışına çıkmama kontrolü (Üst kenar)
            if (koordinattakiSayi.compareTo(veriDizisi[satir - 1][sutun]) == 0) { // Üstteki sayının kontrolü
                veriDizisi[satir][sutun] = "x";
                veriDizisi[satir - 1][sutun] = "x";

                kontrolMekanizmasi(satir - 1, sutun);// Üstte bulunan her sayı için 4 taraf kontrolü
            }
        }
        if (sutun - 1 >= 0) { // Harita kenarlarının dışına çıkmama kontrolü (Sol kenar)
            if (koordinattakiSayi.compareTo(veriDizisi[satir][sutun - 1]) == 0) { // Soldaki sayının kontrolü
                veriDizisi[satir][sutun] = "x";
                veriDizisi[satir][sutun - 1] = "x";

                kontrolMekanizmasi(satir, sutun - 1);// Solda bulunan her sayı için 4 taraf kontrolü
            }
        }
        if (satir + 1 <= 9) { // Harita kenarlarının dışına çıkmama kontrolü (Alt kenar)
            if (koordinattakiSayi.compareTo(veriDizisi[satir + 1][sutun]) == 0) { // Alttaki sayının kontrolü
                veriDizisi[satir][sutun] = "x";
                veriDizisi[satir + 1][sutun] = "x";

                kontrolMekanizmasi(satir + 1, sutun);// Altta bulunan her sayı için 4 taraf kontrolü
            }
        }
        if (sutun + 1 <= 9) { // Harita kenarlarının dışına çıkmama kontrolü (Sağ kenar)
            if (koordinattakiSayi.compareTo(veriDizisi[satir][sutun + 1]) == 0) { // Sağdaki sayının kontrolü
                veriDizisi[satir][sutun] = "x";
                veriDizisi[satir][sutun + 1] = "x";

                kontrolMekanizmasi(satir, sutun + 1);// Sağda bulunan her sayı için 4 taraf kontrolü
            }
        }
    }
}
