package com.sri.fileConversions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;





public class WordToPDFConverter {

	public static void main(String[] args) {
		System.out.println("Converting File...");
		long startTime = System.currentTimeMillis();
		WordToPDFConverter.convertWordToPDF("C:\\Biroji\\Resume\\Srinadh_Biroji_CV.docx","C:\\Ddrive\\Srinadh_Biroji_CV.pdf");
		long endTime = System.currentTimeMillis();
		long executionTime = Math.round((float)(endTime - startTime)/1000) ;
		System.out.println("Conversion Successfull !!" + "  Time taken for execution: "+ executionTime +"secs.");
	}  

	public static void convertWordToPDF(String inputFile,String outputFile){

		String k = null ;
		OutputStream fileForPdf =null;
		try {
			//Below Code is for .doc file 
			if(inputFile.endsWith(".doc"))
			{
				HWPFDocument doc = new HWPFDocument(new FileInputStream(inputFile));
				WordExtractor we=new WordExtractor(doc);
				k = we.getText();

				fileForPdf = new FileOutputStream(new File(outputFile)); 
				we.close();
			}

			//Below Code is for .docx file 

			else if(inputFile.endsWith(".docx"))
			{
				XWPFDocument docx = new XWPFDocument(new FileInputStream(inputFile));
				// using XWPFWordExtractor Class
				XWPFWordExtractor we = new XWPFWordExtractor(docx);
				k = we.getText();

				fileForPdf = new FileOutputStream(new File(outputFile));    
				we.close();
			}


			Document document = new Document();
			PdfWriter.getInstance(document, fileForPdf);

			document.open();

			document.add(new Paragraph(k));

			document.close();
			if(fileForPdf != null){
			fileForPdf.close();
			}


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
