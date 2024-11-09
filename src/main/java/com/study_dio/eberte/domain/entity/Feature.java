package com.study_dio.eberte.domain.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tb_feature")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Feature extends BaseItem{
}
