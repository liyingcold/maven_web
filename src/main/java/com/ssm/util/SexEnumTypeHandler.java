package com.ssm.util;

import com.ssm.pojo.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTypeHandler implements TypeHandler<SexEnum> {

    /**
     * //    SexEnumTypeHandler通过preparedStatement，设置sql参数
     * @param preparedStatement         sql对象
     * @param i                         参数在sql的下标
     * @param sexEnum                   参数
     * @param jdbcType                  数据库类型
     * @throws SQLException             异常
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i,sexEnum.getId());
    }

    /**
     * 从JDBC结果集中获取数据进行转换
     * @param resultSet     结果集
     * @param s             列名
     * @return              转换后的数据
     * @throws SQLException 异常
     */
    @Override
    public SexEnum getResult(ResultSet resultSet, String s) throws SQLException {
//        通过列名得到这一列的结果的id
        int id=resultSet.getInt(s);
//        将返回的id传入，得到性别
        return SexEnum.getSexById(id);
    }

    /**
     * 从JDBC结果集中获取数据进行转换
     * @param resultSet     结果集
     * @param i             下标
     * @return
     * @throws SQLException
     */
    @Override
    public SexEnum getResult(ResultSet resultSet, int i) throws SQLException {
        int id=resultSet.getInt(i);
        return SexEnum.getSexById(1);
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int i) throws SQLException {
        int id=callableStatement.getInt(i);
        return SexEnum.getSexById(id);
    }
}
