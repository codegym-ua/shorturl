package ua.codegym.shorturl.dao;

import org.hibernate.SessionFactory;
import ua.codegym.shorturl.model.UrlRecord;

public class UrlDao extends AbstractDao<UrlRecord>{

  public UrlDao(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
