package com.hyc.OnlineBookManagement;

import com.hyc.onlineBookManagement.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OnlineBookManagementApplicationTests {

	@Test
	public void contextLoads() {
		System.out.println(new Date(System.currentTimeMillis()+360000));
	}

}
