package kr.yp_crowdfunding.view;

import kr.yp_crowdfunding.persistence.dto.UserDTO;

import java.util.List;

public class UserView {

    public void printAll(List<UserDTO> dtos) {
        System.out.println("All users");
        for (UserDTO dto : dtos) {
            System.out.println("dto.toString() = " + dto.toString());
        }
    }
}
