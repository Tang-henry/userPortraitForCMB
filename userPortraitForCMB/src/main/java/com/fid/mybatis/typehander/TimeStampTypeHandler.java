package com.fid.mybatis.typehander;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class TimeStampTypeHandler extends BaseTypeHandler<Long> {
	public void setNonNullParameter(PreparedStatement ps, int i, Long parameter, JdbcType jdbcType)
			throws SQLException {
		if (parameter != null)
			ps.setTimestamp(i, new Timestamp(parameter));
		else
			ps.setTimestamp(i, null);
	}

	public Long getNullableResult(ResultSet rs, String columnName) throws SQLException {
		Timestamp time = rs.getTimestamp(columnName);
		if (rs.wasNull()) {
			return null;
		}
		if (time != null) {
			return time.getTime();
		}
		return null;
	}

	public Long getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		Timestamp time = cs.getTimestamp(columnIndex);
		if (cs.wasNull()) {
			return null;
		}
		if (time != null) {
			return time.getTime();
		}
		return null;
	}

	public Long getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		Timestamp time = rs.getTimestamp(columnIndex);
		if (rs.wasNull()) {
			return null;
		}
		if (time != null) {
			return time.getTime();
		}
		return null;
	}
}
