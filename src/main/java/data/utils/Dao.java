package data.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface Dao<T> {

    public List<T> get() throws Exception;

    public Integer insert(T data) throws Exception;

    public Integer delete(T data) throws Exception;

    public Integer update(T data) throws Exception;

    Session createSession(SessionFactory factory);
}
