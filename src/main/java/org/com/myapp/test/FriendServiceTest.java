package org.com.myapp.test;
import java.util.List;

import org.com.myapp.model.UserProfile;
import org.com.myapp.service.FriendService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FriendServiceTest {
	//public static Logger log=Logger.getLogger(FriendServiceTest.class);
	public static void main(String[]args){
		ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("spring4.xml");
		//log.info("spring bean ok");
		FriendService friendService =(FriendService) context.getBean("friendService");
		List<UserProfile> list=friendService.findListFriendById(1);
		
		if(list==null){
			
		}else{
			for(UserProfile up:list){
				System.out.println("Friend list::"+up);
			}
			
		}
		
		
		
	}
	
}
