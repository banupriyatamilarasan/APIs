package com.omrbranch1.pojo.login;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor

public class Login_Output_Pojo {

        private int status;
        private String message;
        private Data data;
        private String refer_msg;
        private int cart_count;
        private String role;
	}



