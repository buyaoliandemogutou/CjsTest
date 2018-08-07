package test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.AbstractBase;

public class QkInformation extends AbstractBase{
	//打开钱坤资讯
	 @Test
	  public void startPage() {
		  String url="http://testweb.cjs.com.cn/information/index.html";
		  beforeClass(url);
		  assertEquals("className","pub_title", "钱坤资讯");		
		//判断打开乾坤资讯后默认展示财富早报的数据
			 boolean elementIs=driver.findElement(By.className("active")).findElement(By.xpath("//*[@id='navindex']/ul/li[1]/a")).isDisplayed();
			  Assert.assertEquals(true, elementIs);
	}
	 
	 //点击各子菜单查看
	 @Test(dependsOnMethods="startPage")
	 public void qkInformation(){		
//		 visibilityOfelement(2,By.id("navindex"));
		  clickElement(By.xpath("//*[@id='navindex']/ul/li[2]/a"));
		  visibilityOfelement(2, By.className("bot"));
		  assertEquals(By.className("#newsContent > li:nth-child(1) > a > div.cont > div.tit"), "早盘风向标");
		  driver.findElement(By.id("newsContent")).isDisplayed();
		  clickElement(By.xpath("//*[@id='navindex']/ul/li[3]/a"));
		  clickElement(By.xpath("//*[@id='navindex']/ul/li[4]/a"));
		  clickElement(By.xpath("//*[@id='navindex']/ul/li[5]/a"));
		  clickElement(By.xpath("//*[@id='navindex']/ul/li[6]/a"));		  
	 }	 
}
