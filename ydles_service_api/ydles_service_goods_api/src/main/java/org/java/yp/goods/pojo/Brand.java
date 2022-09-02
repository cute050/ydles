package org.java.yp.goods.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author 杨鹏
 * @version 1.0
 * Create by 2022/9/2 18:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_brand")
public class Brand implements Serializable {

    @Id
    private Integer id;
    private String name;
    private String image;
    private String letter;
    private Integer seq;

}
