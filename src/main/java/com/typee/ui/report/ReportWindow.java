package com.typee.ui.report;

import java.io.IOException;
import java.util.logging.Logger;

import com.typee.commons.core.LogsCenter;
import com.typee.commons.util.PdfUtil;
import com.typee.ui.UiPart;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

/**
 * Controller class for Report Window.
 */
public class ReportWindow extends UiPart<Region> {
    public static final String FXML = "ReportWindow.fxml";
    private final Logger logger = LogsCenter.getLogger(getClass());
    private PdfUtil pdfUtil;

    @FXML
    private Label lblStatus;

    @FXML
    private Button btnTest;

    public ReportWindow() throws IOException {
        super(FXML);
        pdfUtil = new PdfUtil();
    }
}
