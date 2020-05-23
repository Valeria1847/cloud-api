package com.es.cloudapi.entity;

import com.es.cloudapi.entity.access.Person;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "response")
public class Response {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean active = true;
    @JoinColumn(name = "person", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Person person;
    private String type;
    private String url;
    private int code;
    private String body;
    @Column(name = "date_add", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Person getPerson() { return person; }

    public void setPerson(Person person) { this.person = person; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public int getCode() { return code; }

    public void setCode(int code) { this.code = code; }

    public String getBody() { return body; }

    public void setBody(String body) { this.body = body; }

    public Date getDateAdd() { return dateAdd; }

    public void setDateAdd(Date dateAdd) { this.dateAdd = dateAdd; }

    @Override
    public int hashCode() { return Objects.hashCode(id); }

    @Override
    public boolean equals(Object object) {
        return (object instanceof Response) && Objects.equals(id, ((Response) object).id);
    }

    @Override
    public String toString() {
        return "Response{" +
               "id=" + id +
               ", active=" + active +
               ", person=" + person +
               ", type='" + type + '\'' +
               ", url='" + url + '\'' +
               ", code=" + code +
               ", body='" + body + '\'' +
               ", dateAdd=" + dateAdd +
               '}';
    }
}
