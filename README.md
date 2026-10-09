# Pdf-resume-generator
​Java ve iText 7 ile gelistirilmis OOP tabanli PDF Ozgecmis Olusturucu
# PDF Resume Generator (Java & iText 7)

Bu proje, Nesneye Yönelik Programlama (OOP) prensipleri kullanılarak terminal üzerinden yapılandırılmış, profil fotoğraflı ve iş deneyimi içeren bir CV/Özgeçmiş PDF belgesi üreten konsol uygulamasıdır.

## Kullanılan Teknolojiler
- **Java 17+**
- **Maven** (Bağımlılık Yönetimi)
- **iText 7 Core** (PDF Çizim ve Yerleşim Kütüphanesi)

## Sınıf Mimarisi ve OOP Bileşenleri

Projede Single Responsibility (Tek Sorumluluk) ve Encapsulation (Kapsülleme) ilkelerine bağlı kalınarak PDF üretim mantığı `main` sınıfından tamamen ayrıştırılmıştır:

1. **`Candidate` (Model):** Adayın ad-soyad, unvan, e-posta, telefon ve profil fotoğrafı dosya yolu gibi kişisel verilerini saklar. Deneyim nesnelerini bir liste (`List<WorkExperience>`) yapısında tutar.
2. **`WorkExperience` (Model):** Çalışılan kurum, unvan, çalışma süresi ve görev tanımlarını temsil eden veri modelidir.
3. **`PdfResumeGenerator` (Servis):** Model nesnelerini (`Candidate`) girdi olarak alarak iText 7 motoru üzerinden `Table`, `Cell`, `Paragraph` ve `Image` nesneleriyle 2 sütunlu modern bir PDF belgesi derler ve kaydeder.
4. **`Main` (Başlatıcı):** Model nesnelerini örnekler (instantiate eder) ve PDF üretim sürecini tetikler.

## Çalıştırma Adımları
1. Projeyi bir Java IDE'sinde (IntelliJ IDEA, Eclipse vb.) Maven projesi olarak açın.
2. Bağımlılıkların (`pom.xml`) yüklenmesini bekleyin.
3. Kök dizinde `profile.png` dosyasının bulunduğundan emin olun.
4. `Main.java` dosyasını çalıştırın. Çıktı kök dizine `Ozgecmis.pdf` olarak kaydedilecektir.
5.
