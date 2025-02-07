package com.eems.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eems.utility.EmailUtil;

@Service
public class NotificationService {
    private final EmailUtil emailUtil;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public NotificationService(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    public void sendApprovalNotification(String recipientEmail, String status) {
        String subject = "Expense Approval Status";
        String message = "Your expense has been " + status.toLowerCase() + ".";

        emailUtil.sendEmail(senderEmail, recipientEmail, subject, message);
    }

	public ResponseEntity<String> sendNotification(Long userId, String message) {
		// TODO Auto-generated method stub
		return null;
	}
}
