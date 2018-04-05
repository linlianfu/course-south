package priv.llf.ability.course.south.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Eleven
 * @Since: 2018/4/5 14:08
 * @Description:
 *
 *
 * propagation="REQUIRES_NEW"，告诉Spring不管上下文是否有事务，
 * @see LogServiceImpl#saveLog 被调用时都要求一个完全新的只属于Log Service自己的事务。
 * 通过该事务策略，Log Service可以独立的记录日志信息，不再受到业务逻辑事务的干扰。
 */
@Slf4j
@Service
public class LogServiceImpl implements ILogService {


    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void saveLog(String msg) {
        log.info("保存日志需要在一个事物上下文执行，入参：{}",msg);
        int i = 0;
        int j = 0;
        int c = i + j;
        if (c==0){
            throw new RuntimeException("手动抛出异常");
        }
    }
}
