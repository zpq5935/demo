package one.zpq.springbootdemo.domain;

import lombok.Data;

@Data
public class Customer {
    private Integer id;

    private String account;

    private String password;

    private String qq;

    private String email;

    private String mobile;

    private String nickname;

    private String onelevelAddress;

    private String detailedAddress;

    private Boolean isdeleted;


}