package com.seabooks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movies {

  private Long id;
  private String title;
  private String director;
  private String actors;
  private String genr;
  private String duration;




}
