package test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import base.AbstractBase;

public class CjsWebsite extends AbstractBase{	
	//打开财急送官网,验证菜单名是否正确
	  @Test
	  public void startPage() {
		  String url="http://testweb.cjs.com.cn/";
		  beforeClass(url);
		  assertEquals("XPath","//*[@id='headerbox']/div/div[2]/div[2]/span/a", "钱坤资讯");
	}
	  
	  //点击首页的按钮，检测是否跳转正确
	  @Test(dependsOnMethods="startPage")
	  public void homePage() throws InterruptedException {
		clickElement(By.cssSelector("body > div.pubclassbox > div > a"));
		assertEquals("cssSelector", "body > div.combatbox > div > div.titbox > div.pub_title", "基础实战");
		clickElement(By.xpath("//*[@id='headerbox']/div/div[2]/div[1]/span/a"));
		new WebDriverWait(driver, 2);
		clickElement(By.xpath("/html/body/div[6]/div/div[2]/div[1]/a"));
		assertEquals("Xpath", "/html/body/div[3]/ul/li[1]/a", "未来财经事件总览");
		clickElement(By.xpath("//*[@id='headerbox']/div/div[2]/div[1]/span/a"));
		clickElement(By.xpath("/html/body/div[7]/div/div[1]/div[1]/a"));
		assertEquals("className", "pub_title", "钱坤资讯");
		Thread.sleep(2000);
		clickElement(By.xpath("//*[@id='headerbox']/div/div[2]/div[1]/span/a"));		
		assertEquals("Xpath", "/html/body/div[4]/div/div/div[2]", "天才牛大的股市成功秘诀，全都传授与你");
		new WebDriverWait(driver, 2);
		clickElement(By.xpath("//*[@id='headerbox']/div/div[2]/div[1]/span/a"));	    
	    assertUrl("/html/body/div[8]/div/div[1]/div[2]/ul/li[1]/a", "http://ad.cjs.com.cn/template/html/79/5a93b6098ee79.html");	    
	    assertUrl("/html/body/div[8]/div/div[1]/div[2]/ul/li[2]/a", "http://ad.cjs.com.cn/template/html/58/5a9caa1000b58.html");	    
	    assertUrl("/html/body/div[8]/div/div[1]/div[2]/ul/li[3]/a", "http://ad.cjs.com.cn/template/html/59/5a9cdf21a1259.html");
	  }
}
