package com.pfe.BabySitterPFE.services;

import com.pfe.BabySitterPFE.entities.PasswordResetToken;
import com.pfe.BabySitterPFE.entities.User;
import com.pfe.BabySitterPFE.repositories.PasswordResetTokenRepository;
import com.pfe.BabySitterPFE.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordResetService {
    private final PasswordResetTokenRepository tokenRepository;
    private final JavaMailSender mailSender;
    private final UserRepository userRepository;


    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken resetToken = new PasswordResetToken();
        resetToken.setUser(user);
        resetToken.setToken(token);
        resetToken.setExpiryDate(calculateExpiryDate(24));
        tokenRepository.save(resetToken);
    }
    public Date calculateExpiryDate(int expiryTimeInHours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.HOUR, expiryTimeInHours); // Add 24 hours to the current time
        return new Date(calendar.getTime().getTime());
    }
    public void sendResetTokenEmail(String contextPath, Locale locale, String token, User user) {
        String url = contextPath + "/user/changePassword?id=" + user.getId() + "&token=" + token;
    }
    public String validatePasswordResetToken(String token) {
        PasswordResetToken passToken = tokenRepository.findByToken(token);
        // Check if the token is valid...
        // Return message or status accordingly
        return ";;;;;";
    }
    public Optional<User> getUserByPasswordResetToken(String token) {
        return Optional.ofNullable(tokenRepository.findByToken(token))
                .map(PasswordResetToken::getUser);
    }
}
