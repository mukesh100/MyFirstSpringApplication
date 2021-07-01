package com.example.MyFirstProject;

import com.example.MyFirstProject.Entity.Students;
import com.example.MyFirstProject.Utils.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = MyFirstProjectApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyFirstProjectApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	private final HttpHeaders header=new HttpHeaders();

	@Test
	public void testGetStudent() throws Exception
	{
		ResponseEntity<Students> response=testRestTemplate.getForEntity(Constants.BASE + port + "/api/students/getByName/Shivam"
			, Students.class);
		Students responseBody=response.getBody();
		assert responseBody != null;
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(7L, responseBody.getId());
		assertEquals("Shivam", responseBody.getName());
		assertEquals("CSE", responseBody.getStream());
		assertEquals("Delhi", responseBody.getAddress());
		assertEquals("123450293", responseBody.getContact());

	}

	@Test
	public void testInsertStudent() throws Exception
	{
		Students student=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
		HttpEntity<Students > entity=new HttpEntity<>(student,header);
		ResponseEntity<Students > response=testRestTemplate.exchange(Constants.BASE+port+"/api/students/insertStudent"
			, HttpMethod.POST,entity,Students .class);
		Students  responseBody=response.getBody();
		assert responseBody != null;
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(student.getId(), responseBody.getId());
		assertEquals(student.getName(), responseBody.getName());
		assertEquals(student.getStream(), responseBody.getStream());
		assertEquals(student.getAddress(), responseBody.getAddress());
		assertEquals(student.getContact(), responseBody.getContact());
	}

	@Test
	public void testUpdateStudent() throws Exception
	{
		Students student=new Students(15L,"Rohit","CSE","MP","12345678", false ,LocalDateTime.now(),LocalDateTime.now());
		HttpEntity<Students> entity=new HttpEntity<>(student,header);
		ResponseEntity<Students> response=testRestTemplate.exchange(Constants.BASE+port+"/api/students/updateStudent/15"
			,HttpMethod.PUT,entity,Students.class);
		Students responseBody=response.getBody();
		assert responseBody != null;
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(student.getId(), responseBody.getId());
		assertEquals(student.getName(), responseBody.getName());
		assertEquals(student.getStream(), responseBody.getStream());
		assertEquals(student.getAddress(), responseBody.getAddress());
		assertEquals(student.getContact(), responseBody.getContact());
		assertEquals(student.getCreate_timestamp(), responseBody.getCreate_timestamp());
		System.out.println(responseBody);
	}

	@Test
	public void testDeleteStudentById() throws Exception
	{
		testRestTemplate.delete(Constants.BASE+port+"/api/Students/deleteStudentById/15");
	}

}

