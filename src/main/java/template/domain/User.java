package template.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Michael Sta. Helena on 30/05/2017.
 */
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "CONFIG")
    private ConfigEnum config;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP")
    private Date timestamp;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ConfigEnum getConfig() {
        return config;
    }

    public void setConfig(ConfigEnum config) {
        this.config = config;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
