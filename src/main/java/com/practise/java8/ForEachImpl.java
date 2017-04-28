package com.practise.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author Yashwanth
 *
 */
public class ForEachImpl {
 
 /**
  * 
  * @param args
  */
	public static void main(String[] args) {
	
		List<String> strList = new ArrayList<String>();
		for(int i=0;i<10;i++)
			strList.add(i+"");
		//System.out.println("JSE 5");
		implementForEachLoop(strList,5);
		
		//System.out.println("JSE 7");
		implementForEachLoop(strList,7);
		
		//System.out.println("JSE 8");
		implementForEachLoop(strList,8);
		
				
}
	
	
	/**
	 * 
	 * @param dataList
	 * @param JSEVersion
	 */
	@SuppressWarnings("unchecked")
	public static void implementForEachLoop(List dataList , int JSEVersion)
	{
		switch(JSEVersion){
		
		case 5:
			for(int i=0;i<dataList.size();i++)
				System.out.println("Object Value for JSE# V5="+dataList.get(i));
			break;
		case 6:
		case 7:
			for(Object obj : dataList)
				System.out.println("Object Value for JSE# V6/7="+obj.toString());
			break;
		case 8:
			dataList.forEach(new MyConsumer()); /*{
				public void accept(Object t) {
					System.out.println("forEach anonymous class Value::"+t.toString());
				}
			});*/
			
			break;
			
		}
			
		
	}
}

/**
 * 
 * @author Yashwanth
 *
 */
class MyConsumer implements Consumer<Object>
{

	@Override
	public void accept(Object arg0) {
		System.out.println("Object Value for JSE# V8="+arg0.toString());
		
	}
	
}
