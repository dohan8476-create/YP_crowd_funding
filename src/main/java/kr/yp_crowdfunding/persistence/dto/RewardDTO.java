package kr.yp_crowdfunding.persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RewardDTO {
    private Long projectID;
    private String name;
    private String description;
    private Integer price;
    private Integer count;
}
