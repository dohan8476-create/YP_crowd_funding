package kr.yp_crowdfunding.persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class FundDTO {
    private Long userID;
    private Long projectID;
    private String rewardName;
    private Date date;
}
