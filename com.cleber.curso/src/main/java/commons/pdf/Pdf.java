package commons.pdf;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import commons.start.LocalVariables;
import commons.start.StartParameters;
import commons.utils.SelectImageReportSucessFail;

public class Pdf {
	public static void generatePdf(StartParameters sttp) {
		try {
		Document doc = new Document(PageSize.A4);
		OutputStream os = new FileOutputStream(sttp.getDir2() + "/" +  "adicionarcontato.pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		sttp.setDocPdf(doc);
		
		} catch(FileNotFoundException fnf) {
			System.out.println("Falha ao localizar arquivo ou diretorio");
		} catch(DocumentException e) {
			System.out.println("Falha ao gerar pdf");
		}

}
	public static void addHeaderReport(StartParameters sttp) throws MalformedURLException, IOException, DocumentException {
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		boldFont.setColor(BaseColor.GREEN);
		
		String filename = sttp.getProp().getProperty("Logo");
		Image image = Image.getInstance(filename);
		image.getInstance(filename);
		image.scalePercent(200f);
		image.setAbsolutePosition(0, (float) (PageSize.A4.getHeight() - 20.0));
		System.out.println(image.getScaledHeight());
		sttp.getDocPdf().add(image);
		image.scaleToFit(100f, 200f);
		sttp.getDocPdf().add(image);
		sttp.getDocPdf().add(new Chunk("Taskit" + sttp.getDateNow(), boldFont));
		
	}
	
	public static void insertSummary(StartParameters sttp) throws MalformedURLException, IOException, DocumentException {
		Font changeFunctions = new Font(Font.FontFamily.TIMES_ROMAN, 8);
		Font changeFontImputs = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font changeNameProject = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
		Font noColor = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
		
		changeNameProject.setColor(BaseColor.GREEN);
		changeFontImputs.setColor(BaseColor.GREEN);
		noColor.setColor(BaseColor.WHITE);
		
		Paragraph nomeProjeto = new Paragraph(sttp.getProp().getProperty("nomeProjeto"), changeNameProject);
		Paragraph tst = new Paragraph(".", noColor);
		
		nomeProjeto.setSpacingBefore(50);
		nomeProjeto.setSpacingAfter(100);
		nomeProjeto.setAlignment(Element.ALIGN_CENTER);
		
		tst.setSpacingBefore(50);
		tst.setSpacingAfter(150);
		tst.setAlignment(Element.ALIGN_CENTER);
		
		PdfPTable table = new PdfPTable(1);
		table.setHorizontalAlignment(Element.ALIGN_LEFT);
		table.setWidthPercentage(60);
		table.setSpacingAfter(20);
		PdfPCell cell = new PdfPCell(new Phrase("Summary Execution: ", changeFontImputs));
		
		Image img = Image.getInstance(sttp.getProp().getProperty("Logo"));
		
		float scaler = ((sttp.getDocPdf().getPageSize().getWidth() - sttp.getDocPdf().leftMargin() - sttp.getDocPdf().rightMargin() - 0) / img.getWidth())*100;
		img.scalePercent(scaler);
		img.setAlignment(Element.ALIGN_CENTER);
		
		// Tabela
		
		table.setWidthPercentage(10);
		sttp.getDocPdf().add(table);
		
		cell.setBorder(PdfPCell.LEFT | PdfPCell.TOP | PdfPCell.BOTTOM | PdfPCell.RIGHT);
		cell.setBorderColor(BaseColor.GREEN);
		
		table.addCell(cell);
		table.setWidthPercentage(50);
		table.setSpacingAfter(20);
		
		sttp.getDocPdf().add(tst);
		sttp.getDocPdf().add(img);
		sttp.getDocPdf().add(nomeProjeto);
		
		sttp.getDocPdf().newPage();
		sttp.getDocPdf().add(table);
		
		}
	
	public static void insertDescriptionExecution(StartParameters sttp, LocalVariables lv) throws DocumentException {
		Font changeFontlbl = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font changeFonttxt = new Font(Font.FontFamily.TIMES_ROMAN,10);
		changeFontlbl.setColor(BaseColor.GREEN);
		
		Paragraph lblFieldRequirements = new Paragraph("Funcionalidade: ", changeFontlbl);
		Paragraph txtFieldRequirements = new Paragraph(lv.getStepsBdds()[0], changeFonttxt);
		
		Paragraph lblFieldTarget = new Paragraph("Cenario: ", changeFontlbl);
		Paragraph txtFieldTarget = new Paragraph((lv.getStepsBdds()[1]), changeFonttxt);
		Paragraph lblFieldNameTest = new Paragraph("Passo a passo: ", changeFontlbl);
		
		DottedLineSeparator dottedLine = new DottedLineSeparator();
		dottedLine.setLineColor(BaseColor.GREEN);
		
		lblFieldRequirements.setSpacingAfter(5);
		txtFieldRequirements.setSpacingAfter(5);
		lblFieldTarget.setSpacingAfter(5);
		txtFieldTarget.setSpacingAfter(5);
		lblFieldNameTest.setSpacingAfter(5);
		
		dottedLine.setOffset(-2);
		dottedLine.setGap(1f);
		lblFieldRequirements.add(dottedLine);
		lblFieldTarget.add(dottedLine);
		lblFieldNameTest.add(dottedLine);
		
		sttp.getDocPdf().add(lblFieldRequirements);
		sttp.getDocPdf().add(txtFieldRequirements);
		sttp.getDocPdf().add(lblFieldTarget);
		sttp.getDocPdf().add(txtFieldTarget);
		sttp.getDocPdf().add(lblFieldNameTest);
		
		Paragraph txtFieldNameTest = null;
		for(int i=2; i>lv.getStepsBdds().length;i++) {
			System.out.println(lv.getStepsBdds()[i]);
			txtFieldNameTest = new Paragraph((lv.getStepsBdds()[i]),changeFonttxt);
			txtFieldNameTest.setSpacingAfter(5);
			sttp.getDocPdf().add(txtFieldNameTest);
		}
		
		txtFieldNameTest.setSpacingAfter(80);
		
	}

	
	// Dados Dispositivo
	
	public static void insertDateMobileDescription(StartParameters sttp, Object lblFieldRequirements) throws MalformedURLException, IOException, DocumentException {
		Font changeFontlbl = new Font(Font.FontFamily.TIMES_ROMAN,12, Font.BOLD);
		Font changeFonttxt = new Font(Font.FontFamily.TIMES_ROMAN,10, Font.ITALIC);
		changeFontlbl.setColor(BaseColor.GREEN);
		
		Paragraph lblFontRequirements = new Paragraph("Dados do Dispositivo: ", changeFontlbl);
		Paragraph deviceName = new Paragraph(Font.BOLD, "Nome do Dispositivo: " + sttp.getProp().getProperty("deviceName"), changeFonttxt);
		Paragraph udId = new Paragraph("Id Dispositivo: " + sttp.getProp().getProperty("udId"),changeFonttxt);
		Paragraph platformName = new Paragraph("Plataforma: " + sttp.getProp().getProperty("platformName"), changeFonttxt);
		Paragraph platformVersion = new Paragraph("Versao Plataforma: " +sttp.getProp().getProperty("platformVersion"),changeFonttxt);
		Paragraph appPackage = new Paragraph("APK: " +sttp.getProp().getProperty("appPackage"),changeFonttxt);
		Paragraph appActivity = new Paragraph("Activity: " +sttp.getProp().getProperty("appActivity"),changeFonttxt);
		Paragraph automationName = new Paragraph("Engine: " +sttp.getProp().getProperty("automationName"),changeFonttxt);
		
		Image img = Image.getInstance("Logo");
		img.setAlignment(Image.RIGHT);
		img.scalePercent(10);
		lblFontRequirements.setSpacingBefore(30);
		lblFontRequirements.add(new Chunk(img, 0, 0));
		
		DottedLineSeparator dottedLine = new DottedLineSeparator();
		dottedLine.setLineColor(BaseColor.GREEN);
		
		lblFontRequirements.setSpacingAfter(13);
		deviceName.setSpacingAfter(1);
		udId.setSpacingAfter(1);
		platformName.setSpacingAfter(1);
		platformVersion.setSpacingAfter(1);
		appPackage.setSpacingAfter(1);
		appActivity.setSpacingAfter(1);
		automationName.setSpacingAfter(1);
		dottedLine.setOffset(-2);
		dottedLine.setGap(1f);
		((Document) lblFieldRequirements).add(dottedLine);
		
		sttp.getDocPdf().add((Element) lblFieldRequirements);
		sttp.getDocPdf().add(deviceName);
		sttp.getDocPdf().add(udId);
		sttp.getDocPdf().add(platformName);
		sttp.getDocPdf().add(platformVersion);
		sttp.getDocPdf().add(appPackage);
		sttp.getDocPdf().add(appActivity);
		sttp.getDocPdf().add(automationName);

		}
	
	public static void insertNameScreenExecution(StartParameters sttp, String nameScreen) throws MalformedURLException, IOException, DocumentException {
		Font changeFontlbl = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);
		Font changeFonttxt = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
		changeFontlbl.setColor(BaseColor.BLACK);
		
		Paragraph lblFieldRequirements = new Paragraph(nameScreen + "  ", changeFontlbl);
		
		lblFieldRequirements.setAlignment(Element.ALIGN_CENTER);
		PdfDocument pdfdoc = new PdfDocument();
		Image img = Image.getInstance("Logo");
		img.setAlignment(Image.RIGHT);
		img.scalePercent(10);
		
		// Notice the image added directly to the Paragraph
		
		lblFieldRequirements.setSpacingBefore(30);
		lblFieldRequirements.add(new Chunk(img, -70,-20));
		
		DottedLineSeparator dottedLine = new DottedLineSeparator();
		dottedLine.setLineColor(BaseColor.GREEN);
		
		lblFieldRequirements.setSpacingAfter(13);
		
		dottedLine.setOffset(-15);
		dottedLine.setGap(1f);
		lblFieldRequirements.add(dottedLine);
		sttp.getDocPdf().add(lblFieldRequirements);
		
		}
	
