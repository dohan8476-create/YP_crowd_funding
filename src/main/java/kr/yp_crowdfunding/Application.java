package kr.yp_crowdfunding;

import kr.yp_crowdfunding.manager.ProjectManager;
import kr.yp_crowdfunding.persistence.dao.*;
import kr.yp_crowdfunding.service.*;

import java.sql.SQLException;


public class Application implements AutoCloseable{

    private final PooledDataSource dataSource;
    private final ProjectManager projectManager;

    public Application(){
        dataSource = new PooledDataSource();
        projectManager = initializeManager();
    }


    public void start() throws SQLException{
        //TODO
    }


    private ProjectManager initializeManager(){
        return new ProjectManager(
                new UserService(new UsersDAO(dataSource.getDataSource())),
                new ProjectService(new ProjectsDAO(dataSource.getDataSource())),
                new CategoryService(new CategoriesDAO(dataSource.getDataSource())),
                new LikeService(new LikesDAO(dataSource.getDataSource())),
                new FundService(new FundsDAO(dataSource.getDataSource())),
                new ReviewService(new ReviewsDAO(dataSource.getDataSource())),
                new FailReasonService(new FailReasonsDAO(dataSource.getDataSource())),
                new RewardService(new RewardsDAO(dataSource.getDataSource()))
        );
    }



    @Override
    public void close() throws SQLException {
        dataSource.close();
    }
}
