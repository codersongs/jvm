package com.codersongs.vmstudy.agent;



/**
 * -javaagent d:/ja.jar
 * 
 * -javaagent:d:/jat.jar=argument
 * @author Administrator
 *
 */
public class RunAccountMain {
	 public static void main(String[] args) { 
		 Account account = new Account();
		 account.operation(); 
	 } 
}
