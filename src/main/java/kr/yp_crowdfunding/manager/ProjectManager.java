package kr.yp_crowdfunding.manager;

import kr.yp_crowdfunding.service.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProjectManager {
    private final UserService userService;
    private final ProjectService projectService;
    private final CategoryService categoryService;
    private final LikeService likeService;
    private final FundService fundService;
    private final ReviewService reviewService;
    private final FailReasonService failReasonService;
    private final RewardService rewardService;

}
