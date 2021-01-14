package com.spring.provider;


 /**
 * @describe 方法试验,伪代码
 * @author lxc 
 */

public class FXNewsProvider {

	private IFXNewsListener newsListener; //模拟类 没有示例
	
	private IFXNewsPersister newPersistener;
	
	
	
	public FXNewsProvider() {
		
		//FXNewsProvider 依赖 newsListener 与 newPersistener 在构造函数种新建依赖
		
		newsListener = new DowJonesNewsListener();
		
		newPersistener = new DowJonesNewsPersister();
	}
	
	
	//IoC 模式注入依赖
	
	
	/**
	 * @describe 构造方法注入
	 * @author lxc 
	 * @date 2021年1月13日 下午5:34:02
	 * @version 1.0
	 * @param (参数)
	 * @return 
	 */
	public FXNewsProvider(IFXNewsListener newsListener,IFXNewsListener newsPersister) {
		
		this.newsListener = newsListener;
		
		this.newPersistener = newsPersister;
	}


	
	/**
	 * @describe setter 方法注入
	 * @author lxc 
	 * @date 2021年1月13日 下午5:34:49
	 * @version 1.0
	 * @param (参数)
	 * @return 
	 */
	public IFXNewsListener getNewsListener() {
		return newsListener;
	}


	public void setNewsListener(IFXNewsListener newsListener) {
		this.newsListener = newsListener;
	}


	public IFXNewsPersister getNewPersistener() {
		return newPersistener;
	}


	public void setNewPersistener(IFXNewsPersister newPersistener) {
		this.newPersistener = newPersistener;
	}
	
	
	
	
	
	
	
}
