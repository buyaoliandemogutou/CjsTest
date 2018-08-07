package test;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base.AbstractBase;

public class DownAndLogin extends AbstractBase{
	@Test
	public void startPage() {
		  String url="http://testweb.cjs.com.cn/";
		  beforeClass(url);		  
	}
	
	@Test(dependsOnMethods="startPage")
	public void aboutUs(){
		clickElement(By.linkText("关于钱坤"));
		clickElement(By.linkText("风险教育"));		
		String expected="1、根据相关法律法规规定，本公司向投资者提供涉及证券及证券相关产品的投资建议服务，只是辅助投资者做出投资决策，证券市场具有较大的风险，投资顾问业务服务也存在风险，请您注意。";
		assertEquals(By.xpath("//*[@id='content9']/div[2]"), expected);
		
	}
	
	@Test(dependsOnMethods="startPage")
	public void downResources() throws InterruptedException{
		moveToElement(By.linkText("软件下载"));
		clickElement(By.linkText("财急送APP"));
		assertEquals("className", "tit", "手机扫码轻松下载");
		moveToElement(By.linkText("软件下载"));
		clickElement(By.linkText("财急送PC"));
		assertEquals("Xpath", "//*[@id='pc']/div[1]/div/div/div/span[1]", "新股民");
		}
	
	@Test(dependsOnMethods="startPage",dataProvider="nameData")
	public void login(String name,String pwd){
		loginT(name, pwd);
		visibilityOfelement(1, By.xpath("//*[@id='headerbox']/div/div[2]/a/div"));
		moveToElement(By.xpath("//*[@id='headerbox']/div/div[2]/a/div"));
		clickElement(By.linkText("退出登录"));
		clickElement(By.className("layui-layer-btn0"));		
	}
	
	@Test()
	public void editProfile(){
		loginT("18109045175", "123456");
		moveToElement(By.xpath("//*[@id='headerbox']/div/div[2]/a/div"));
		clickElement(By.linkText("我的资料"));
		clearAndSendkeys(By.id("user_nickname"), "");
	}
	
	
	public void loginT(String name,String pwd){
		clickElement(By.className("land"));
		clearAndSendkeys(By.id("username"),name);
		clearAndSendkeys(By.id("password"),pwd);
		clickElement(By.id("goland"));
	}
	
	@DataProvider(name="nameData")
	public Object[][] name(){
		Object[][] name=new Object[][] {
			{"18109045175","123456"},{"18396879113","111111"}
		};
		return name;		
	}		
	
}
