package com.yj.domain.dao;

import com.yj.domain.dto.UserVO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserDaoTest {

    private static final Logger log = Logger.getLogger(UserDaoTest.class.getName());

    @Autowired
    UserDao userDao;

    @Test
    public void selectListTest() {
        try {
            List<UserVO> result = userDao.selectList();

            assertNotEquals(0, result.size());
            for(UserVO user : result) {
                log.info(user.toString());
            }

        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void selectByIdTest(){
        try {
            UserVO userExist = userDao.selectById(1L);
            assertNotNull(userExist);

            UserVO userNotExist = userDao.selectById(123123L);
            assertNull(userNotExist);

        } catch (SQLException e) {
            fail(e.getMessage());
        }
    }

}