	public static void insertCheckPointExecution(StartParameters sttp) throws MalformedURLException, IOException, DocumentException {
		Font changeFontlbl = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font changeFonttxt = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
		changeFontlbl.setColor(BaseColor.GREEN);
		
		Paragraph lblFieldRequirements = new Paragraph("", changeFontlbl);
		lblFieldRequirements.setAlignment(Element.ALIGN_LEFT);
		
		Image img = Image.getInstance("Logo");
		img.setAlignment(Image.RIGHT);
		img.scalePercent(10);
		
		// Notice the image added directly to the Paragraph
		
		lblFieldRequirements.setSpacingBefore(50);
		lblFieldRequirements.add(new Chunk(img, 0,0));
		
		DottedLineSeparator dottedLine = new DottedLineSeparator();
		dottedLine.setLineColor(BaseColor.GREEN);
		
		lblFieldRequirements.setSpacingAfter(13);
		
		dottedLine.setOffset(-2);
		dottedLine.setGap(1f);
		lblFieldRequirements.add(dottedLine);
		sttp.getDocPdf().add(lblFieldRequirements);

		}
	
	public static void createParagraphEnter(StartParameters sttp, LocalVariables lv) throws MalformedURLException, IOException, DocumentException {
		PdfPCell cell = null, cell2 = null, cell3 = null;

		Font textBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
		Font text = new Font(Font.FontFamily.TIMES_ROMAN, 8);

		Font normal = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
		normal.setColor(BaseColor.BLACK);

		Font normal2 = new Font(Font.FontFamily.COURIER, 10, Font.BOLD);
		normal2.setColor(BaseColor.BLACK);

		PdfPTable tableInputs = new PdfPTable(new float[] { 0.20f, 0.70f, 0.10f });
		tableInputs.setWidthPercentage(100);
		tableInputs.setHorizontalAlignment(Element.ALIGN_LEFT);

		if (lv.getRobotElement().equals("Campos:")) {

			cell = new PdfPCell(new Paragraph(lv.getRobotElement(), normal));
			cell.setBackgroundColor(BaseColor.GRAY);
			cell.setColspan(1);
			cell.setBorderColor(BaseColor.GREEN);
			tableInputs.setSpacingBefore(50);
			tableInputs.addCell(cell);

			cell2 = new PdfPCell(new Paragraph("Ação: ", normal));
			cell2.setBackgroundColor(BaseColor.GRAY);
			cell2.setColspan(1);
			cell2.setBorderColor(BaseColor.GREEN);
			tableInputs.addCell(cell2);

			cell3 = new PdfPCell(new Paragraph("Status", normal2));
			cell3.setBackgroundColor(BaseColor.GRAY);
			cell3.setColspan(1);
			cell3.setBorderColor(BaseColor.GREEN);
			tableInputs.addCell(cell3);

		} else {

			cell = new PdfPCell(new Paragraph(lv.getRobotElement(), textBold));
			cell2 = new PdfPCell(new Paragraph(lv.getRobotValueField(), text));
			cell.setBorderColor(BaseColor.GREEN);
			cell2.setBorderColor(BaseColor.GREEN);

			// s verify status test
			String choiseImg = SelectImageReportSucessFail.selecImagePassError(sttp, lv);

			Image img = Image.getInstance(choiseImg);
			img.setAlignment(Element.ALIGN_CENTER);
			img.scalePercent(10);

			PdfPCell img3 = new PdfPCell();
			img3.addElement(new Chunk(img, 10, 0));
			
			img3.setBorderColor(BaseColor.GREEN);

			tableInputs.addCell(cell);
			tableInputs.addCell(cell2);
			tableInputs.addCell(img3);

		}
		sttp.getDocPdf().add(tableInputs);

	}	
	public static void tableTitlePage(StartParameters sttp) throws DocumentException {
		if(sttp.getDriver().getTitle().equals("")) {;
		System.out.println("Pagina nao contem titulo");
		
	}
	
	Font changeSourceDataEntered = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.BOLD);
	Paragraph descriptionPage = new Paragraph("Titulo da Pagina: " + sttp.getDriver().getTitle(),changeSourceDataEntered);
	Paragraph descriptionUrl = new Paragraph("URL: " + sttp.getDriver().getTitle(),changeSourceDataEntered);
	
