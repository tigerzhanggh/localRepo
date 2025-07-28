package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1. @description: 钥匙对
 * 2. @author: xh
 * 3. @time: 2022/3/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SMKeyPair {
    //私钥
    private String priKey;
    //公钥
    private String pubKey;

}
