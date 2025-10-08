package com.dronacoderhub.client.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {
    private static final int EXPIRATION = 60 * 10;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private Date expirationTime;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false,
            foreignKey = @ForeignKey(name = "FK_USER_VERIFICATION_TOKEN"))
    private User user;

    public VerificationToken(String token, User user) {
        super();
        this.token = token;
        this.user = user;
        this.expirationTime = calculateExpirationDate(EXPIRATION);
    }
    public VerificationToken(String token) {
        super();
        this.token = token;
    }

    private Date calculateExpirationDate(int expiration) {
        Date date = new Date();
        date.setTime(date.getTime() + expiration * 1000);
        return date;
    }
}
