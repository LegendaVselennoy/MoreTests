package ch8.configurations;

import test.ch8.configurations.Configuration;

public class MockConfiguration implements Configuration {\

    public void setSQL(String sqlString) {
    }


    public String getSQL(String sqlString) {
        return null;
    }
}
