package com.example.entities.PO;

import lombok.Data;

/**
 * @author youngoo
 * @date 2021/12/13 16:46
 */
@Data
public class Pest {
    private Integer id;
    private String pestName;
    private String hostName;
    private String breed;
    private String enemy;
    private String damage;
    private String measures;
    private String childPicture;
    private String adultPicture;
}
