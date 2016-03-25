package netgloo;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import eu.epitech.epilike.thrift.EpiLikeService;
import eu.epitech.epilike.thrift.LoginForm;
import netgloo.models.User;
import netgloo.models.UserDao;

@Controller
public class EpiLikeServiceImpl implements EpiLikeService.Iface {

	@Autowired
	private UserDao userDao;

	@Override
	public boolean login(LoginForm form) throws TException {
		User user = userDao.getByEmail(form.getLogin());
		return user != null && user.getPassword().equals(form.getPassword());
	}
}
