package main.java.com.shop.controller.front;

import com.github.pagehelper.PageInfo;
import main.java.com.shop.domain.User;
import main.java.com.shop.enume.ResultEnum;
import main.java.com.shop.service.UserService;
import main.java.com.shop.utils.Result;
import main.java.com.shop.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello";
	}
	/**
	 * 测试插入
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	public String add(String id,String userName){
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		this.userService.insertUser(u);
		return u.getId()+"    " + u.getUserName();
	}
	
	/**
	 * 测试根据id查询
	 * @return
	 */
	@RequestMapping("/get/{id}")
	@ResponseBody
	public Result findById(@PathVariable("id")String id){
		User u = this.userService.findById(id);
		if( null == u) {
			return ResultUtil.ERROR(ResultEnum.RETURS_EMPTY.getCode(),ResultEnum.RETURS_EMPTY.getMsg());
		}
		return ResultUtil.SUCCESS(ResultEnum.SUCCESS,u);
	}
	
	
	/**
	 * 测试修改
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public String update(String id,String userName){
		User u = new User();
		u.setId(id);
		u.setUserName(userName);
		this.userService.updateUser(u);
		return u.getId()+"    " + u.getUserName();
	}
	
	/**
	 * 测试删除
	 * @return
	 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	public String delete(@PathVariable("id")String id){
		this.userService.deleteById(id);
		return "success";
	}
	
	/**
	 * 测试全部
	 * @return
	 */
	@RequestMapping("/deleteAll")
	@ResponseBody
	public String deleteAll(){
		this.userService.deleteAll();
		return "success";
	}
	
	
	
	/**
	 * 测试分页插件
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	public String queryPage(){
		PageInfo<User> page = this.userService.queryPage("tes", 1, 2);
		System.out.println("总页数=" + page.getPages());
		System.out.println("总记录数=" + page.getTotal()) ;
		for(User u : page.getList()){
			System.out.println(u.getId() + " \t " + u.getUserName());
		}
		return page.toString();
	}
}
