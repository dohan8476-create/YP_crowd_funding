package kr.yp_crowdfunding.persistence.dao;

import lombok.RequiredArgsConstructor;

import javax.sql.DataSource;

@RequiredArgsConstructor
public abstract class DAO {
    protected final DataSource dataSource;
}
