package commons.actions;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.itextpdf.text.DocumentException;

import commons.pdf.Pdf;
import commons.start.LocalVariables;
import commons.start.StartParameters;

public class ExecutionAction {
	public static boolean executionAction(StartParameters sttp, LocalVariables lv)
			throws InterruptedException, MalformedURLException, IOException, DocumentException {

		if (lv.getIndentifiedType().equals("name")) {

			if (ValidateExistenceElement.verifyByName(sttp, lv)) {

				if (lv.getRobotAction().equals("sendKeys")) {
					sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute()))
							.sendKeys(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("click")) {
					sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute())).click();

				} else if (lv.getRobotAction().equals("select")) {
					WebElement element = sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute()));
					Select select = new Select(element);
					select.selectByVisibleText(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("getText")) {
					lv.setCaptureText(sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute())).getText());

				} else if (lv.getRobotAction().equals("clear")) {
					sttp.getDriver().findElement(By.name(lv.getRobotValueAttribute())).clear();

				}

				lv.setStatus("pass");
				Pdf.createParagraphEnter(sttp, lv);

			} else {
				lv.setStatus("erro");
				Pdf.createParagraphEnter(sttp, lv);
				Evidence.evidenceResult(sttp, lv);
				return false;

			}
		}
		
		//Id
		
		if (lv.getIndentifiedType().equals("id")) {

			if (ValidateExistenceElement.verifyById(sttp, lv)) {

				if (lv.getRobotAction().equals("sendKeys")) {
					sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute()))
							.sendKeys(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("click")) {
					sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute())).click();

				} else if (lv.getRobotAction().equals("select")) {
					WebElement element = sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute()));
					Select select = new Select(element);
					select.selectByVisibleText(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("getText")) {
					lv.setCaptureText(sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute())).getText());

				} else if (lv.getRobotAction().equals("clear")) {
					sttp.getDriver().findElement(By.id(lv.getRobotValueAttribute())).clear();

				}

				lv.setStatus("pass");
				Pdf.createParagraphEnter(sttp, lv);

			} else {
				lv.setStatus("erro");
				Pdf.createParagraphEnter(sttp, lv);
				Evidence.evidenceResult(sttp, lv);
				return false;

			}
		}

		//LinkText

		if (lv.getIndentifiedType().equals("linkText")) {

			if (ValidateExistenceElement.verifyBylinkText(sttp, lv)) {

				if (lv.getRobotAction().equals("sendKeys")) {
					sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute()))
							.sendKeys(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("click")) {
					sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute())).click();

				} else if (lv.getRobotAction().equals("select")) {
					WebElement element = sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute()));
					Select select = new Select(element);
					select.selectByVisibleText(lv.getRobotValueField());

				} else if (lv.getRobotAction().equals("getText")) {
					lv.setCaptureText(sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute())).getText());

				} else if (lv.getRobotAction().equals("clear")) {
					sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute())).clear();

				}

				lv.setStatus("pass");
				Pdf.createParagraphEnter(sttp, lv);

			} else {
				lv.setStatus("erro");
				Pdf.createParagraphEnter(sttp, lv);
				Evidence.evidenceResult(sttp, lv);
				return false;

			}
		}
		
		//PartialLinkText

				if (lv.getIndentifiedType().equals("partiallinktext")) {

					if (ValidateExistenceElement.verifyById(sttp, lv)) {

						if (lv.getRobotAction().equals("sendKeys")) {
							sttp.getDriver().findElement(By.partialLinkText(lv.getRobotValueAttribute()))
									.sendKeys(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("click")) {
							sttp.getDriver().findElement(By.partialLinkText(lv.getRobotValueAttribute())).click();

						} else if (lv.getRobotAction().equals("select")) {
							WebElement element = sttp.getDriver().findElement(By.partialLinkText(lv.getRobotValueAttribute()));
							Select select = new Select(element);
							select.selectByVisibleText(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("getText")) {
							lv.setCaptureText(sttp.getDriver().findElement(By.partialLinkText(lv.getRobotValueAttribute())).getText());

						} else if (lv.getRobotAction().equals("clear")) {
							sttp.getDriver().findElement(By.linkText(lv.getRobotValueAttribute())).clear();

						}

						lv.setStatus("pass");
						Pdf.createParagraphEnter(sttp, lv);

					} else {
						lv.setStatus("erro");
						Pdf.createParagraphEnter(sttp, lv);
						Evidence.evidenceResult(sttp, lv);
						return false;

					}
				}
				
			//TagName

				if (lv.getIndentifiedType().equals("tagname")) {

					if (ValidateExistenceElement.verifyById(sttp, lv)) {

						if (lv.getRobotAction().equals("sendKeys")) {
							sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute()))
									.sendKeys(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("click")) {
							sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute())).click();

						} else if (lv.getRobotAction().equals("select")) {
							WebElement element = sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute()));
							Select select = new Select(element);
							select.selectByVisibleText(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("getText")) {
							lv.setCaptureText(sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute())).getText());

						} else if (lv.getRobotAction().equals("clear")) {
							sttp.getDriver().findElement(By.tagName(lv.getRobotValueAttribute())).clear();

						}

						lv.setStatus("pass");
						Pdf.createParagraphEnter(sttp, lv);

					} else {
						lv.setStatus("erro");
						Pdf.createParagraphEnter(sttp, lv);
						Evidence.evidenceResult(sttp, lv);
						return false;
					}
				}

				//XPath

				if (lv.getIndentifiedType().equals("xpath")) {

					if (ValidateExistenceElement.verifyByxpath(sttp, lv)) {

						if (lv.getRobotAction().equals("sendKeys")) {
							sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute()))
									.sendKeys(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("click")) {
							sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute())).click();

						} else if (lv.getRobotAction().equals("select")) {
							WebElement element = sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute()));
							Select select = new Select(element);
							select.selectByVisibleText(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("getText")) {
							lv.setCaptureText(sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute())).getText());

						} else if (lv.getRobotAction().equals("clear")) {
							sttp.getDriver().findElement(By.xpath(lv.getRobotValueAttribute())).clear();

						}

						lv.setStatus("pass");
						Pdf.createParagraphEnter(sttp, lv);

					} else {
						lv.setStatus("erro");
						Pdf.createParagraphEnter(sttp, lv);
						Evidence.evidenceResult(sttp, lv);
						return false;
					}
				}
				
				//CSS

				if (lv.getIndentifiedType().equals("css")) {

					if (ValidateExistenceElement.verifyByCss(sttp, lv)) {

						if (lv.getRobotAction().equals("sendKeys")) {
							sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute()))
									.sendKeys(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("click")) {
							sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute())).click();

						} else if (lv.getRobotAction().equals("select")) {
							WebElement element = sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute()));
							Select select = new Select(element);
							select.selectByVisibleText(lv.getRobotValueField());

						} else if (lv.getRobotAction().equals("getText")) {
							lv.setCaptureText(sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute())).getText());

						} else if (lv.getRobotAction().equals("clear")) {
							sttp.getDriver().findElement(By.cssSelector(lv.getRobotValueAttribute())).clear();

						}

						lv.setStatus("pass");
						Pdf.createParagraphEnter(sttp, lv);
						Evidence.evidenceResult(sttp, lv);

					} else {
						lv.setStatus("erro");
						Pdf.createParagraphEnter(sttp, lv);
						Evidence.evidenceResult(sttp, lv);
						return false;
					}
				}


				
					

		return true;
		}
	}

										
				
	

	



