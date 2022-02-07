create DATABASE IF NOT EXISTS wxt_payment;

CREATE TABLE wxt_payment.`pay_order` (
                                         `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '应用ID(商户ID)',
                                         `userId` varchar(255) DEFAULT '0' COMMENT '付款用户Id',
                                         `appId` varchar(255) NOT NULL DEFAULT '0' COMMENT '应用ID',
                                         `assetCode` varchar(255) NOT NULL,
                                         `assetContent` varchar(255) NOT NULL,
                                         `tradeAmount` decimal(10,2) NOT NULL,
                                         `outTradeNo` varchar(255) NOT NULL DEFAULT '0' COMMENT '商户订单号',
                                         `payOrderNo` varchar(255) NOT NULL DEFAULT '0' COMMENT '支付流水号',
                                         `payStatus` tinyint NOT NULL DEFAULT '1' COMMENT '支付状态 1：待支付 2：支付中 3：支付成功，4：支付失败',
                                         `remark` varchar(255) DEFAULT NULL COMMENT '订单描述',
                                         `paySuccessTime` datetime DEFAULT NULL,
                                         `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                         `timeModified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                         PRIMARY KEY (`id`),
                                         UNIQUE KEY `uk_outTradeNo` (`outTradeNo`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;



create DATABASE IF NOT EXISTS wxt_account;
CREATE TABLE wxt_account.`account` (
                                       `id` bigint NOT NULL,
                                       `userId` varchar(255) NOT NULL,
                                       `totalAmount` decimal(10,0) NOT NULL,
                                       `frozenAmount` decimal(10,0) NOT NULL,
                                       `balance` decimal(10,0) NOT NULL,
                                       `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                       `timeModified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                       PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


CREATE TABLE wxt_account.`pay_record` (
                                          `id` bigint NOT NULL,
                                          `accountId` bigint NOT NULL,
                                          `outTradeNo` varchar(255) NOT NULL,
                                          `tradeAmount` decimal(10,0) NOT NULL,
                                          `status` tinyint NOT NULL,
                                          `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                          `timeModified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                          PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


create DATABASE IF NOT EXISTS wxt_market;

CREATE TABLE wxt_market.`red_envelope` (
                                           `id` bigint unsigned NOT NULL AUTO_INCREMENT,
                                           `userId` varchar(255) NOT NULL,
                                           `redEnvelopeId` varchar(255) NOT NULL,
                                           `amount` decimal(10,0) NOT NULL,
                                           `status` tinyint NOT NULL COMMENT '1:可使用 2：使用中 3：已使用',
                                           `payOrderNo` varchar(255) DEFAULT NULL COMMENT '支付单号',
                                           `paySuccessTime` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                           `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                           `timemodified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                           PRIMARY KEY (`id`),
                                           UNIQUE KEY `ux_redEnvelopeId` (`redEnvelopeId`) USING BTREE,
                                           KEY `idx_userId` (`userId`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;




create DATABASE IF NOT EXISTS wxt_limit;

CREATE TABLE wxt_limit.`employee_limit` (
                                            `id` bigint NOT NULL,
                                            `userId` int DEFAULT NULL,
                                            `totalAmount` decimal(10,2) NOT NULL,
                                            `frozenAmount` decimal(10,2) NOT NULL,
                                            `balance` decimal(10,2) NOT NULL,
                                            `status` tinyint NOT NULL,
                                            `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                            `timeModified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

CREATE TABLE wxt_limit.`pay_record` (
                                        `id` bigint NOT NULL,
                                        `employeelimitId` int NOT NULL,
                                        `outTradeNo` varchar(255) DEFAULT NULL,
                                        `status` tinyint DEFAULT NULL COMMENT '1:待支付 2：支付中 3：支付成功 4：支付失败',
                                        `tradeAmount` decimal(10,2) DEFAULT NULL,
                                        `timeCreated` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                        `timeModified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
                                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;


create DATABASE IF NOT EXISTS wxt_order;
