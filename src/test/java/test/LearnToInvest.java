package test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.AbstractBase;

public class LearnToInvest extends AbstractBase{
	@Test
	  public void startPage() {
		  String url="http://testweb.cjs.com.cn/";
		  beforeClass(url);		  
	}
	
	@Test(dependsOnMethods="startPage")
	public void publicSource(){
		clickElement(By.linkText("投资学堂"));
		System.out.println(driver.findElement(By.className("pub_title")).isDisplayed());
		moveToElement(By.linkText("投资学堂"));
		clickElement(By.linkText("公开课"));
		assertEquals("className", "pub_title", "投资学堂 · 公开课");
	}
	
	@Test(dependsOnMethods="startPage")
	public void baseSource(){
		moveToElement(By.linkText("投资学堂"));
		clickElement(By.linkText("基础课"));
		assertEquals("className", "pub_title", "投资学堂 · 基础课");
	}
	
}
