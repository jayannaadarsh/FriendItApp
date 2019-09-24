package com.friendit.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendit.bean.UserBean;
import com.friendit.dao.ForgotPasswordDao;
import com.friendit.services.ForgotPasswordService;
import com.friendit.utility.SendEmail;
import com.friendit.vo.EmailObject;

@Service
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

	@Autowired
	ForgotPasswordDao forgotpass;
	@Autowired
	SendEmail sendmail;

	@Override
	public boolean resetPassword(String email) {
		UserBean ub = forgotpass.getUserByEmail(email);
		if (ub.getEmail() == "") {
			return false;
		} else {
			String newpass = getPassword();
			ub.setPassword(newpass);
			String message = "Hi, this is your new password: " + newpass + "\nNote: for security reason, "
	                + "you must change your password after logging in.";
			EmailObject emailObj = new EmailObject(ub.getEmail(), "Your Password has been Reset", message);
			sendmail.sendNewPassword(emailObj);
			forgotpass.updateUSer(ub);
			
			return true;
		}
	}

	public String getPassword() {
		String temp = Long.toHexString(Double.doubleToLongBits(Math.random()));
		return temp;
	}

}
