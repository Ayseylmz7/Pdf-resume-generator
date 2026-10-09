package org.example;

public class Main {
    public static void main(String[] args) {
        Candidate candidate = new Candidate(
                "Ayse Yilmaz",
                "Yazilim Muhendisi",
                "ayseyilmaz25m@gmail.com",
                "+90 553 923 30 41",
                "profile.jpeg"
        );

        // 1. Deneyim: Mercedes-Benz (Ar-Ge & Sistem Yazılımı)
        candidate.addExperience(new WorkExperience(
                "Mercedes-Benz Turk A.S.",
                "Ar-Ge Yazilim Stajyeri",
                "Mart 2025 - Aralık 2026",
                "Arac ici telematik veri akisi ve baglantili arac sistemlerinde Java tabanli mikroservis optimizasyonlarinda gorev aldi."
        ));

        // 2. Deneyim: Beko (Akıllı Ev & Cihaz Otomasyonu)
        candidate.addExperience(new WorkExperience(
                "Beko Global",
                "IoT ve Cihaz Otomasyonu Stajyeri",
                "Aralık 2024 - Haziran 2025",
                "Akilli ev teknolojilerinde sensor verisi toplama ve cihazlar arasi iletisim otomasyonu protokollerinin test sureclerine katki sagladi."
        ));

        // 3. Deneyim: Microsoft (Bulut & Test Otomasyonu)
        candidate.addExperience(new WorkExperience(
                "Microsoft",
                "Bulut ve Surec Otomasyonu Stajyeri",
                "Eylul 2023 - Kasım 2024",
                "Azure Cloud ortamlari uzerinde CI/CD boru hatlari, script otomasyonlari ve uctan uca test senaryolarinin gelistirilmesinde gorev aldi."
        ));

        // PDF üretici servisini tetikleme
        PdfResumeGenerator generator = new PdfResumeGenerator();
        generator.generateResume(candidate, "Ozgecmis.pdf");
    }
}