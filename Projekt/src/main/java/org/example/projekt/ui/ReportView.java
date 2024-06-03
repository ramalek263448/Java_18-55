package org.example.projekt.ui;

import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import jakarta.annotation.security.RolesAllowed;
import org.example.projekt.backend.Book;
import org.example.projekt.backend.BookService;
import org.vaadin.reports.PrintPreviewReport;

import javax.xml.transform.stream.StreamSource;

@Route("report")
@RolesAllowed("ADMIN")
public class ReportView extends VerticalLayout {

    public ReportView(BookService service){
        var report = new PrintPreviewReport<>(Book.class, "title", "published", "rating");
        report.setItems(service.findAll());
        report.getReportBuilder().setTitle("Report");

        StreamResource pdf = report.getStreamResource("books.pdf", () -> service.findAll(), PrintPreviewReport.Format.PDF);
        StreamResource csv = report.getStreamResource("books.pdf", () -> service.findAll(), PrintPreviewReport.Format.CSV);
        add(
                new HorizontalLayout(
                        new Anchor(pdf, "PDF"),
                        new Anchor(csv, "CSV")
                ),
                report

        );
    }


}