	descriptionUrl.setSpacingAfter(20);
	sttp.getDocPdf().add(descriptionPage);
	sttp.getDocPdf().add(descriptionUrl);
	

	}
	
	public static void addReportImage(StartParameters sttp, LocalVariables lv) throws MalformedURLException, IOException, DocumentException {
		Font changeSubtitleImage = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.BOLD);
		
		PdfPTable tableImage = new PdfPTable(new float[] {0.100f});
		tableImage.setHorizontalAlignment(Element.ALIGN_CENTER);
		
		PdfPCell subTitlecell = new PdfPCell(new Paragraph(lv.getRobotMessage(), changeSubtitleImage));
		subTitlecell.setHorizontalAlignment(Element.ALIGN_CENTER);
		subTitlecell.setBorderColor(BaseColor.BLUE);
		
		tableImage.setSpacingBefore(20);
		
		Image img = Image.getInstance(lv.getPathEvidence());
		img.setAlignment(Image.ALIGN_CENTER);
		
		float scaler = ((sttp.getDocPdf().getPageSize().getWidth()-(sttp.getDocPdf().leftMargin()-(sttp.getDocPdf().rightMargin()-10) / img.getWidth())))*100;
		img.scalePercent(scaler);
		img.scaleToFit(170,470);
		
		// Notice the image added directly to the Paragraph
		
		PdfPCell cellImg = new PdfPCell(img,false);
		cellImg.setHorizontalAlignment(Element.ALIGN_CENTER);
		cellImg.setBorderColor(BaseColor.RED);
		tableImage.addCell(cellImg);
		tableImage.addCell(subTitlecell);
		sttp.getDocPdf().add(tableImage);
		sttp.getDocPdf().newPage();
		
		// Pdf.addHeader(sttp);

	}
	
	public static void addHeader(StartParameters sttp) throws MalformedURLException, IOException, DocumentException {
		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN,12,Font.BOLD);
		Font changeFont = new Font(Font.FontFamily.COURIER,12,Font.BOLD);
		changeFont.setColor(BaseColor.BLUE);
		
		Font normal = new Font(Font.FontFamily.COURIER,12,Font.BOLD);
		normal.setColor(BaseColor.BLUE);
		
        // Define a quantidade colunas cabeçalho
		
		PdfPTable tableHeader = new PdfPTable(new float[] {0.25f,0.20f,.025f,0.25f});
		Image img = Image.getInstance(sttp.getProp().getProperty("Logo"));
		img.setAlignment(Element.ALIGN_CENTER);
		img.scalePercent(65);
		float scaler = ((sttp.getDocPdf().getPageSize().getWidth()-sttp.getDocPdf().leftMargin()-sttp.getDocPdf().rightMargin()-30 / img.getWidth())*100);
		img.scalePercent(scaler);
		
		 // Insere imagem header arquivo Execução
		
		PdfPCell img3 = new PdfPCell();
		img3.addElement(img);
		img3.setBorderColor(BaseColor.GREEN);
		img3.setRowspan(5);
		img3.setHorizontalAlignment(Element.ALIGN_CENTER);
		img3.setVerticalAlignment(Element.ALIGN_CENTER);
		
		 // ######################################################
		
		PdfPCell header = new PdfPCell(new Paragraph("Evidencias de Teste Funcional: ", changeFont));
		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.WHITE);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setColspan(4);
		
		tableHeader.setSpacingBefore(20);
		
		PdfPCell lblSystem = new PdfPCell(new Paragraph("Sigla do Sistema/Tecnologia: ", normal));
		PdfPCell txtSystem = new PdfPCell(new Paragraph("Em Construção 2"));
		PdfPCell lblVersion = new PdfPCell(new Paragraph("ID Condição de Teste: ", normal));
		PdfPCell txtVersion = new PdfPCell(new Paragraph("Em Construção ", boldFont));
		PdfPCell lblCT = new PdfPCell(new Paragraph("CT", normal));
		PdfPCell txtCT = new PdfPCell(new Paragraph("nomeCT"));
		
		PdfPCell lblData = new PdfPCell(new Paragraph("Data", normal));
		PdfPCell txtData = new PdfPCell(new Paragraph(sttp.getDateExec));
		
		PdfPCell lblSO = new PdfPCell(new Paragraph("Sistema", normal));
		PdfPCell txtSO = new PdfPCell(new Paragraph(System.getProperty("os.name")));
		
		PdfPCell lblBrowser = new PdfPCell(new Paragraph("Browser", normal));
		PdfPCell txtBrowser = new PdfPCell(new Paragraph("Chrome"));
		
		PdfPCell lblBuild = new PdfPCell(new Paragraph("Build", normal));
		PdfPCell txtBuild = new PdfPCell(new Paragraph("v1.01.p"));
		
		PdfPCell lblAmbiente = new PdfPCell(new Paragraph("Ambiente", normal));
		PdfPCell txtAmbiente = new PdfPCell(new Paragraph("Homolog"));
		
		PdfPCell lblExecutor = new PdfPCell(new Paragraph("Executor", normal));
		PdfPCell txtExecutor = new PdfPCell(new Paragraph(System.getProperty("user.name")));
		
		lblSystem.setBorderColor(BaseColor.BLUE);
		lblSystem.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSystem.setBorderColor(BaseColor.BLUE);
		
		lblVersion.setBorderColor(BaseColor.BLUE);
		lblVersion.setHorizontalAlignment(Element.ALIGN_TOP);
		txtVersion.setBorderColor(BaseColor.BLUE);
		
		lblCT.setBorderColor(BaseColor.BLUE);
		lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		txtCT.setBorderColor(BaseColor.BLUE);
		
		lblExecutor.setBorderColor(BaseColor.BLUE);
		lblExecutor.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutor.setBorderColor(BaseColor.BLUE);
		
		lblData.setBorderColor(BaseColor.BLUE);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(BaseColor.BLUE);
		
		lblSO.setBorderColor(BaseColor.BLUE);
		lblSO.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSO.setBorderColor(BaseColor.BLUE);
		
		lblBrowser.setBorderColor(BaseColor.BLUE);
		lblBrowser.setHorizontalAlignment(Element.ALIGN_TOP);
		txtBrowser.setBorderColor(BaseColor.BLUE);
		
		lblBuild.setBorderColor(BaseColor.BLUE);
		lblBuild.setHorizontalAlignment(Element.ALIGN_TOP);
		txtBuild.setBorderColor(BaseColor.BLUE);
		
		lblAmbiente.setBorderColor(BaseColor.BLUE);
		lblAmbiente.setHorizontalAlignment(Element.ALIGN_TOP);
		txtAmbiente.setBorderColor(BaseColor.BLUE);
		
		// tableHeader.addCell(img3);
		
		tableHeader.addCell(header);
		tableHeader.addCell(lblSystem);
		tableHeader.addCell(txtSystem);
		tableHeader.addCell(lblVersion);
		tableHeader.addCell(txtVersion);
		
		// tableheader.addCell(lblCT);
        // tableheader.addCell(txtCT);
		
		tableHeader.addCell(lblExecutor);
		tableHeader.addCell(txtExecutor);
		tableHeader.addCell(lblData);
		tableHeader.addCell(txtData);
		tableHeader.addCell(lblSO);
		tableHeader.addCell(txtSO);
		tableHeader.addCell(lblBrowser);
		tableHeader.addCell(txtBrowser);
		tableHeader.addCell(lblBuild);
		tableHeader.addCell(txtBuild);
		tableHeader.addCell(lblAmbiente);
		tableHeader.addCell(txtAmbiente);
		
		tableHeader.setSpacingAfter(20);
		sttp.getDocPdf().add(tableHeader);

	}
	
}
