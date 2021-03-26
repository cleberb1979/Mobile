package commons.start;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.opencsv.CSVReader;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class StartParameters {
	private AndroidDriver<MobileElement> driver;
	
	private CSVReader reader;
	
	private File dir;
	
	private File dir2;
	
	private String dateNow;
	
	private Properties prop;
	
	private Document docPdf;
	
	private String[] tableLine;
	
	private boolean condition;

	public Chunk getDateExec;
	
	public boolean firstLine;
	
	public DesiredCapabilities capabilities;
	
	public URL urlAppiumServer;
	
	
	public URL getUrlAppiumServer() {
		return urlAppiumServer;
	}

	public void setUrlAppiumServer(URL urlAppiumServer) {
		this.urlAppiumServer = urlAppiumServer;
	}

	public DesiredCapabilities getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(DesiredCapabilities capabilities) {
		this.capabilities = capabilities;
	}

	public boolean getFirstLine() {
		return firstLine;
	}

	public void setFirstLine(boolean firstLine) {
		this.firstLine = firstLine;
	}

	public boolean getCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}

	public String[] getTableLine() {
		return tableLine;
	}

	public void setTableLine(String[] tableLine) {
		this.tableLine = tableLine;
	}

	public Document getDocPdf() {
		return docPdf;
	}

	public void setDocPdf(Document docPdf) {
		this.docPdf = docPdf;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}

	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}

	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}

	public String getDateNow() {
		return dateNow;
	}

	public void setDateNow(String dateNow) {
		this.dateNow = dateNow;
	}

	public File getDir() {
		return dir;
	}

	public void setDir(File dir) {
		this.dir = dir;
	}

	public File getDir2() {
		return dir2;
	}

	public void setDir2(File dir2) {
		this.dir2 = dir2;
	}

	public CSVReader getReader() {
		return reader;
	}

	public void setReader(CSVReader reader) {
		this.reader = reader;
	}

	
	
	
	
	
	
	

}
