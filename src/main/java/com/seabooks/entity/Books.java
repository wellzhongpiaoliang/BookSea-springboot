package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    private Integer bookId; // 书id
    private String bookName; // 书名
    private String publishDate; // 书籍出版日期
    private double bookPrice; // 书的价格
    private Integer bookStock; // 库存量
    private Integer bookCategory; // 分类id
    private String bookIntroduction; // 简介
    private String bookCoverimage; // 书的封面
    private double bookIsbn; // ISBN号
    private Integer bookPageNumber; // 书的页数
    private Integer bookNum; // 字数(单位:万)
    private Integer bookSales; // 书的销量
    private Integer bookScore; // 评分
    private Integer bookRead; // 点击量
    private Integer bookJurisdiction; // 是否免费阅读
    private String bookState; // 出版状态
    private Integer authorsId; // 作者id
    private String publishersId; // 出版社id
    private String bookEnd; // 是否完结
}
