package com.kevin.spring.security.postgresql.models;

public enum BookStatus {
    AVAILABLE, // 在庫
    BORROWED,    // 出借中
    Under_PREPARATION,  // 整理中
    LOST,   // 遺失
    DAMAGED,    // 損壞
    ABANDONED  // 廢棄
}
