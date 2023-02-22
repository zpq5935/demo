package one.zpq.server;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import one.zpq.domain.User;

// @Path("/userService")//由于applicationContext.xml的address 配置重复.
@Produces("*/*") // 产生(可以省略,在具体方法中添加)
public interface IUserService {

	@POST // 保存操作
	@Path("/user")
	@Consumes({ "application/xml", "application/json" }) // 消耗(接受的数据格式,与accept对应)
	public void saveUser(User user);

	@PUT // 修改操作
	@Path("/user") // 方法的路径
	@Consumes({ "application/xml", "application/json" })
	public void updateUser(User user);

	@GET // 查询操作
	@Path("/user")
	@Produces({ "application/xml", "application/json" }) // 产生(返回数据的格式,与type相对应)
	public List<User> findAllUsers();

	@GET
	@Path("/user/{id}") // 方法路径+id的值
	@Consumes("application/xml")
	@Produces({ "application/xml", "application/json" })
	public User finUserById(@PathParam("id") Integer id);

	@DELETE // 删除操作
	@Path("/user/{id}")
	@Consumes("application/xml")
	public void deleteUser(@PathParam("id") Integer id);
}
