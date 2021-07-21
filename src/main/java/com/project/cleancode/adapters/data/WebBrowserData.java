package com.project.cleancode.adapters.data;

import com.project.cleancode.domain.enums.BrowserName;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Embeddable
public class WebBrowserData {

    @Id
    private Long id;
    private BrowserName name;
    private Integer majorVersion;

    public WebBrowserData(BrowserName name,
                          Integer majorVersion) {
        this.name = name;
        this.majorVersion = majorVersion;
    }

    @Deprecated
    public WebBrowserData() {

    }

    public BrowserName getName() {
        return name;
    }

    public Integer getMajorVersion() {
        return majorVersion;
    }
}
