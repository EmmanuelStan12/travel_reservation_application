package data.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public interface Dao<T> {

    public List<T> get();

    public Integer insert(T data);

    public Integer delete(T data);

    public Integer update(T data);

    Session createSession(SessionFactory factory);
}
