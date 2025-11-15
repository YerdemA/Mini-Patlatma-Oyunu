# Mini-Patlatma-Oyunu
Bu proje, **Yazılım Mühendisliği Algoritma ve Programlama** dersi kapsamında geliştirilmiş basit bir konsol oyunudur.
Haritadan koordinat seçerek, seçtiğiniz sayı ve o sayı ile bağlantılı olan (yukarı, aşağı, sol, sağ) tüm aynı sayıları patlattığınız ('x' ile değiştirdiğiniz) bir oyundur.

## ✨ Özellikler

* **10x10 Harita:** Oyun, 10x10'luk bir matris üzerinde oynanır.
* **Harici Dosyadan Okuma:** Oyun haritası, kullanıcı tarafından yolu belirtilen bir `.txt` dosyasından okunur.
* **Rekürsif (Özyineli) Patlatma:** Seçilen koordinattaki sayıya bitişik (yukarı, aşağı, sol, sağ) olan tüm aynı sayılar özyineli bir şekilde bulunur ve 'x' karakteri ile değiştirilir.
* **Dinamik Oyun Alanı:** Her hamleden sonra haritanın güncel hali konsola yazdırılır.
* **Basit Kontrol:** Kullanıcı `0` ve `0` koordinatlarını girerek oyundan çıkış yapabilir.

## 🚀 Nasıl Kullanılır?
Bu projeyi çalıştırmak için sisteminizde Java Geliştirme Kiti'nin (JDK) yüklü olması gerekmektedir.

### 1. Harita Dosyasını Hazırlayın
Oyunun çalışması için 10 satır ve 10 sütundan oluşan sayıları içeren bir `.txt` dosyasına ihtiyacı vardır.
Örneğin, `harita.txt` adında bir dosya oluşturun ve içine aşağıdakine benzer bir harita ekleyin:
```txt
1 2 3 4 5 6 7 8 9 1
2 2 2 4 5 6 7 8 9 1
1 2 1 1 1 6 7 8 9 1
1 2 3 4 5 6 7 8 9 1
1 3 3 3 5 6 7 8 9 1
1 2 3 4 5 6 7 8 9 1
6 6 6 6 6 6 7 8 9 1
1 2 3 4 5 6 7 8 9 1
1 2 3 4 5 6 7 8 9 1
1 2 3 4 5 6 7 8 9 9
```

### 2. Projeyi Derleyin ve Çalıştırın
Projeyi klonladıktan veya indirdikten sonra, BomBom klasörünün bulunduğu dizine terminal (komut satırı) üzerinden gidin.
BomBom.java dosyasını derleyin:

Bash
```
javac BomBom/BomBom.java
```
Derlenen programı çalıştırın:
Bash
```
java BomBom.BomBom
```
🧠 Çalışma Mantığı
Programın ana patlatma mantığı kontrolMekanizmasi adlı rekürsif (özyineli) fonksiyonda yer alır.

Kullanıcının girdiği koordinattaki sayı (hedef sayı) bir değişkene atanır.

kontrolMekanizmasi fonksiyonu, aldığı koordinatın üst, alt, sol ve sağ komşularını kontrol eder.

Eğer bir komşu, hedef sayı ile aynıysa, hem mevcut koordinatın hem de komşu koordinatın değeri 'x' olarak değiştirilir.

Fonksiyon, bu kez 'x' olarak değiştirilen yeni komşu için kendini tekrar çağırır.

Bu işlem, hedef sayıya bağlı ve bitişik başka komşu kalmayana kadar (veya harita sınırlarına ulaşana kadar) devam eder. Bu işleme "Flood Fill" (Taşma Dolgusu) algoritmasının basit bir uygulaması denir.
