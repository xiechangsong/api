package main.java.com.shop.domain;

import lombok.*;

import java.io.Serializable;

/**
 * 放进redis中的对象，必须Serializable序列化
 * @author Jfei
 *
 */
@Data
public class User implements Serializable{
	private String id;
	private String userName;
}
