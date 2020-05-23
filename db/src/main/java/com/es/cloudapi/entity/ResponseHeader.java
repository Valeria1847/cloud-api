/*
 * Copyright (c) E-System LLC - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by E-System team (https://ext-system.com), 2020
 */

package com.es.cloudapi.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "response_header")
public class ResponseHeader {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(name = "response", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ResponseHeader responseHeader;
    private String key;
    private String value;

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public ResponseHeader getResponseHeader() { return responseHeader; }

    public void setResponseHeader(ResponseHeader responseHeader) { this.responseHeader = responseHeader; }

    public String getKey() { return key; }

    public void setKey(String key) { this.key = key; }

    public String getValue() { return value; }

    public void setValue(String value) { this.value = value; }

    @Override
    public int hashCode() { return Objects.hashCode(id); }

    @Override
    public boolean equals(Object object) {
        return (object instanceof ResponseHeader) && Objects.equals(id, ((ResponseHeader) object).id);
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
               "id=" + id +
               ", responseHeader=" + responseHeader +
               ", key='" + key + '\'' +
               ", value='" + value + '\'' +
               '}';
    }
}
