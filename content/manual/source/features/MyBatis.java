import com.haulmont.cuba.core.global.UuidProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.*;

public class UUIDTypeHandler implements TypeHandler {

    @Override
    public void setParameter(PreparedStatement ps, int i, Object parameter, JdbcType jdbcType) throws SQLException {
        ps.setObject(i, parameter, Types.OTHER);
    }

    @Override
    public Object getResult(ResultSet rs, String columnName) throws SQLException {
        String val = rs.getString(columnName);
        if (val != null) {
            return UuidProvider.fromString(val);
        } else {
            return null;
        }
    }

    @Override
    public Object getResult(ResultSet rs, int columnIndex) throws SQLException {
        String val = rs.getString(columnIndex);
        if (val != null) {
            return UuidProvider.fromString(val);
        } else {
            return null;
        }
    }

    @Override
    public Object getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String val = cs.getString(columnIndex);
        if (val != null) {
            return UuidProvider.fromString(val);
        } else {
            return null;
        }
    }
}