package com.wxt.payment.job;

import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 支付成功消息重试job
 */
@Component
public class PaySuccessMsgRetryJob implements SimpleJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaySuccessMsgRetryJob.class);

    @Override
    public void execute(ShardingContext shardingContext) {

        LOGGER.info("PaySuccessMsgRetryJob is running：time-{}",System.currentTimeMillis());

    }
}
