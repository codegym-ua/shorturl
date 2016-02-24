package ua.codegym.shorturl.application;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ua.codegym.shorturl.config.Config;
import ua.codegym.shorturl.dao.UrlDao;
import ua.codegym.shorturl.model.UrlRecord;
import ua.codegym.shorturl.resource.UrlResource;

public class Service extends Application<Config> {

  private final HibernateBundle<Config> hibernate = new HibernateBundle<Config>(
      UrlRecord.class) {

    @Override
    public DataSourceFactory getDataSourceFactory(Config config) {
      return config.getDataSourceFactory();
    }
  };

  public static void main(String[] arg) throws Exception {
    new Service().run(arg);
  }

  @Override
  public void initialize(Bootstrap<Config> configBootstrap) {
    configBootstrap.addBundle(hibernate);
    configBootstrap.addBundle(new AssetsBundle("/assets", "/html/", "index.html"));
  }

  @Override
  public void run(Config config, Environment env) throws Exception {

    UrlDao urlDao = new UrlDao(hibernate.getSessionFactory());
    env.jersey().register(new UrlResource(urlDao));
  }
}
