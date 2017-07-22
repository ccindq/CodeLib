package com.cc.utils.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author changcheng
 * @version 2017/7/22
 * @description
 */
public class RoutingDataSouce extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceSwitch.getKey();
    }
}
