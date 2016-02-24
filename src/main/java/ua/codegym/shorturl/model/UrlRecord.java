package ua.codegym.shorturl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "URLS")
public class UrlRecord {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @NotNull
  @Column(name = "SHORT_URL", columnDefinition = "char(64)")
  private String shortUrl;

  @NotNull
  @Column(name = "FULL_URL")
  private String fullUrl;

  public UrlRecord() {
  }

  public UrlRecord(
      String shortUrl,
      String fullUrl) {

    this.shortUrl = checkNotNull(shortUrl, "SHORT_URL could not be NULL.");
    this.fullUrl = checkNotNull(fullUrl, "FULL_URL could not be NULL.");
  }

  public Long getId() {
    return id;
  }

  public String getShortUrl() {
    return shortUrl;
  }

  public String getFullUrl() {
    return fullUrl;
  }
}
