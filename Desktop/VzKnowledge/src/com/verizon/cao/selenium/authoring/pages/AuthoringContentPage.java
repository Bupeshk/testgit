package com.verizon.cao.selenium.authoring.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.verizon.cao.selenium.common.ObjectRepository.Authoring;

public class AuthoringContentPage implements Authoring {
	
	private static WebElement element = null;
	static String object_path = null;
	
	public static WebElement elenewcontent(WebDriver driver)
	{
		element = driver.findElement(By.xpath(elenewcontent));

		return element;

	}
	public static WebElement chckrole(WebDriver driver)
	{
		element = driver.findElement(By.xpath(chckrole));

		return element;

	}
	public static WebElement btncontinue(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btncontinue));

		return element;

	}
	public static WebElement txtboxtitle(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtboxtitle));

		return element;

	}
	public static WebElement txtdescription(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtdescription));

		return element;

	}
	public static WebElement txtkeyword(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtkeyword));

		return element;

	}
	public static WebElement selectcategory(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectcategory));

		return element;

	}
	public static WebElement selectheadertype(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectheadertype));

		return element;

	}
	public static WebElement selectheaderclassification(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectheaderclassification));

		return element;

	}
	public static WebElement txtauthornote(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtauthornote));

		return element;

	}
	public static WebElement btnaddRegion(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnaddRegion));

		return element;

	}
	public static WebElement chckregion(WebDriver driver)
	{
		element = driver.findElement(By.xpath(chckregion));

		return element;

	}
	public static WebElement btnsubmit(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnsubmit));

		return element;

	}
	public static WebElement btncontinuenxt(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btncontinuenxt));

		return element;

	}
	public static WebElement selectworkflow(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectworkflow));

		return element;

	}
	public static WebElement txtURL(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtURL));

		return element;

	}
	public static WebElement btnsave(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnsave));

		return element;

	}
	public static WebElement eleverify(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleverify));

		return element;

	}
	public static WebElement btnviewdetails(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnviewdetails));

		return element;

	}
	public static WebElement btngotofolder(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btngotofolder));

		return element;

	}
	public static WebElement btncheckinsimilar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btncheckinsimilar));

		return element;

	}
	public static WebElement chckcontent(WebDriver driver)
	{
		element = driver.findElement(By.xpath(chckcontent));

		return element;

	}
	public static WebElement btnclose(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnclose));

		return element;

	}
	public static WebElement mouseover(WebDriver driver)
	{
		element = driver.findElement(By.xpath(mouseover));

		return element;

	}
	public static WebElement UnArchive(WebDriver driver)
	{
		element = driver.findElement(By.xpath(UnArchive));

		return element;

	}
	public static WebElement RevisionHistory(WebDriver driver)
	{
		element = driver.findElement(By.xpath(RevisionHistory));

		return element;

	}
	public static WebElement eleRevisionHistory(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleRevisionHistory));

		return element;

	}
	public static WebElement CheckinSimilar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(CheckinSimilar));

		return element;

	}
	public static WebElement CheckOut(WebDriver driver)
	{
		element = driver.findElement(By.xpath(CheckOut));

		return element;

	}
	public static WebElement lnkcontent(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkcontent));

		return element;

	}
	public static WebElement lnkaddfavorites(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkaddfavorites));

		return element;

	}
	public static WebElement lnkremovefavorites(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkremovefavorites));

		return element;

	}
	public static WebElement lnkViewAuditTrail(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkViewAuditTrail));

		return element;

	}
	public static WebElement eleAuditTrail(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleAuditTrail));

		return element;

	}
	public static WebElement btnprevious(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnprevious));

		return element;

	}
	public static WebElement btnnext(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnnext));

		return element;

	}
	public static WebElement selectsearch(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectsearch));

		return element;

	}
	public static WebElement txtsearch(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtsearch));

		return element;

	}
	public static WebElement buttonsearch(WebDriver driver)
	{
		element = driver.findElement(By.xpath(buttonsearch));

		return element;

	}
	public static WebElement verifyresult(WebDriver driver)
	{
		element = driver.findElement(By.xpath(verifyresult));

		return element;

	}
	public static WebElement verifynorecord(WebDriver driver)
	{
		element = driver.findElement(By.xpath(verifynorecord));

		return element;

	}
	public static WebElement lnkAdvancedsearch(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkAdvancedsearch));

		return element;

	}
	public static WebElement txtsearchterm(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtsearchterm));

		return element;

	}
	public static WebElement selectcontenttype(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectcontenttype));

		return element;

	}
	public static WebElement btnSearchterm(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnSearchterm));

		return element;

	}
	public static WebElement radiocustom(WebDriver driver)
	{
		element = driver.findElement(By.xpath(radiocustom));

		return element;

	}
	public static WebElement selectcustomtitle(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectcustomtitle));

		return element;

	}
	public static WebElement txttitle(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txttitle));

		return element;

	}
	public static WebElement chooseeditor(WebDriver driver)
	{
		element = driver.findElement(By.xpath(chooseeditor));

		return element;

	}
	public static WebElement authoring_frame(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_frame));

		return element;

	}
	public static WebElement authoring_body_desc(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_body_desc));

		return element;

	}
	public static WebElement authoring_set_date(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_set_date));

		return element;

	}
	public static WebElement authoring_clk_next(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_clk_next));

		return element;

	}
	public static WebElement authoring_valid_date(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_valid_date));

		return element;

	}
	public static WebElement folderAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderAlert));

		return element;

	}
	public static WebElement authoring_break_yes(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_break_yes));

		return element;

	}
	public static WebElement authoring_effect_date(WebDriver driver)
	{
		element = driver.findElement(By.xpath(authoring_effect_date));

		return element;

	}
	public static WebElement selectAlertType(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectAlertType));

		return element;

	}
	public static WebElement eleverifyAlert(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleverifyAlert));

		return element;

	}
	public static WebElement folderNews(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderNews));

		return element;

	}
	public static WebElement eleverifyNews(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleverifyNews));

		return element;

	}
	public static WebElement folderCalendar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderCalendar));

		return element;

	}
	public static WebElement selecttimezone(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selecttimezone));

		return element;

	}
	public static WebElement eleverifyCalendar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleverifyCalendar));

		return element;

	}
	public static WebElement folderContacts(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderContacts));

		return element;

	}
	public static WebElement txtEmailID(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtEmailID));

		return element;

	}
	public static WebElement txtPhone(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtPhone));

		return element;

	}
	public static WebElement ChooseCategory(WebDriver driver)
	{
		element = driver.findElement(By.xpath(ChooseCategory));

		return element;

	}
	public static WebElement folderFAQ(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderFAQ));

		return element;

	}
	public static WebElement folderGlossary(WebDriver driver)
	{
		element = driver.findElement(By.xpath(folderGlossary));

		return element;

	}
	public static WebElement HeaderAdmin(WebDriver driver)
	{
		element = driver.findElement(By.xpath(HeaderAdmin));

		return element;

	}
	public static WebElement HeaderHelp(WebDriver driver)
	{
		element = driver.findElement(By.xpath(HeaderHelp));

		return element;

	}
	public static WebElement eleHelpIssues(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleHelpIssues));

		return element;

	}
	public static WebElement eleAdministration(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleAdministration));

		return element;

	}
	public static WebElement lnkFAQ(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkFAQ));

		return element;

	}
	public static WebElement eleFAQ(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleFAQ));

		return element;

	}
	public static WebElement lnkGlossary(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkGlossary));

		return element;

	}
	public static WebElement lnkContacts(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkContacts));

		return element;

	}
	public static WebElement lnkCalendar(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkCalendar));

		return element;

	}
	public static WebElement lnkNews(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkNews));

		return element;

	}
	public static WebElement eleNews(WebDriver driver)
	{
		element = driver.findElement(By.xpath(eleNews));

		return element;

	}
	public static WebElement lnkMoveTaxonomy(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkMoveTaxonomy));

		return element;

	}
	public static WebElement chckAccountSupport(WebDriver driver)
	{
		element = driver.findElement(By.xpath(chckAccountSupport));

		return element;

	}
	public static WebElement lnkMassMetadata(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkMassMetadata));

		return element;

	}
	public static WebElement selectMetaData(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectMetaData));

		return element;

	}
	public static WebElement txtKeyword(WebDriver driver)
	{
		element = driver.findElement(By.xpath(txtKeyword));

		return element;

	}
	public static WebElement btnContinue(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnContinue));

		return element;

	}
	public static WebElement lnkUpdateRoles(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkUpdateRoles));

		return element;

	}
	public static WebElement lnkChangeOwner(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkChangeOwner));

		return element;

	}
	public static WebElement radioAuthor(WebDriver driver)
	{
		element = driver.findElement(By.xpath(radioAuthor));

		return element;

	}
	public static WebElement btnTransfer(WebDriver driver)
	{
		element = driver.findElement(By.xpath(btnTransfer));

		return element;

	}
	public static WebElement lnkBG(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkBG));

		return element;

	}
	public static WebElement lnkFinance(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkFinance));

		return element;

	}
	public static WebElement selectDocType(WebDriver driver)
	{
		element = driver.findElement(By.xpath(selectDocType));

		return element;

	}
	public static WebElement lnkNetworkTechnology(WebDriver driver)
	{
		element = driver.findElement(By.xpath(lnkNetworkTechnology));

		return element;

	}

}
