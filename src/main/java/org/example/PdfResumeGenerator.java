package org.example;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

import java.io.File;

public class PdfResumeGenerator {

    public void generateResume(Candidate candidate, String outputPath) {
        try {
            PdfWriter writer = new PdfWriter(outputPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // --- 1. ÜST BAŞLIK (2 Sütunlu Tablo: Solda Bilgiler %75, Sağda Fotoğraf %25) ---
            Table headerTable = new Table(UnitValue.createPercentArray(new float[]{75, 25}));
            headerTable.setWidth(UnitValue.createPercentValue(100));

            // Sol Sütun: İsim, Ünvan ve İletişim
            Cell infoCell = new Cell();
            infoCell.setBorder(Border.NO_BORDER);
            infoCell.add(new Paragraph(candidate.getFullName())
                    .setBold().setFontSize(22));
            infoCell.add(new Paragraph(candidate.getTitle())
                    .setItalic().setFontSize(13));
            infoCell.add(new Paragraph("\nE-posta: " + candidate.getEmail() +
                    "\nTelefon: " + candidate.getPhone())
                    .setFontSize(10));
            headerTable.addCell(infoCell);

            // Sağ Sütun: Sağa Dayalı, Daha Geniş Fotoğraf
            Cell photoCell = new Cell();
            photoCell.setBorder(Border.NO_BORDER);
            addProfilePhoto(photoCell, candidate.getPhotoPath());
            headerTable.addCell(photoCell);

            document.add(headerTable);

            // Ayırıcı çizgi
            document.add(new Paragraph("\n_____________________________________________________________________\n"));

            // --- 2. İŞ DENEYİMLERİ BÖLÜMÜ ---
            document.add(new Paragraph("\nIS DENEYIMI / WORK EXPERIENCE")
                    .setBold().setFontSize(13));

            for (WorkExperience exp : candidate.getExperiences()) {
                document.add(new Paragraph(exp.getPosition() + " - " + exp.getCompany())
                        .setBold().setFontSize(11));
                document.add(new Paragraph(exp.getDuration())
                        .setItalic().setFontSize(9));
                document.add(new Paragraph(exp.getDescription() + "\n")
                        .setFontSize(10));
            }

            document.close();
            System.out.println("Özgeçmiş başarıyla üretildi: " + outputPath);

        } catch (Exception e) {
            System.err.println("PDF oluşturulurken hata meydana geldi: " + e.getMessage());
        }
    }

    private void addProfilePhoto(Cell cell, String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                Image img = new Image(ImageDataFactory.create(path));
                img.setWidth(115);   // Fotoğraf genişletildi
                img.setHeight(130);  // Yükseklik orantılandı
                img.setHorizontalAlignment(HorizontalAlignment.RIGHT); // Sağa yaslandı
                cell.add(img);
            } else {
                System.out.println("Fotoğraf bulunamadı: " + path);
            }
        } catch (Exception e) {
            System.err.println("Fotoğraf uyarısı: " + e.getMessage());
        }
    }
}