package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import base.AbstractBase;

public class ProductCenter extends AbstractBase{
	@Test
	  public void startPage() {
		  String url="http://testweb.cjs.com.cn/";
		  beforeClass(url);		  
	}
	@Test(dependsOnMethods="startPage")
	public void productCenter(){
		//clickElement(By.xpath("//*[@id='headerbox']/div/div[2]/div[3]/span/a"));
		//点击APP产品后打开APP下载页，验证下载页的文字
		moveToElement(By.linkText("产品中心"));		
		clickElement(By.linkText("我要购买"));	   
		clickElement(By.className("btn"));
		assertEquals("Xpath", "//*[@id='account']/div/div[2]/ul/li[1]/p[1]","户   名：四川省钱坤证券投资咨询有限公司");
		assertEquals("Xpath", "//*[@id='account']/div/div[2]/ul/li[1]/p[2]","开户行：中国建设银行成都高新支行");
		assertEquals("Xpath", "//*[@id='account']/div/div[2]/ul/li[1]/p[3]","账   号：5100 1406 1370 5152 6947");
		assertEquals("Xpath", "//*[@id='account']/div/div[2]/ul/li[1]/p[3]","行   号：1056 5100 7600");
		
	}	
}
