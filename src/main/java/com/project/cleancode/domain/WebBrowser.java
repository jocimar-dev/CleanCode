package com.project.cleancode.domain;

import com.project.cleancode.domain.enums.BrowserName;

public class WebBrowser {

    private BrowserName name;
    private Integer majorVersion;

    public WebBrowser(BrowserName name,
                      Integer majorVersion) {
        this.name = name;
        this.majorVersion = majorVersion;
    }

    public BrowserName getName() {
        return name;
    }

    public Integer getMajorVersion() {
        return majorVersion;
    }
}
