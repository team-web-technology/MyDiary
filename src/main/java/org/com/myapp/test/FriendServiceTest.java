package org.com.myapp.test;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.com.myapp.dao.FriendDAO;
import org.com.myapp.model.UserProfile;

public class FriendServiceTest {
	//public static Logger log=Logger.getLogger(FriendServiceTest.class);
	public static void main(String[]args){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring4.xml");
		//log.info("spring bean ok");
		FriendDAO friendDAO =(FriendDAO) context.getBean("friendDAO");
		List<UserProfile> list=friendDAO.findListFriendById(1);
		
		if(list==null){
			
		}else{
			for(UserProfile up:list){
				System.out.println("Friend list::"+up);
			}
			
		}
		
		
		
	}
	
}
